package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	/chap01/gugudan으로 접속하는 사용자에게 
	멋있는 구구단 페이지를 응답하는 서블릿을 만들어보세요
*/

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		// HTML이 UTF-8 형식이라는 것을 브라우저에게 전달
		resp.setContentType("text/html; charset=utf-8");
		
		// 서블릿을 통해 생성되는 HTML 파일의 인코딩을 UTF-8로 설정
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<head>");
		out.print("<title> 구구단! </title>");
		
		// 웹의 절대 경로는 프로토콜 이름부터 시작되는 경로다
		// 상대 경로는 이 페이지에 접속했던 URL기준의 상대 경로다
		// a태그 뿐만이 아니라 link,image,script 태그 등은 
		// 페이지에 사용하는 것만으로도 서버로 요청을 보내 정적 자원을 받아와서 활용한다
		out.print("<link rel=\"stylesheet\" href=\"./assets/gugudan.css\">");
		out.print("</head>");
		
		out.print("<div id=\"gugudan\">");
		for (int gop = 0; gop <= 9; gop++) {
			for (int dan = 2; dan <= 9; dan++) {
				if (gop == 0) {
					out.print(String.format("<div class=\"dan\">%d단</div>", dan));
				} else {
					out.print(String.format("<div class=\"data\">%d X %d = %d</div>", dan, gop, (dan*gop)));
				}

			}
		} 
		out.print("</div>");
		out.print("</html>");
		
		out.println("<hr>");
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head><title><Hello Gugudan!</title></head>");
		out.print("<link rel=\"stylesheet\" href=\"./GugudanServlet.css\">");
//		out.print("<style>");
//		out.print(".gugudan-container{display: grid; grid-template-columns: repeat(8, 1fr); gap: 10px;}");
//		out.print(".gugudan-item {border: solid 2px black; padding: 10px; text-align: center; background-color: aquamarine;}");
//		out.print(".gugudan-item>p {color: red;}");
//		out.print("</style>");
		out.print("<body>");
		out.print("<h3>Gugudan</h3>");
		out.print("<div class=\"gugudan-container\">");
		for (int i = 2; i <= 9; i++) {
			out.print("<div class=\"gugudan-item\">");
			out.print("<h4>" + i + "단</h3>");
			for (int j = 1; j <= 9; j++) {
				out.print("<div>" + i + " X " + j + " = " + (i * j) + "</div>");
			}
			out.print("</div>");
		}
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

		out.println("<hr>");
		
	}
}
