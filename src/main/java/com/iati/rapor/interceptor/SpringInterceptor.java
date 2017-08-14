package com.iati.rapor.interceptor;


import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SpringInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger("SpringInterceptor");
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		if (!request.getRequestURI().equals("/rapor/k/rows") && !request.getRequestURI().equals("/rapor/login/row")) {
			String kadi = (String) request.getSession().getAttribute("LOGGEDIN_USER");
			if (kadi == null) {
				response.sendRedirect("/rapor/login/row");
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	
	
}