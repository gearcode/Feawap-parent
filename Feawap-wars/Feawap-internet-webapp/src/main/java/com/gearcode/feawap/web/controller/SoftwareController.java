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
import com.gearcode.feawap.domain.Software;
import com.gearcode.feawap.domain.SoftwareExample;
import com.gearcode.feawap.domain.SoftwareExample.Criteria;
import com.gearcode.feawap.domain.SoftwareWithBLOBs;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.SoftwareMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/software")
public class SoftwareController {
    private static final Log logger = LogFactory.getLog(SoftwareController.class);

    @Value("${upload.preview}")
    private String uploadPreview;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private SoftwareMapper softwareMapper;
    

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample example = new CarouselExample();
		example.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(example);
		request.setAttribute("carouselList", carouselList);
		//
		List<Software> list = softwareMapper.selectByExample(new SoftwareExample());
		request.setAttribute("list", list);
		return "software/index";
	}

	@RequestMapping("detail")
	public String detail(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Integer id;
		try {
			id = ServletRequestUtils.getIntParameter(request, "id");
			SoftwareExample example = new SoftwareExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			List<SoftwareWithBLOBs> list = softwareMapper.selectByExampleWithBLOBs(example);
			if(list.size()>0){
				SoftwareWithBLOBs item = list.get(0);
//				String content = HtmlContentUtils.parseImgSrc(item.getContent(), uploadPreview);
//				item.setContent(content);
				request.setAttribute("item", item);
			}
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return "software/detail";
	}
    
}
