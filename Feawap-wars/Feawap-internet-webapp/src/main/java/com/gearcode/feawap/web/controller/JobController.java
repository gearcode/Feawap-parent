package com.gearcode.feawap.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gearcode.feawap.domain.Applicant;
import com.gearcode.feawap.domain.Carousel;
import com.gearcode.feawap.domain.CarouselExample;
import com.gearcode.feawap.domain.Recuitment;
import com.gearcode.feawap.domain.RecuitmentExample;
import com.gearcode.feawap.domain.RecuitmentExample.Criteria;
import com.gearcode.feawap.persistence.ApplicantMapper;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.RecuitmentMapper;
import com.gearcode.feawap.util.FileUploadUtils;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/job")
public class JobController {
    private static final Log logger = LogFactory.getLog(JobController.class);

    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Value("${upload.root}")
    private String uploadRoot;

    @Resource
    private CarouselMapper carrouselMapper;
    
    @Resource
    private RecuitmentMapper recuitmentMapper;
    
    @Resource
    private ApplicantMapper applicantMapper;
    

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//
		RecuitmentExample recuitmentExample = new RecuitmentExample();
		Criteria criteria = recuitmentExample.createCriteria();
		Date now = new Date(System.currentTimeMillis());
		criteria.andStartLessThan(now).andEndGreaterThan(now);
		carouselExample.setOrderByClause("start desc,end desc,id desc");
		List<Recuitment> list = recuitmentMapper.selectByExample(recuitmentExample);
		request.setAttribute("list", list);
		return "job/index";
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
			RecuitmentExample recuitmentExample = new RecuitmentExample();
			Criteria criteria = recuitmentExample.createCriteria();
			criteria.andIdEqualTo(id);
			List<Recuitment> list = recuitmentMapper.selectByExampleWithBLOBs(recuitmentExample);
			if(list.size()>0){
				Recuitment item = list.get(0);
				String description = HtmlContentUtils.parseImgSrc(item.getDescription(), uploadPreview);
				item.setDescription(description);
				logger.debug(item.getStart());
				logger.debug(item.getEnd());
				request.setAttribute("item", item);
			}
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return "job/detail";
	}
	
	@RequestMapping("join")
//	@ResponseBody
	public Object join(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String submit = ServletRequestUtils.getStringParameter(request, "submit",null);
			Integer id;
			try {
				id = ServletRequestUtils.getIntParameter(request, "id");
				if(submit==null){
					request.setAttribute("id", id);
//					RecuitmentExample recuitmentExample = new RecuitmentExample();
//					Criteria criteria = recuitmentExample.createCriteria();
//					criteria.andIdEqualTo(id);
//					List<Recuitment> list = recuitmentMapper.selectByExampleWithBLOBs(recuitmentExample);
//					if(list.size()>0){
//						Recuitment item = list.get(0);
//						String description = HtmlContentUtils.parseImgSrc(item.getDescription(), uploadPreview);
//						item.setDescription(description);
//						request.setAttribute("item", item);
//					}
				}
				else {
					//TODO 获取申请信息
					String realname = ServletRequestUtils.getStringParameter(request, "realname",null);
					Integer gender = ServletRequestUtils.getIntParameter(request, "gender",0);
					String mobile = ServletRequestUtils.getStringParameter(request, "mobile",null);
					String email = ServletRequestUtils.getStringParameter(request, "email",null);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String biyeshijianStr = ServletRequestUtils.getStringParameter(request, "biyeshijian",null);
					Date biyeshijian;
					try {
						biyeshijian = df.parse(biyeshijianStr);
					} catch (ParseException e) {
						biyeshijian = null;
						e.printStackTrace();
					}
					String biyexuexiao = ServletRequestUtils.getStringParameter(request, "biyexuexiao",null);
					Integer xueli = ServletRequestUtils.getIntParameter(request, "xueli",0);
					String zhuanye = ServletRequestUtils.getStringParameter(request, "zhuanye",null);
					Integer gongzuonianxian = ServletRequestUtils.getIntParameter(request, "gongzuonianxian",0);
					String chengshi = ServletRequestUtils.getStringParameter(request, "chengshi",null);
					String daogangshijian = ServletRequestUtils.getStringParameter(request, "daogangshijian",null);
					
					Applicant applicant = new Applicant();
					applicant.setRecuitmentId(id);
					applicant.setName(realname);
					applicant.setGender(gender);
					applicant.setCellphone(mobile);
					applicant.setEmail(email);
					applicant.setGraduationTime(biyeshijian);
					applicant.setGraduateInstitutions(biyexuexiao);
					applicant.setProfessional(zhuanye);
					applicant.setHighestDegree(xueli);
					applicant.setExperience(gongzuonianxian);
					applicant.setCity(chengshi);
					applicant.setInductionTime(daogangshijian);
					//上传照片
					MultipartFile photo = ((MultipartHttpServletRequest)request).getFile("file");
					if(photo!=null){
						try {
							String filename = FileUploadUtils.uploadRandomName(photo, uploadRoot+"/resume");
							applicant.setResumePic(filename);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					applicantMapper.insert(applicant);
					return "common/success";
				}
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
			return "job/join";
	}
    
}
