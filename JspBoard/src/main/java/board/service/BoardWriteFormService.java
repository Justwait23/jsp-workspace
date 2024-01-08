package board.service;

import javax.servlet.http.HttpServletRequest;

public class BoardWriteFormService implements Service {

	@Override
	public String service(HttpServletRequest request) {
		
		return "/WEB-INF/views/board/writeForm.jsp";
	}

}
