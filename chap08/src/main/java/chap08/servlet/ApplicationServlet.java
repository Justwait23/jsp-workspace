package chap08.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08.util.UriParser;
import chap08.webprocess.EmployeesListWebProcess;
import chap08.webprocess.EmployeesSearchFormWebProcess;
import chap08.webprocess.EmployeesSearchWebProcess;
import chap08.webprocess.IndexWebProcess;
import chap08.webprocess.WebProcess;

public class ApplicationServlet extends HttpServlet {
	
	static Map<String, WebProcess> uriMapping = new HashMap<>();
	
	static {
		uriMapping.put("GET::/", new IndexWebProcess());
		uriMapping.put("GET::/employees/list", new EmployeesListWebProcess());
		uriMapping.put("GET::/employees/search", new EmployeesSearchFormWebProcess());
		uriMapping.put("POST::/employees/search", new EmployeesSearchWebProcess());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    System.out.println("method: " + req.getMethod());
	    String cmd = UriParser.getCmd(req);

	    // 1. uri를 문자열 형태로 전달받는다.
	    // 2. 해당 uri에 알맞은 처리를 한다(DB작업 등..)
	    // 3. 내가 다음으로 가야 할 뷰 페이지로 포워드 하거나 리다이렉트 한다

	    String nextPage = uriMapping.get(cmd).process(req);

	    if (nextPage != null) {
	        if (nextPage.startsWith("redirect::")) {
	            resp.sendRedirect(nextPage.substring("redirect::".length()));
	        } else {
	            req.getRequestDispatcher(nextPage).forward(req, resp);
	        }
	    } else {
	        // Handle the case where nextPage is null
	        // You might want to log an error or redirect to an error page
	        resp.getWriter().write("Error: nextPage is null");
	    }
	}

}
