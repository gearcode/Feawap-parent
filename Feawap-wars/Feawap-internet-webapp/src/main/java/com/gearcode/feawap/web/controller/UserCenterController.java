package com.gearcode.feawap.web.controller;

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
import com.gearcode.feawap.domain.Train;
import com.gearcode.feawap.domain.TrainExample;
import com.gearcode.feawap.domain.TrainSign;
import com.gearcode.feawap.domain.TrainSignExample;
import com.gearcode.feawap.domain.User;
import com.gearcode.feawap.domain.UserExample;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.NewsMapper;
import com.gearcode.feawap.persistence.TrainMapper;
import com.gearcode.feawap.persistence.TrainSignMapper;
import com.gearcode.feawap.persistence.UserMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController extends BaseController{
    private static final Log logger = LogFactory.getLog(UserCenterController.class);

    @Value("${upload.preview}")
    private String uploadPreview;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private TrainSignMapper trainSignMapper;

    @Resource
    private TrainMapper trainMapper;
    
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
		if(this.getLoginedUser(request)==null){
			return this.requireLogin(request);
		}
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		return "usercenter/index";
	}


	@RequestMapping("info")
	public String info(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(this.getLoginedUser(request)==null){
			return this.requireLogin(request);
		}
		String submit = ServletRequestUtils.getStringParameter(request, "submit",null);
		if(submit==null){
			User user = (User)request.getSession().getAttribute("user");
			user = userMapper.selectByPrimaryKey(user.getId());
			request.setAttribute("item", user);
			return "usercenter/info";
		}
		else {
			String realname = ServletRequestUtils.getStringParameter(request,"realname",null);
			String mobile = ServletRequestUtils.getStringParameter(request,"mobile",null);
			String email = ServletRequestUtils.getStringParameter(request,"email",null);
			String company = ServletRequestUtils.getStringParameter(request,"company",null);
			String companyType = ServletRequestUtils.getStringParameter(request,"company_type",null);
			String industry = ServletRequestUtils.getStringParameter(request,"industry",null);
			String workAddress = ServletRequestUtils.getStringParameter(request,"work_address",null);
			String department = ServletRequestUtils.getStringParameter(request,"department",null);
			String post = ServletRequestUtils.getStringParameter(request,"post",null);
			String target = ServletRequestUtils.getStringParameter(request,"target",null);
			String software = ServletRequestUtils.getStringParameter(request,"software",null);
			String area = ServletRequestUtils.getStringParameter(request,"area",null);

			User sessionUser = (User)request.getSession().getAttribute("user");
			User user = new User();
			user.setId(sessionUser.getId());
			user.setName(realname);
			user.setCellphone(mobile);
			user.setEmail(email);
			user.setCompany(company);
			user.setCompanyType(companyType);
			user.setIndustry(industry);
			user.setWorkAddress(workAddress);
			user.setDepartment(department);
			user.setPost(post);
			user.setTarget(target);
			user.setSoftware(software);
			user.setArea(area);
			user.setUpdateTime(new Date(System.currentTimeMillis()));
			userMapper.updateByPrimaryKeySelective(user);
			request.setAttribute("url", "/action/");
			return "common/success";
			
		}
	}

	@RequestMapping("password")
	public String password(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if(this.getLoginedUser(request)==null){
			return this.requireLogin(request);
		}
		String submit = ServletRequestUtils.getStringParameter(request, "submit",null);
		if(submit==null){
			return "usercenter/password";
		}
		else {
			User user = (User)request.getSession().getAttribute("user");
			String username = user.getUsername();
			String password = ServletRequestUtils.getStringParameter(request, "password",null);
			String oldPassword = ServletRequestUtils.getStringParameter(request, "oldpassword",null);
			if(password==null||password.isEmpty()){
				request.setAttribute("message", "请输入密码.");
			}
			else if(oldPassword==null||oldPassword.isEmpty()){
				request.setAttribute("message", "请输入旧密码.");
			}
			else if(password.length()<6){
				request.setAttribute("message", "密码最少6位.");
			}
			else {
				UserExample example = new UserExample();
				example.createCriteria().andUsernameEqualTo(username);
				user = userMapper.selectByPrimaryKey(user.getId());
				oldPassword = md5Password(username, oldPassword);
				if(!oldPassword.equals(user.getPassword())){
					request.setAttribute("message", "旧密码错误");
				}
				else {
					password = md5Password(username, password);
					user.setPassword(password);
					user.setUpdateTime(new Date(System.currentTimeMillis()));
					userMapper.updateByPrimaryKeySelective(user);
					request.setAttribute("url", "/action/");
					return "common/success";
				}
			}
			return "common/error";
		}
	}

	@RequestMapping("course")
	public String course(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = this.getLoginedUser(request);
		if(user==null){
			return this.requireLogin(request);
		}
		TrainSignExample signExample = new TrainSignExample();
		TrainSignExample.Criteria signCriteria = signExample.createCriteria();
		signCriteria.andUserIdEqualTo(user.getId());
		//TODO 增加状态判断
//		criteria.and
		signExample.setOrderByClause("created desc");
		List<TrainSign> signList = trainSignMapper.selectByExample(signExample);
		
		TrainExample trainExample = new TrainExample();
		TrainExample.Criteria trainCriteria = trainExample.createCriteria();
		List<Integer> idList = new ArrayList<Integer>();
		String order = "FIELD (id";
		for (TrainSign trainSign : signList) {
			idList.add(trainSign.getTrainId());
			order+=","+trainSign.getTrainId();
		}
		order+=") ASC";
		trainCriteria.andIdIn(idList);
		trainExample.setOrderByClause(order);
		List<Train> trainList = trainMapper.selectByExample(trainExample);
		request.setAttribute("trainList", trainList);
		return "usercenter/course";
	}
	
}
