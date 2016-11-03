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
import com.gearcode.feawap.domain.News;
import com.gearcode.feawap.domain.NewsExample;
import com.gearcode.feawap.domain.NewsExample.Criteria;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.NewsMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/news")
public class NewsController {
    private static final Log logger = LogFactory.getLog(NewsController.class);

    @Value("${upload.preview}")
    private String uploadPreview;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private NewsMapper newsMapper;
    

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//
		Integer category = ServletRequestUtils.getIntParameter(request, "category",1);
		NewsExample newsExample = new NewsExample();
		Criteria criteria = newsExample.createCriteria();
		criteria.andCategoryEqualTo(category);
		carouselExample.setOrderByClause("sort desc,created desc");
		List<News> list = newsMapper.selectByExample(newsExample);
		request.setAttribute("list", list);
		logger.debug(category);
		request.setAttribute("category", category);
		return "news/index";
	}

	@RequestMapping("detail")
	public String detail(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		Integer id;
		try {
			id = ServletRequestUtils.getIntParameter(request, "id");
			NewsExample newsExample = new NewsExample();
			Criteria criteria = newsExample.createCriteria();
			criteria.andIdEqualTo(id);
			List<News> list = newsMapper.selectByExampleWithBLOBs(newsExample);
			if(list.size()>0){
				News item = list.get(0);
				String content = HtmlContentUtils.parseImgSrc(item.getContent(), uploadPreview);
				item.setContent(content);
				request.setAttribute("item", item);
			}
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return "news/detail";
	}
    
}
