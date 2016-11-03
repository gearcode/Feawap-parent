package com.gearcode.feawap.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gearcode.feawap.domain.Carousel;
import com.gearcode.feawap.domain.CarouselExample;
import com.gearcode.feawap.domain.News;
import com.gearcode.feawap.domain.NewsExample;
import com.gearcode.feawap.domain.NewsExample.Criteria;
import com.gearcode.feawap.domain.User;
import com.gearcode.feawap.domain.UserExample;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.NewsMapper;
import com.gearcode.feawap.persistence.UserMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final Log logger = LogFactory.getLog(IndexController.class);

    @Value("${upload.preview}")
    private String uploadPreview;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private NewsMapper newsMapper;
    
    @Resource
    private UserMapper userMapper;
    
    private static final String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private String md5Password(String username,String password){
    	return md5(md5(username)+"@"+md5(password));
    }

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		return "index";
	}


	@RequestMapping("reg")
	public String reg(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String submit = ServletRequestUtils.getStringParameter(request, "submit",null);
		if(submit==null){
			return "reg";
		}
		else {
			String username = ServletRequestUtils.getStringParameter(request,"username",null);
			String password = ServletRequestUtils.getStringParameter(request,"password",null);
//			String repassword = ServletRequestUtils.getStringParameter(request,"repassword",null);
			String realname = ServletRequestUtils.getStringParameter(request,"realname",null);
//			Integer gender = ServletRequestUtils.getIntParameter(request,"gender",0);
			String mobile = ServletRequestUtils.getStringParameter(request,"mobile",null);
//			String mobileVerify = ServletRequestUtils.getStringParameter(request,"mobileVerify",null);
			String email = ServletRequestUtils.getStringParameter(request,"email",null);
			if(username==null||(username=username.trim()).isEmpty()){
				request.setAttribute("message", "请输入用户名");
			}
			else if(password==null||password.isEmpty()){
				request.setAttribute("message", "请输入密码");
			}
			else if(password.length()<6){
				request.setAttribute("message", "密码最短6位");
			}
			else{
				User user = new User();
				user.setUsername(username);
				UserExample example = new UserExample();
				example.createCriteria().andUsernameEqualTo(username);
				List<User> exists = userMapper.selectByExample(example);
				if(exists.size()!=0){
					request.setAttribute("message", "该用户名已存在");
				}
				else {
					user.setPassword(this.md5Password(username, password));
					user.setName(realname);
					user.setCellphone(mobile);
					user.setEmail(email);
					user.setCreated(new Date(System.currentTimeMillis()));
					int userId = userMapper.insert(user);
					user.setId(userId);
					request.getSession().setAttribute("user", user);
					request.setAttribute("title", "注册成功");
					request.setAttribute("url", "/action/");
					return "common/success";
				}
			}
			return "common/error";
			
		}
	}
	
	@RequestMapping("login")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String submit = ServletRequestUtils.getStringParameter(request, "submit",null);
		if(submit==null){
			String url = ServletRequestUtils.getStringParameter(request, "return","/action/");
			try {
				request.setAttribute("returnUrl", URLEncoder.encode(url,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
			}
			if(request.getSession().getAttribute("user")!=null){
				request.setAttribute("title", "已登录");
				request.setAttribute("url", url);
				return "common/success";
			}
			return "login";
		}
		else {
			String username = ServletRequestUtils.getStringParameter(request, "username",null);
			String password = ServletRequestUtils.getStringParameter(request, "password",null);
			if(username==null||password==null){
				request.setAttribute("message", "请输入正确的用户名和密码.");
			}
			else {
				UserExample example = new UserExample();
				example.createCriteria().andUsernameEqualTo(username);
				List<User> list = userMapper.selectByExample(example);
				if(list.size()!=0){
					User user = list.get(0);
					password = md5Password(username, password);
					if(password.equals(user.getPassword())){
						user.setLastLogin(new Date(System.currentTimeMillis()));
						userMapper.updateByPrimaryKey(user);
						request.getSession().setAttribute("user", user);
						request.setAttribute("title", "登录成功");
						String url = ServletRequestUtils.getStringParameter(request, "return","/action/");
						request.setAttribute("url", url);
						return "common/success";
					}
					else {
						request.setAttribute("message", "密码错误.");
					}
				}
				else{
					request.setAttribute("message", "用户名不存在.");
				}
			}
			return "common/error";
		}
	}
	
	@RequestMapping("logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.getSession().removeAttribute("user");
		request.setAttribute("url", "/action/");
		return "common/success";
	}
    
}
