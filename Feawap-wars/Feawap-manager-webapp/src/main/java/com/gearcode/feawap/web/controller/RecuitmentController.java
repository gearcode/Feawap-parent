package com.gearcode.feawap.web.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gearcode.feawap.domain.Recuitment;
import com.gearcode.feawap.domain.RecuitmentExample;
import com.gearcode.feawap.persistence.ApplicantMapper;
import com.gearcode.feawap.persistence.RecuitmentMapper;
import com.gearcode.feawap.util.DateUtils;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/recuitment")
public class RecuitmentController {

    private static final Log logger = LogFactory.getLog(RecuitmentController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private RecuitmentMapper recuitmentMapper;
    @Resource
    private ApplicantMapper applicantMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		RecuitmentExample example = new RecuitmentExample();
		example.setOrderByClause("created desc");
		List<Recuitment> list = recuitmentMapper.selectByExample(example);
		request.setAttribute("list", list);
		return "recuitment/index";
	}

	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			Recuitment record = recuitmentMapper.selectByPrimaryKey(id);

			record.setDescription(HtmlContentUtils.parseImgSrc(record.getDescription(), uploadPreview));
			
			request.setAttribute("record", record);
		}
		return "recuitment/record";
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(HttpServletRequest request) {
		Date now = new Date();
		
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		final int count = ServletRequestUtils.getIntParameter(request, "count", 0);
		
		String todayStr = DateUtils.CN_DATE_FORMAT.format(now);
		String dateRange = ServletRequestUtils.getStringParameter(request, "daterange", todayStr + " - " + todayStr);
		
		final String address = ServletRequestUtils.getStringParameter(request, "address", "");
		final String description = ServletRequestUtils.getStringParameter(request, "description", "");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Recuitment record = new Recuitment();
		record.setTitle(title);
		record.setCount(count);
		try {
			if(dateRange.length() == 0) {
				dateRange = todayStr + " - " + todayStr;
			}
			String[] dateRangeArr = dateRange.split(" - ");
			
			if(dateRangeArr.length != 2) {
				logger.error("设置招聘信息的起止时间时出错 " + dateRange);
			} else {
				Date start = DateUtils.CN_DATE_FORMAT.parse(dateRangeArr[0]);
				Date end = DateUtils.CN_DATE_FORMAT.parse(dateRangeArr[1]);
				record.setStart(start);
				record.setEnd(end);
			}
		} catch (ParseException e) {
			logger.error("设置招聘信息的起止时间时出错", e);
		}
		record.setAddress(address);
		record.setDescription(HtmlContentUtils.format(description, uploadPreview));
		record.setUpdateTime(now);
		
		if(id > 0) {
			/*
			 * 修改
			 */
			recuitmentMapper.updateByExampleSelective(record, new RecuitmentExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			/*
			 * 新增
			 */
			record.setCreated(now);
			record.setViews(0L);
			recuitmentMapper.insert(record);
		}
		
		result.put("result", "success");
		result.put("updateTime", record.getUpdateTime());
		
		return result;
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			recuitmentMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/recuitment";
	}

}
