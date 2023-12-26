package chap04.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/quiz/MemoServlet")
public class MemoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getParameter("content");
		
		System.out.println("받은 메모: " + content);
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		Map<String, List<String>> memos = (HashMap<String, List<String>>) getServletContext().getAttribute("memos");
		
		if (memos == null) {
			memos = new HashMap<>();
		}
		List<String> userMemos = memos.getOrDefault(userId, new ArrayList<>());
		
		userMemos.add(content);
		
		memos.put(userId, userMemos);
		getServletContext().setAttribute("memos", memos);
		
		resp.sendRedirect("memo.jsp");
	}

}
