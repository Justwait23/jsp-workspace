package chap04.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		if (isUserIdChk(userId)) {
			String errorMessage = "이미 사용중인 아이디";
			req.setAttribute("errorMessage", errorMessage);
			req.getRequestDispatcher("regis	ter.jsp").forward(req, resp);
		} else {
			registerUser(userId, password);
			getServletContext().setAttribute(userId, password);
			resp.sendRedirect("index.jsp");
		}
		
	}
	
	public boolean isUserIdChk(String userId) {
		Map<String, String> userMap = (Map<String, String>) getServletContext().getAttribute("userMap");
		
		return userMap != null && userMap.containsKey(userMap);
	}
	
	public void registerUser(String userId, String password) {
		Map<String, String> userMap = (Map<String, String>) getServletContext().getAttribute("userMap");
		
		if (userMap == null) {
			userMap = new HashMap<>();
		}
		userMap.put(userId, password);
		getServletContext().setAttribute("userMap", userMap);
		
	}
}
