package chap07.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.dto.EmployeeDTO;
import chap07.dto.StudentDTO;
import chap07.util.UriParser;

public class ApplicationServlet extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = UriParser.getCmd(req);
		
		if (cmd.equals("/")) {
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		} else if (cmd.equals("/dbtest/list")) {
			// DB에서 값을 꺼낸 후
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try (
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
				ResultSet rs = pstmt.executeQuery();
			) {
				// dto : 읽기/쓰기 가능
				// vo : 읽기 전용
				List<EmployeeDTO> employees = new ArrayList<>();
				
				while (rs.next()) {
					employees.add(new EmployeeDTO(
								rs.getInt("employee_id"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getDouble("salary"),
								rs.getDouble("commission_pct"),
								rs.getDate("hire_date"),
								rs.getString("job_id"),
								rs.getInt("manager_id"),
								rs.getInt("department_id")
							));
				}
				
				// 처리 후 어트리뷰트에 데이터 적재
				req.setAttribute("employees", employees);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// 포워딩
			req.getRequestDispatcher("/WEB-INF/views/dbtest/list.jsp").forward(req, resp);
		} else if (cmd.equals("/dbtest/studentList")) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try (
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students");
				ResultSet rs = pstmt.executeQuery();
			){
				List<StudentDTO> students = new ArrayList<>();
				
				while (rs.next()) {
					students.add(new StudentDTO(
								rs.getInt("student_id"),
								rs.getString("student_name"),
								rs.getString("student_major"),
								rs.getInt("admission"),
								rs.getInt("phone_number"),
								rs.getString("email")
							));
				}
				
				// 처리 후 어트리뷰트에 데이터 적재
				req.setAttribute("students", students);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/views/dbtest/studentList.jsp").forward(req, resp);

		} else if (cmd.equals("/dbtest/studentList/add")) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String studentName = req.getParameter("name");
			String studentMajor = req.getParameter("major");
			String admissionYear = req.getParameter("year");
			String phoneNumber = req.getParameter("phoneNumber");
			
		}
	}
}
