package com.gearcode.feawap.web.controller;

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
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gearcode.feawap.domain.Carousel;
import com.gearcode.feawap.domain.CarouselExample;
import com.gearcode.feawap.domain.FeedbackCourseInterest;
import com.gearcode.feawap.domain.FeedbackCourseOpinion;
import com.gearcode.feawap.domain.User;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.FeedbackCourseInterestMapper;
import com.gearcode.feawap.persistence.FeedbackCourseOpinionMapper;

@Controller
@RequestMapping("/feedback")
public class FeedbackController extends BaseController{

    private static final Log logger = LogFactory.getLog(FeedbackController.class);

    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private FeedbackCourseInterestMapper feedbackCourseInterestMapper;
    
    @Resource
    private FeedbackCourseOpinionMapper feedbackCourseOpinionMapper;

	@RequestMapping("course-interest")
	public String courseInterest(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = this.getLoginedUser(request);
		if(user==null){
			return this.requireLogin(request);
		}
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//
		String submit = ServletRequestUtils.getStringParameter(request, "submit", null);
		if(submit==null){
			return "feedback/course-interest";
		}
		else{
			FeedbackCourseInterest record = new FeedbackCourseInterest();
			record.setUserId(user.getId());
			record.setCreated(new Date(System.currentTimeMillis()));
			record.setName(ServletRequestUtils.getStringParameter(request, "name",""));
			record.setCellphone(ServletRequestUtils.getStringParameter(request, "cellphone",""));
			record.setEmail(ServletRequestUtils.getStringParameter(request, "email",""));
			record.setCompany(ServletRequestUtils.getStringParameter(request, "company",""));
			record.setDepartment(ServletRequestUtils.getStringParameter(request, "department",""));
			record.setPosition(ServletRequestUtils.getStringParameter(request, "position",""));
			record.setTarget(ServletRequestUtils.getStringParameter(request, "target",""));
			record.setSoftware(ServletRequestUtils.getStringParameter(request, "software",""));
			feedbackCourseInterestMapper.insert(record);
			request.setAttribute("url", "/action/train/");
			request.setAttribute("title", "提交成功！");
			return "common/success";
		}
	}
	
	@RequestMapping("course-opinion")
	public String courseOpinion(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//
		User user = this.getLoginedUser(request);
		if(user==null){
			return this.requireLogin(request);
		}
		request.setAttribute("preview", uploadPreview);
		String submit = ServletRequestUtils.getStringParameter(request, "submit", null);
		if(submit==null){
			return "feedback/course-opinion";
		}
		else{
			FeedbackCourseOpinion record = new FeedbackCourseOpinion();
			record.setUserId(user.getId());
			record.setCreated(new Date(System.currentTimeMillis()));
			record.setContent(ServletRequestUtils.getIntParameter(request, "content",0));//优秀4，良好3，一般2，很差1
			record.setExplicit(ServletRequestUtils.getIntParameter(request, "explicit",0));
			record.setInteresting(ServletRequestUtils.getStringParameter(request, "interesting",""));
			record.setLecturerPlanEvaluation(ServletRequestUtils.getStringParameter(request, "lecturer_plan_evaluation",""));
			record.setCommunication(ServletRequestUtils.getIntParameter(request, "communication",0));
			record.setPrepare(ServletRequestUtils.getIntParameter(request, "prepare",0));
			record.setAttitude(ServletRequestUtils.getIntParameter(request, "attitude",0));
			record.setLecturerEvaluation(ServletRequestUtils.getStringParameter(request, "lecturer_evaluation",""));
			record.setCoursePlanEvaluation(ServletRequestUtils.getStringParameter(request, "course_plan_evaluation",""));
			record.setAttend(ServletRequestUtils.getStringParameter(request, "attend",""));
			feedbackCourseOpinionMapper.insert(record);
			request.setAttribute("url", "/action/train/");
			request.setAttribute("title", "提交成功！");
			return "common/success";
		}
	}
}
