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
import com.gearcode.feawap.domain.Consultation;
import com.gearcode.feawap.domain.ConsultationExample;
import com.gearcode.feawap.domain.ConsultationExample.Criteria;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.ConsultationMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {
    private static final Log logger = LogFactory.getLog(ConsultationController.class);

    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private ConsultationMapper consultationMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample example = new CarouselExample();
		example.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(example);
		request.setAttribute("carouselList", carouselList);
		
		//
		List<Consultation> consultationList = consultationMapper.selectByExample(new ConsultationExample());
		List<Consultation> hangyeList = new ArrayList<Consultation>();
		List<Consultation> xuekeList = new ArrayList<Consultation>();
		for (Consultation consultation : consultationList) {
			switch (consultation.getCategory()) {
			case 1:
				hangyeList.add(consultation);
				break;
			case 2:
				xuekeList.add(consultation);
			default:
				break;
			}
		}
		request.setAttribute("hangyeList", hangyeList);
		request.setAttribute("xuekeList", xuekeList);
		return "consultation/index";
	}

	@RequestMapping("detail")
	public String detail(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Integer id;
		try {
			id = ServletRequestUtils.getIntParameter(request, "id");
			ConsultationExample example = new ConsultationExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			List<Consultation> list = consultationMapper.selectByExampleWithBLOBs(example);
			if(list.size()>0){
				Consultation item = list.get(0);
				String content = HtmlContentUtils.parseImgSrc(item.getContent(), uploadPreview);
				item.setContent(content);
				request.setAttribute("item", item);
			}
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return "consultation/detail";
	}
    
}
