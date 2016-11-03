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
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gearcode.feawap.domain.News;
import com.gearcode.feawap.domain.NewsExample;
import com.gearcode.feawap.persistence.NewsMapper;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final Log logger = LogFactory.getLog(NewsController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private NewsMapper newsMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int category = ServletRequestUtils.getIntParameter(request, "category", -1);
		int page = ServletRequestUtils.getIntParameter(request, "page", 1);
		int count = ServletRequestUtils.getIntParameter(request, "count", 10);
		
		if(category <= 0) {
			request.setAttribute("errmsg", "新闻分类错误！");
			return "news/index";
		}
		
		NewsExample example = new NewsExample();
		example.createCriteria().andCategoryEqualTo(category);
		example.setOrderByClause("sort asc, update_time desc");
		
		RowBounds rowBounds = new RowBounds((page - 1) * count, count);
		List<News> list = newsMapper.selectByExampleWithRowbounds(example, rowBounds);
		int total = newsMapper.countByExample(example);
		
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		
		return "news/index";
	}

	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		
		if(id > 0) {
			News record = newsMapper.selectByPrimaryKey(id);
			record.setContent(HtmlContentUtils.parseImgSrc(record.getContent(), uploadPreview));
			request.setAttribute("record", record);
		}
		
		return "news/record";
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		final int category = ServletRequestUtils.getIntParameter(request, "category", -1);
		final String content = ServletRequestUtils.getStringParameter(request, "content", "");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		News record = new News();
		record.setTitle(title);
		record.setCategory(category);
		record.setContent(HtmlContentUtils.format(content, uploadPreview));
		Date now = new Date();
		record.setUpdateTime(now);

		if(id > 0) {
			newsMapper.updateByExampleSelective(record, new NewsExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			List<News> lastRecord = newsMapper.selectByExampleWithRowbounds(new NewsExample(){{
				createCriteria().andCategoryEqualTo(category);
				setOrderByClause("sort desc");
			}}, new RowBounds(0, 1));
			if(lastRecord == null || lastRecord.size() == 0) {
				record.setSort(1);
			} else {
				record.setSort(lastRecord.get(0).getSort() + 1);
			}
			record.setCreated(now);
			newsMapper.insert(record);
		}
		
		result.put("result", "success");
		result.put("updateTime", record.getUpdateTime());
		
		return result;
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		int category = ServletRequestUtils.getIntParameter(request, "category", -1);
		String current = ServletRequestUtils.getStringParameter(request, "current", "");
		if(id > 0) {
			newsMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/news?category=" + category + "&current=" + current;
	}
}
