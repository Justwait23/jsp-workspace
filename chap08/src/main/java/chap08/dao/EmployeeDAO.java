package chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap08.dto.EmployeeDTO;

public class EmployeeDAO {
	
	// 타입과 쿼리를 전달받으면 리스트를 반환하는 함수
	public List<EmployeeDTO> search(String type, String query) {
		List<EmployeeDTO> emps = new ArrayList<>();
		
		String sql = "SELECT employee_id, first_name, last_name, salary, "
				+ "hire_date, department_name FROM employees e, departments d "
				+ "WHERE e.department_id = d.department_id AND lower(" + type + ") LIKE ?";
		
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
		) { 
			pstmt.setString(1, "%" + query.toLowerCase() + "%");
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					emps.add(new EmployeeDTO(
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getDouble("salary"),
							rs.getDate("hire_date"),
							rs.getString("department_name")));
				}
			}
			
			return emps;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
