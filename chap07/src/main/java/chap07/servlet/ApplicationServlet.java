package chap07.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.util.UriParser;
import chap07.webprocess.BreadAddFormWebProcess;
import chap07.webprocess.BreadAddWebProcess;
import chap07.webprocess.BreadDeleteFormProcess;
import chap07.webprocess.BreadDeleteWebProcess;
import chap07.webprocess.BreadListWebProcess;
import chap07.webprocess.BreadUpdateFormWebProcess;
import chap07.webprocess.BreadUpdateWebProcess;
import chap07.webprocess.DBTestWebProcess;
import chap07.webprocess.IndexWebProcess;
import chap07.webprocess.WebProcess;

public class ApplicationServlet extends HttpServlet {
	
	static Map<String, WebProcess> uriMapping = new HashMap<>();
	
	static {
		// (1) 전달받은 URI(cmd)에 따라 알맞은 처리를 꺼내줄 수 있는 맵을 생성 해두면
		//	   if문을 안 쓸 수 있다 (커맨드 패턴)
		uriMapping.put("GET::/", new IndexWebProcess());
		uriMapping.put("GET::/dbtest/list", new DBTestWebProcess());
		uriMapping.put("GET::/dbtest/bread/list", new BreadListWebProcess());
		uriMapping.put("GET::/dbtest/bread/add", new BreadAddFormWebProcess());
		uriMapping.put("POST::/dbtest/bread/add", new BreadAddWebProcess());
		uriMapping.put("GET::/dbtest/bread/delete", new BreadDeleteFormProcess());
		uriMapping.put("POST::/dbtest/bread/delete", new BreadDeleteWebProcess());
		uriMapping.put("GET::/dbtest/bread/update", new BreadUpdateFormWebProcess());
		uriMapping.put("POST::/dbtest/bread/update", new BreadUpdateWebProcess());

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
		
		if (nextPage.startsWith("redirect::")) {
			resp.sendRedirect(nextPage.substring("redirect::".length()));
		} else {
			req.getRequestDispatcher(nextPage).forward(req, resp);	
		}
		
		
		
		
		
		// 커맨드패턴,디자인패턴
		// if문을 사용할때의 문제점 - 끝도 없이 늘어나기 때문에 소스코드가 길어져서 유지보수가 힘들다
		// 결론 : 엄청나게 늘어날 수 있는 if문은 제거해야 한다 - 인터페이스와 Map을 활용
		
//		if (cmd.equals("/")) {
//			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
//		} else if (cmd.equals("/dbtest/list")) {
//			// DB에서 값을 꺼낸 후
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			try (
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
//				ResultSet rs = pstmt.executeQuery();
//			) {
//				// dto : 읽기/쓰기 가능
//				// vo : 읽기 전용
//				List<EmployeeDTO> employees = new ArrayList<>();
//				
//				while (rs.next()) {
//					employees.add(new EmployeeDTO(
//								rs.getInt("employee_id"),
//								rs.getString("first_name"),
//								rs.getString("last_name"),
//								rs.getDouble("salary"),
//								rs.getDouble("commission_pct"),
//								rs.getDate("hire_date"),
//								rs.getString("job_id"),
//								rs.getInt("manager_id"),
//								rs.getInt("department_id")
//							));
//				}
//				
//				// 처리 후 어트리뷰트에 데이터 적재
//				req.setAttribute("employees", employees);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			// 포워딩
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/list.jsp").forward(req, resp);
//		} else if (cmd.equals("/dbtest/studentList")) {
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			try (
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students");
//				ResultSet rs = pstmt.executeQuery();
//			){
//				List<StudentDTO> students = new ArrayList<>();
//				
//				while (rs.next()) {
//					students.add(new StudentDTO(
//								rs.getInt("student_id"),
//								rs.getString("student_name"),
//								rs.getString("student_major"),
//								rs.getInt("admission"),
//								rs.getInt("phone_number"),
//								rs.getString("email")
//							));
//				}
//				
//				// 처리 후 어트리뷰트에 데이터 적재
//				req.setAttribute("students", students);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/studentList.jsp").forward(req, resp);
//
//		} else if (cmd.equals("/dbtest/studentList/add")) {
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			String studentName = req.getParameter("name");
//			String studentMajor = req.getParameter("major");
//			String admissionYear = req.getParameter("year");
//			String phoneNumber = req.getParameter("phoneNumber");
//
//			// admissionYear와 phoneNumber에 대한 null 체크와 기본값 설정
//			int admissionYearValue = admissionYear != null && !admissionYear.isEmpty() ? Integer.parseInt(admissionYear) : 0;
//			int phoneNumberValue = phoneNumber != null && !phoneNumber.isEmpty() ? Integer.parseInt(phoneNumber) : 0;
//		
//			try (
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (student_id, student_name, student_major, admission, phone_number) VALUES (stuid_seq1.nextval, ?, ?, ?, ?)");	
//			){
//				pstmt.setString(1, studentName);
//		        pstmt.setString(2, studentMajor);
//		        pstmt.setInt(3, admissionYearValue);
//		        pstmt.setInt(4, phoneNumberValue);
//
//		        // 삽입 실행
//		        pstmt.executeUpdate();
//
//		        resp.sendRedirect(req.getContextPath() + "/dbtest/studentList");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		} else if (cmd.equals("/dbtest/studentList/delete")) {
//	        try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//	        
//	        String studentIdToDelete = req.getParameter("studentIdToDelete");
//
//	        try {
//	            // studentIdToDelete가 null 또는 빈 문자열이 아닌 경우에만 삭제 작업 수행
//	            if (studentIdToDelete != null && !studentIdToDelete.isEmpty()) {
//	                try (
//	                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//	                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE student_id = ?");
//	                ) {
//	                    // 삭제할 학생의 student_id를 설정
//	                    pstmt.setInt(1, Integer.parseInt(studentIdToDelete));
//
//	                    // 쿼리 실행
//	                    int rowsAffected = pstmt.executeUpdate();
//
//	                    if (rowsAffected > 0) {
//	                        // 삭제 후 학생 목록 페이지로 리다이렉트
//	                        resp.sendRedirect(req.getContextPath() + "/dbtest/studentList");
//	                    } else {
//	                        // 삭제할 학생이 존재하지 않는 경우 예외 처리 또는 다른 처리 로직 추가
//	                        System.out.println("Student with ID " + studentIdToDelete + " not found.");
//	                        resp.sendRedirect(req.getContextPath() + "/errorPage.jsp");
//	                    }
//	                }
//	            } else {
//	                // studentIdToDelete가 null이거나 빈 문자열인 경우 예외 처리 또는 다른 처리 로직 추가
//	                System.out.println("Invalid studentIdToDelete: " + studentIdToDelete);
//	            }
//	        } catch (NumberFormatException | SQLException e) {
//	            e.printStackTrace();
//	        }
//	    } else if (cmd.equals("/dbtest/bread/list")) {
//	    	
//	    	req.getRequestDispatcher("/WEB-INF/views/dbtest/studentList.jsp").forward(req, resp);
//	    }
	}
	
}