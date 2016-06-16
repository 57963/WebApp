package com.webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="*")
public class LoginFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest servReq, ServletResponse servRes, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servReq;
		HttpServletResponse res = (HttpServletResponse) servRes;
		boolean loggedIn=false;
		if(req.getSession(false)!=null && req.getSession().getAttribute("loggedIn")!=null){
			if((boolean)req.getSession().getAttribute("loggedIn")==true){
				loggedIn=true;
			}
		}
		if(loggedIn || req.getRequestURI().equals("/login")){
			chain.doFilter(servReq, servRes);
		} else{
			req.getSession().setAttribute("forwardTo", req.getRequestURI() + "?" + req.getQueryString());
			res.sendRedirect("/login");
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
