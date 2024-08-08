package jbsm.common;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	FilterConfig filterconfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterconfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response
			, FilterChain fc)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String encoding = this.filterconfig.getInitParameter("encoding");
		
		request.setCharacterEncoding(encoding);
		
		fc.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("문자열 인코딩 destroy() 수행");
	}
	
}
