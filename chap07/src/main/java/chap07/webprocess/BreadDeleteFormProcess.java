package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;

public class BreadDeleteFormProcess implements WebProcess {

	@Override
	public String process(HttpServletRequest request) {	
		return "/WEB-INF/views/bread/deleteForm.jsp";
	}

}
