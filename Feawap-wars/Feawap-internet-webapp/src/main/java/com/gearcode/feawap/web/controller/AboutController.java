package com.gearcode.feawap.web.controller;

import java.util.ArrayList;
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
import com.gearcode.feawap.domain.Config;
import com.gearcode.feawap.domain.ConfigExample;
import com.gearcode.feawap.domain.ConfigExample.Criteria;
import com.gearcode.feawap.domain.ConfigWithBLOBs;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.ConfigMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/about")
public class AboutController {
    private static final Log logger = LogFactory.getLog(AboutController.class);

    @Value("${upload.preview}")
    private String uploadPreview;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private ConfigMapper configMapper;
    

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//默认跳到关于我们
		return this.company(model, request, response, session);
	}

	@RequestMapping("company")
	public String company(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//关于我们
		ConfigExample configExample = new ConfigExample();
		Criteria criteria = configExample.createCriteria();
		criteria.andNameEqualTo("company_intro");
		List<ConfigWithBLOBs> list = configMapper.selectByExampleWithBLOBs(configExample);
		if(list.size()>0){
			ConfigWithBLOBs item = list.get(0);
			request.setAttribute("item", item);
		}
		return "about/company";
	}
	@RequestMapping("contact")
	public String contact(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//TODO 联系方式列表
		return "about/contact";
	}
	
	@RequestMapping("join")
	public String join(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//TODO 职位列表
		return "about/join";
	}
    
}
