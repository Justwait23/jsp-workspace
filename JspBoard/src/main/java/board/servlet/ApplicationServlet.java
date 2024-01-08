package board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.*;

public class ApplicationServlet extends HttpServlet {
	
	static Map<String, Service> uriMapping = new HashMap<>();
	static String REDIRECT_PREFIX = "redirect::";
	static int REDIRECT_PREFIX_LEN = REDIRECT_PREFIX.length();
	
	@Override
	public void init() throws ServletException {
		uriMapping.put("GET:/", BoardListService.getInstance());
		uriMapping.put("GET:/list", BoardListService.getInstance());
		uriMapping.put("GET:/write", BoardWriteFormService.getInstance()); // 싱글톤 귀찮 내가 수정해보기
		uriMapping.put("POST:/write", BoardWriteService.getInstance()); // 싱글톤 귀찮
		uriMapping.put("GET:/detail", BoardDetailService.getInstance());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		
		String cmd = req.getMethod() + ":" + req.getRequestURI().substring(req.getContextPath().length());
	
		String nextView = uriMapping.get(cmd).service(req, resp);
		
		if (nextView.startsWith(REDIRECT_PREFIX)) {
			resp.sendRedirect(req.getContextPath() + nextView.substring(REDIRECT_PREFIX_LEN));
		} else {
			req.getRequestDispatcher(nextView).forward(req, resp);
		}
	}
}
