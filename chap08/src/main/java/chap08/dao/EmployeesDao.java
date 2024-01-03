package chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap08.dao.DBConnector;
import chap08.dto.EmployeesDTO;

public class EmployeesDao {
	
	
	public Integer search(EmployeesDTO employeesDto) {
		String sql = "SELECT first_name, last_name, department_name FROM employees "
				+ "WHERE first_name LIKE ? AND last_name LIKE ? AND department_name LIKE ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
					
				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
}











