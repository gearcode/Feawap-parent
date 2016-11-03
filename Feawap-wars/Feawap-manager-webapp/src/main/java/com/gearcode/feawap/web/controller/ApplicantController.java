package com.gearcode.feawap.web.controller;

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

import com.gearcode.feawap.domain.Applicant;
import com.gearcode.feawap.domain.ApplicantExample;
import com.gearcode.feawap.persistence.ApplicantMapper;
import com.gearcode.feawap.persistence.RecuitmentMapper;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    private static final Log logger = LogFactory.getLog(ApplicantController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private RecuitmentMapper recuitmentMapper;
    @Resource
    private ApplicantMapper applicantMapper;

	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ApplicantExample example = new ApplicantExample();
		example.setOrderByClause("created desc");
		List<Applicant> list = applicantMapper.selectByExample(example);
		for (Applicant record : list) {
			record.setRecuitment(recuitmentMapper.selectByPrimaryKey(record.getId()));
		}
		request.setAttribute("list", list);		
		return "applicant/index";
	}

	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			Applicant record = applicantMapper.selectByPrimaryKey(id);
			request.setAttribute("record", record);
		}
		return "applicant/record";
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			applicantMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/applicant";
	}

}
