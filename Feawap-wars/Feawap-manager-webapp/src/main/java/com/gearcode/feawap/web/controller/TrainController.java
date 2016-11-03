package com.gearcode.feawap.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gearcode.feawap.domain.Train;
import com.gearcode.feawap.domain.TrainExample;
import com.gearcode.feawap.persistence.TrainMapper;
import com.gearcode.feawap.util.DateUtils;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/train")
public class TrainController {

    private static final Log logger = LogFactory.getLog(TrainController.class);
    
    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
	
    @Resource
    private TrainMapper trainMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		TrainExample example = new TrainExample();
		example.setOrderByClause("created desc");
		List<Train> list = trainMapper.selectByExample(example);
		request.setAttribute("list", list);
		return "train/index";
	}
	
	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			Train record = trainMapper.selectByPrimaryKey(id);
			record.setDescription(HtmlContentUtils.parseImgSrc(record.getDescription(), uploadPreview));
			request.setAttribute("record", record);
		}
		return "train/record";
	}

	
	@RequestMapping("save")
	@ResponseBody
	public Object save(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		
		final int type = ServletRequestUtils.getIntParameter(request, "type_check", 1);
		
		final Date now = new Date();
		String todayStr = DateUtils.formatCnDate(now);
		String dateRange = ServletRequestUtils.getStringParameter(request, "daterange", todayStr + " - " + todayStr);

		final int peoples = ServletRequestUtils.getIntParameter(request, "peoples", 1);
		final int cost = ServletRequestUtils.getIntParameter(request, "cost", 1);
		final String place = ServletRequestUtils.getStringParameter(request, "place", "");
		final String address = ServletRequestUtils.getStringParameter(request, "address", "");
		final String description = ServletRequestUtils.getStringParameter(request, "description", "");
		
		final String[] hotels = ServletRequestUtils.getStringParameters(request, "hotels");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Train record = new Train();
		record.setTitle(title);
		record.setType(type);
		
		if(StringUtils.isEmpty(dateRange)) {
			dateRange = todayStr + " - " + todayStr;
		}
		String[] dateRangeArr = dateRange.split(" - ");
		if(dateRangeArr.length != 2) {
			logger.error("设置培训/专题研讨会的起止时间时出错 " + dateRange);
		} else {
			Date start = DateUtils.parseCnDate(dateRangeArr[0]);
			Date end = DateUtils.parseCnDate(dateRangeArr[1]);
			record.setStart(start);
			record.setEnd(end);
		}
		
		record.setPeoples(peoples);
		record.setCost(cost);
		record.setPlace(place);
		record.setAddress(address);
		record.setDescription(HtmlContentUtils.format(description, uploadPreview));
		record.setHotels(JSON.toJSONString(hotels));
		record.setUpdateTime(now);
		
		if(id > 0) {
			/*
			 * 修改
			 */
			trainMapper.updateByExampleSelective(record, new TrainExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			/*
			 * 新增
			 */
			record.setCreated(now);
			trainMapper.insert(record);
		}
		
		result.put("result", "success");
		result.put("updateTime", record.getUpdateTime());
		
		return result;
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			trainMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/train";
	}
	
}
