package com.gearcode.feawap.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gearcode.feawap.domain.User;

public class BaseController {

    private static final Log logger = LogFactory.getLog(BaseController.class);

    protected User getLoginedUser(HttpServletRequest request){
    	return (User)request.getSession().getAttribute("user");
    }
    
    protected String requireLogin(HttpServletRequest request) {
    	request.setAttribute("title", "请先登录");
//    	request.setAttribute("message", "请先登录");
    	String url = "/action/login?return=";
    	try {
			String returnUrl = request.getRequestURL().toString();
			returnUrl+= "?"+request.getQueryString();
			url+=URLEncoder.encode(returnUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	request.setAttribute("url", url);
		return "common/error";
	}
    
}
