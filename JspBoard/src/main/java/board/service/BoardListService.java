package board.service;

import javax.servlet.http.HttpServletRequest;

public class BoardListService implements Service {
	
	private static BoardListService instance = new BoardListService();
	
	
	public static BoardListService getInstance() {
		return instance;
	}
	
	private BoardListService() {}

	@Override
	public String service(HttpServletRequest request) {
		return "WEB-INF/views/board/index.jsp";
	}

}
