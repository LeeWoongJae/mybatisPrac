package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	 // list를 사용해서 목록안에 있는 IP만 허용
	//  List<String> list = new ArrayList<>();
	// list.add("@.@.@.@"); ...
	
	public LogFilter() {
		System.out.println("필터 객체 생성");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Servlet 실행전");

		String host = req.getRemoteAddr();
		String port = ""+req.getRemotePort();
		
		//System.out.println("접속 Host : "+host+" 접속 Port : "+port);
		
		
		HttpServletRequest request = (HttpServletRequest)req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());

		// access control
		// if(list.indexOf(host) != -1)
		// {System.out.println("IP:"+host+", PAGE : "+page);}
		if(host.equals("192.168.0.17")) {
			System.out.println("IP:"+host+", PAGE : "+page);
			return;
		}
		chain.doFilter(req, resp);
		
		
		
		System.out.println("Servlet 실행후");
		
	}

}
