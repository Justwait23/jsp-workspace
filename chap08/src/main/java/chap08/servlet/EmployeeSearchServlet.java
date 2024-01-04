package chap08.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08.dao.DBConnector;
import chap08.dto.DepartmentDTO;
import chap08.dto.EmployeesDTO;

@WebServlet("/employeeSearch")
public class EmployeeSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String departmentName = req.getParameter("departmentName");

        List<EmployeesDTO> searchResults = performSearch(firstName, lastName, departmentName);

        req.setAttribute("searchResults", searchResults);

        RequestDispatcher dispatcher = req.getRequestDispatcher("employeeSearchResult.jsp");
        dispatcher.forward(req, resp);
    }

    private List<EmployeesDTO> performSearch(String firstName, String lastName, String departmentName) {
        	List<EmployeesDTO> results = new ArrayList<>();
        

        try {
        	Connection conn = DBConnector.getConnection();
        	String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.salary, e.commission_pct, e.hire_date, e.job_id, e.manager_id, e.department_id, d.department_name "
                    	+ "FROM employees e "
                    	+ "JOIN departments d ON e.department_id = d.department_id "
                    	+ "WHERE e.first_name LIKE ? AND e.last_name LIKE ? AND d.department_name LIKE ?";
        	
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + firstName + "%");
            pstmt.setString(2, "%" + lastName + "%");
            pstmt.setString(3, "%" + departmentName + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	EmployeesDTO employee = new EmployeesDTO();
                DepartmentDTO department = new DepartmentDTO();

                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setFirst_name(rs.getString("first_name"));
                employee.setLast_name(rs.getString("last_name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCommission_pct(rs.getDouble("commission_pct"));
                employee.setHire_date(rs.getDate("hire_date"));
                employee.setJob_id(rs.getString("job_id"));
                employee.setManager_id(rs.getInt("manager_id"));
                employee.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_name(rs.getString("department_name"));

                employee.setDepartment_name(department.getDepartment_name());

                results.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return results;
    }
}
