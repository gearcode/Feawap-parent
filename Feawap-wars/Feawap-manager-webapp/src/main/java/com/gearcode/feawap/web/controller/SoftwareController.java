package com.gearcode.feawap.web.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gearcode.feawap.domain.Software;
import com.gearcode.feawap.domain.SoftwareExample;
import com.gearcode.feawap.domain.SoftwareWithBLOBs;
import com.gearcode.feawap.persistence.SoftwareMapper;
import com.gearcode.feawap.util.FileUploadUtils;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/software")
public class SoftwareController {

    private static final Log logger = LogFactory.getLog(SoftwareController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private SoftwareMapper softwareMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		SoftwareExample example = new SoftwareExample();
		example.setOrderByClause("sort asc");
		List<Software> list = softwareMapper.selectByExample(example);
		request.setAttribute("list", list);		
		return "software/index";
	}

	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			SoftwareWithBLOBs record = softwareMapper.selectByPrimaryKey(id);

			record.setDescription(HtmlContentUtils.parseImgSrc(record.getDescription(), uploadPreview));
			record.setApplication(HtmlContentUtils.parseImgSrc(record.getApplication(), uploadPreview));
			record.setCaseAnalysis(HtmlContentUtils.parseImgSrc(record.getCaseAnalysis(), uploadPreview));
			
			request.setAttribute("record", record);
		}
		return "software/record";
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(final MultipartHttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		final String name = ServletRequestUtils.getStringParameter(request, "name", "");
		final String color = ServletRequestUtils.getStringParameter(request, "color", "");
		final String description = ServletRequestUtils.getStringParameter(request, "description", "");
		final String application = ServletRequestUtils.getStringParameter(request, "application", "");
		final String caseAnalysis = ServletRequestUtils.getStringParameter(request, "case_analysis", "");
		
		MultipartFile icon = request.getFile("icon");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		SoftwareWithBLOBs record = new SoftwareWithBLOBs();
		record.setTitle(title);
		record.setName(name);
		record.setColor(color);
		record.setDescription(HtmlContentUtils.format(description, uploadPreview));
		record.setApplication(HtmlContentUtils.format(application, uploadPreview));
		record.setCaseAnalysis(HtmlContentUtils.format(caseAnalysis, uploadPreview));
		record.setUpdateTime(new Date());
		
		//上传图片
		if(icon != null) {
			try {
				String dir = "/software/icon";
				//上传
				String fileName = FileUploadUtils.uploadRandomName(icon, uploadRoot + dir);
				//设置路径
				record.setIcon(dir + "/" + fileName);
			} catch (IllegalStateException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		}

		if(id > 0) {
			/*
			 * 修改
			 */
			softwareMapper.updateByExampleSelective(record, new SoftwareExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			/*
			 * 新增
			 */
			List<Software> lastRecord = softwareMapper.selectByExampleWithRowbounds(new SoftwareExample(){{
				setOrderByClause("sort desc");
			}}, new RowBounds(0, 1));
			if(lastRecord == null || lastRecord.size() == 0) {
				record.setSort(1);
			} else {
				record.setSort(lastRecord.get(0).getSort() + 1);
			}
			softwareMapper.insert(record);
		}
		
		result.put("result", "success");
		result.put("updateTime", record.getUpdateTime());
		
		return result;
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			softwareMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/software";
	}

}
