package com.gearcode.feawap.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.gearcode.feawap.domain.Train;
import com.gearcode.feawap.domain.TrainExample;
import com.gearcode.feawap.domain.TrainNews;
import com.gearcode.feawap.domain.TrainNewsExample;
import com.gearcode.feawap.domain.TrainNewsExample.Criteria;
import com.gearcode.feawap.domain.TrainSign;
import com.gearcode.feawap.domain.User;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.persistence.TrainMapper;
import com.gearcode.feawap.persistence.TrainNewsMapper;
import com.gearcode.feawap.persistence.TrainSignMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/train")
public class TrainController extends BaseController{

    private static final Log logger = LogFactory.getLog(TrainController.class);

    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private CarouselMapper carrouselMapper;

    @Resource
    private TrainNewsMapper trainNewsMapper;
    
    @Resource
    private TrainSignMapper trainSignMapper;
    
    @Resource
    private TrainMapper trainMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		return "train/index";
	}
	
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		Integer type = ServletRequestUtils.getIntParameter(request, "type",1);
		TrainExample trainExample = new TrainExample();
		com.gearcode.feawap.domain.TrainExample.Criteria criteria = trainExample.createCriteria();
		Date beginDate = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
		try {
			String stringDate = df.format(beginDate);
			beginDate = df.parse(stringDate.substring(0,4)+"-1-1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		criteria.andTypeEqualTo(type);
		criteria.andStartGreaterThanOrEqualTo(beginDate);
		trainExample.setOrderByClause("start asc");
		Map<Integer, Map<Integer, List<Train>>> monthMap = new HashMap<Integer, Map<Integer, List<Train>>>();
		List<Train> list = trainMapper.selectByExample(trainExample);
		for (Train train : list) {
			String[] ymd = df.format(train.getStart()).split("-");
			Integer month = Integer.parseInt(ymd[1]);
			Integer date = Integer.parseInt(ymd[2]);
			Map<Integer, List<Train>> dayMap = monthMap.get(month);
			if(dayMap==null){
				monthMap.put(month, dayMap = new HashMap<Integer, List<Train>>());
			}
			List<Train> dayList = dayMap.get(date);
			if(dayList==null){
				dayMap.put(date, dayList = new ArrayList<Train>());
			}
			dayList.add(train);
		}
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		request.setAttribute("currentMonth", currentMonth);//当前月份
		request.setAttribute("currentDay", currentDay);//当前日
		request.setAttribute("monthMap", monthMap);
		if(type==3){
			request.setAttribute("title", "专题研讨会");
		}
		else if (type==2){
			request.setAttribute("title", "线下培训");
		}
		else {//type==1
			request.setAttribute("title", "线上培训");
		}
		return "train/list";
	}
	@RequestMapping("detail")
	public String detail(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		int id = ServletRequestUtils.getIntParameter(request, "id", 0);
		TrainExample trainExample = new TrainExample();
		TrainExample.Criteria criteria = trainExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<Train> list = trainMapper.selectByExampleWithBLOBs(trainExample);
		if(list.size()>0){
			Train item = list.get(0);
			String description = HtmlContentUtils.parseImgSrc(item.getDescription(), uploadPreview);
			item.setDescription(description);
			request.setAttribute("item", item);
		}
		return "train/detail";
	}
	@RequestMapping("sign")
	public String sign(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User user = this.getLoginedUser(request);
		if(user==null){
			return this.requireLogin(request);
		}
		request.setAttribute("preview", uploadPreview);
		int id = ServletRequestUtils.getIntParameter(request, "id", 0);
		TrainExample trainExample = new TrainExample();
		TrainExample.Criteria criteria = trainExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<Train> list = trainMapper.selectByExampleWithBLOBs(trainExample);
		Train train = null;
		if(list.size()>0){
			train = list.get(0);
			String description = HtmlContentUtils.parseImgSrc(train.getDescription(), uploadPreview);
			train.setDescription(description);
			request.setAttribute("item", train);
		}
		else {
			request.setAttribute("message", "不存在");
			return "common/error";
		}
		String submit = ServletRequestUtils.getStringParameter(request, "submit", null);
		if(submit==null){
			return "train/sign";
		}
		else{
			int step = ServletRequestUtils.getIntParameter(request, "step", 0);
			TrainSign record = null;
			if(step<2){
				record = new TrainSign();
				record.setUserId(user.getId());
				record.setTrainId(id);
				try {
					record.setPeoples(ServletRequestUtils.getIntParameter(request, "peoples"));
				} catch (ServletRequestBindingException e) {
					request.setAttribute("message", "报名人数应为数字");
					return "common/error";
				}
				record.setCompany(ServletRequestUtils.getStringParameter(request, "company",""));
				record.setCompanyType(ServletRequestUtils.getStringParameter(request, "company_type",""));
				record.setIndustry(ServletRequestUtils.getStringParameter(request, "industry",""));
				record.setWorkAddress(ServletRequestUtils.getStringParameter(request, "work_address",""));
				record.setDepartment(ServletRequestUtils.getStringParameter(request, "department",""));
				record.setWorkPosition(ServletRequestUtils.getStringParameter(request, "work_position",""));
				record.setResearchTarget(ServletRequestUtils.getStringParameter(request, "research_target",""));
				record.setSoftware(ServletRequestUtils.getStringParameter(request, "software",""));
				record.setConcern(ServletRequestUtils.getStringParameter(request, "concern",""));
			}
			else {
				record = (TrainSign)request.getSession().getAttribute("trainSign");
			}
			if(train.getType()==2){
				if(step!=2){
					request.getSession().setAttribute("trainSign", record);
					return "train/assist";
				}
				else {
					record.setVehicle(ServletRequestUtils.getStringParameter(request, "vehicle",""));
					record.setShift(ServletRequestUtils.getStringParameter(request, "shift",""));
					record.setHotel(ServletRequestUtils.getStringParameter(request, "hotel",""));
					record.setStar(ServletRequestUtils.getStringParameter(request, "star",""));
					record.setCellphone(ServletRequestUtils.getStringParameter(request, "cellphone",""));
					request.setAttribute("go", -3);
				}
			}
			else if(train.getType()==3){
				//TODO 专题研讨会
				request.setAttribute("message", "TODO:专题研讨会");
				return "common/error";
			}
			else {
				request.setAttribute("go", -2);
			}
			//TODO waiting for dao
			record.setCreated(new Date(System.currentTimeMillis()));
			trainSignMapper.insert(record);
			return "common/success";
		}
	}
	
	@RequestMapping("news-list")
	public String newsList(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		//
		TrainNewsExample newsExample = new TrainNewsExample();
//		Criteria criteria = newsExample.createCriteria();
		carouselExample.setOrderByClause("sort desc,created desc");
		List<TrainNews> list = trainNewsMapper.selectByExample(newsExample);
		request.setAttribute("list", list);
		return "train/news-list";
	}

	@RequestMapping("news-detail")
	public String newsDetail(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("preview", uploadPreview);
		//轮播广告
		CarouselExample carouselExample = new CarouselExample();
		carouselExample.setOrderByClause("id desc");
		List<Carousel> carouselList = carrouselMapper.selectByExample(carouselExample);
		request.setAttribute("carouselList", carouselList);
		Integer id;
		try {
			id = ServletRequestUtils.getIntParameter(request, "id");
			TrainNewsExample newsExample = new TrainNewsExample();
			Criteria criteria = newsExample.createCriteria();
			criteria.andIdEqualTo(id);
			List<TrainNews> list = trainNewsMapper.selectByExampleWithBLOBs(newsExample);
			if(list.size()>0){
				TrainNews item = list.get(0);
				String content = HtmlContentUtils.parseImgSrc(item.getContent(), uploadPreview);
				item.setContent(content);
				request.setAttribute("item", item);
			}
		} catch (ServletRequestBindingException e) {
			e.printStackTrace();
		}
		return "train/news-detail";
	}
}
