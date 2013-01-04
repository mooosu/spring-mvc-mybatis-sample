package com.zqgame.common;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsePagination {

	private Map<String,String> cookieMap;
	private int pageSize = 0;
	private int page = 1;
	public int getPageSize()
	{
		return pageSize;
	}
	public int getPage()
	{
		return page;
	}

	private static final Logger LOG = LoggerFactory.getLogger(ParsePagination.class);
	public ParsePagination(HttpServletRequest request)
	{

		cookieMap  = new HashMap<String,String>();

		Cookie [] cookies = request.getCookies();
		parseCookies(cookies);

		String pageSize = request.getParameter("page_size");
		String page = request.getParameter("page");

		String cookiePageSize = cookieMap.get("page_size");
		String cookiePage = cookieMap.get("page");

		HttpSession session = request.getSession();
		String sessionPage = (String)session.getAttribute("page");
		String sessionPageSize = (String)session.getAttribute("page_size");
		
		if( pageSize != null ){
			this.pageSize = Integer.parseInt(pageSize);
		} else if( cookiePageSize != null) {
			this.pageSize = Integer.parseInt(cookiePageSize);
		} else if( sessionPageSize != null ) {
			this.pageSize = Integer.parseInt(sessionPageSize);
		}

		if( page != null ){
			this.page = Integer.parseInt(page);
		} else if( cookiePage != null) {
			this.page = Integer.parseInt(cookiePage);
		} else if( sessionPage != null ) {
			this.page = Integer.parseInt(sessionPage);
		}
	}
	private void parseCookies(Cookie [] cookies )
	{
		for( Cookie cookie : cookies ) {
			cookieMap.put(cookie.getName(),cookie.getValue());
		}
	}
	public String getCookieByName(String name)
	{
		return cookieMap.get(name);
	}
}
