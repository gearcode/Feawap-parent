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

import com.gearcode.feawap.domain.Consultation;
import com.gearcode.feawap.domain.ConsultationExample;
import com.gearcode.feawap.persistence.ConsultationMapper;
import com.gearcode.feawap.util.FileUploadUtils;
import com.gearcode.feawap.util.HtmlContentUtils;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    private static final Log logger = LogFactory.getLog(ConsultationController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private ConsultationMapper consultationMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		final String alias = ServletRequestUtils.getStringParameter(request, "tag", "");
		
		List<Consultation> records = consultationMapper.selectByExampleWithBLOBsWithRowbounds(new ConsultationExample(){{
			createCriteria().andAliasEqualTo(alias);
		}}, new RowBounds(0, 1));
		
		Consultation consultation = new Consultation();
		if(records.size() > 0) {
			consultation = records.get(0);
			consultation.setContent(HtmlContentUtils.parseImgSrc(consultation.getContent(), uploadPreview));
			request.setAttribute("record", consultation);
		}
		
		return "consultation/record";
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(final MultipartHttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String name = ServletRequestUtils.getStringParameter(request, "name", "");
		final String color = ServletRequestUtils.getStringParameter(request, "color", "");
		final String content = ServletRequestUtils.getStringParameter(request, "content", "");
		MultipartFile icon = request.getFile("icon");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(id > 0) {
			Consultation record = new Consultation();
			record.setName(name);
			record.setColor(color);
			record.setContent(HtmlContentUtils.format(content, uploadPreview));
			record.setUpdateTime(new Date());
			
			//上传图片
			if(icon != null) {
				try {
					String dir = "/consultation/icon";
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
			
			consultationMapper.updateByExampleSelective(record, new ConsultationExample(){{
				createCriteria().andIdEqualTo(id);
			}});
			
			result.put("result", "success");
			result.put("updateTime", record.getUpdateTime());
		} else {
			result.put("result", "error");
		}
		
		return result;
	}

}
