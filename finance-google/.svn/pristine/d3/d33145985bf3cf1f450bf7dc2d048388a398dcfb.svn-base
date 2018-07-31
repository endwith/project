package com.ptteng.fuiou.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter
{
	private String encoding;

	private boolean forceEncoding = false;
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException
	{
		if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
				response.setCharacterEncoding(this.encoding);
			}
		}
		filterChain.doFilter(request, response);
		
	}


	public void init(FilterConfig config) throws ServletException
	{
		this.encoding = config.getInitParameter("encoding");
		this.forceEncoding = Boolean.valueOf(config.getInitParameter("forceEncoding"));
	}


	public void destroy()
	{
		// TODO Auto-generated method stub
	}

}
