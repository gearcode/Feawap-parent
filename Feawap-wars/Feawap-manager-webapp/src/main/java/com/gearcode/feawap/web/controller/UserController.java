package com.gearcode.feawap.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gearcode.feawap.domain.User;
import com.gearcode.feawap.domain.UserExample;
import com.gearcode.feawap.persistence.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);
    
    private static final Integer PageSize = 10;
    
    @Resource
    private UserMapper userMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		UserExample example = new UserExample();
		example.setOrderByClause("created desc");

		//分页
		int page = ServletRequestUtils.getIntParameter(request, "page", 1);
		RowBounds rowBounds = new RowBounds((page-1) * PageSize, PageSize);
		
		//查询列表
		List<User> list = userMapper.selectByExampleWithRowbounds(example, rowBounds);
		request.setAttribute("list", list);
		
		//查询总数
		int total = userMapper.countByExample(example);
		request.setAttribute("total", total);
		
		// total page
		request.setAttribute("totalPage", (total + PageSize - 1) / PageSize);
		
		return "user/index";
	}
}
