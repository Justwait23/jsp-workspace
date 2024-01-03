package chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap08.dto.DepartmentDTO;
import chap08.dto.EmployeesDTO;

public class EmployeesDao {
	
	
	public List<EmployeesDTO> search(EmployeesDTO employeesDto, DepartmentDTO departmentDTO) {
		String sql = "SELECT e.first_name, e.last_name, d.department_name " +
                "FROM employees e " +
                "JOIN departments d ON e.department_id = d.department_id " +
                "WHERE e.first_name LIKE ? AND e.last_name LIKE ? AND d.department_name LIKE ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.setString(1, "%" + employeesDto.getFirst_name() + "%");
				pstmt.setString(2, "%" + employeesDto.getLast_name() + "%");
				pstmt.setString(3, "%" + departmentDTO.getDepartment_name() + "%");
				
				try (ResultSet rs = pstmt.executeQuery()) {
			        List<EmployeesDTO> employeesList = new ArrayList<>();

			        while (rs.next()) {
			            EmployeesDTO employee = new EmployeesDTO();
			            DepartmentDTO department = new DepartmentDTO();
			            employee.setFirst_name(rs.getString("first_name"));
			            employee.setLast_name(rs.getString("last_name"));
			            department.setDepartment_name(rs.getString("department_name"));
			            // 다른 속성들을 필요에 따라 설정

			            employeesList.add(employee);
			        }

			        return employeesList;
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			    return null;
			}
}

}









