package com.orangecandle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
		;
	}

	@Override
	public void destroy() {
		;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (response instanceof HttpServletResponse) {
			HttpServletResponse hsr = (HttpServletResponse) response;
			hsr.addHeader("Access-Control-Allow-Origin", "*");
			hsr.addHeader("Access-Control-Allow-Headers",
					"Origin, X-Requested-With, Content-Type, Accept");
		}
		// chain.doFilter(request, response);
	}
}
