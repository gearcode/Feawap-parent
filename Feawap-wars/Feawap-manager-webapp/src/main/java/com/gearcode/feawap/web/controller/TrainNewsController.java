package com.gearcode.feawap.web.controller;

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

import com.gearcode.feawap.domain.TrainNews;
import com.gearcode.feawap.domain.TrainNewsExample;
import com.gearcode.feawap.persistence.TrainNewsMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/train/news")
public class TrainNewsController {

    private static final Log logger = LogFactory.getLog(TrainNewsController.class);
    
    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
	
    @Resource
    private TrainNewsMapper trainNewsMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		TrainNewsExample example = new TrainNewsExample();
		example.setOrderByClause("created desc");
		List<TrainNews> list = trainNewsMapper.selectByExample(example);
		request.setAttribute("list", list);
		return "train/news/index";
	}
	
	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			TrainNews record = trainNewsMapper.selectByPrimaryKey(id);
			record.setContent(HtmlContentUtils.parseImgSrc(record.getContent(), uploadPreview));
			request.setAttribute("record", record);
		}
		return "train/news/record";
	}

	
	@RequestMapping("save")
	@ResponseBody
	public Object save(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		final String content = ServletRequestUtils.getStringParameter(request, "content", "");

		final Date now = new Date();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		TrainNews record = new TrainNews(){{
			setTitle(title);
			setContent(HtmlContentUtils.format(content, uploadPreview));
			setUpdateTime(now);
		}};
		
		if(id > 0) {
			/*
			 * 修改
			 */
			trainNewsMapper.updateByExampleSelective(record, new TrainNewsExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			/*
			 * 新增
			 */
			record.setCreated(now);
			trainNewsMapper.insert(record);
		}
		
		result.put("result", "success");
		result.put("updateTime", record.getUpdateTime());
		
		return result;
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			trainNewsMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/train/news";
	}
}
