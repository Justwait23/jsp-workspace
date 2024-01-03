package chap08.webprocess;

import javax.servlet.http.HttpServletRequest;

import chap08.dao.EmployeesDao;
import chap08.dto.EmployeesDTO;

public class EmployeesSearchWebProcess implements WebProcess {
	
	EmployeesDao employeesDao = new EmployeesDao();
	
	@Override
	public String process(HttpServletRequest request) {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String department_name = request.getParameter("department_name");
		
		Integer result = employeesDao.search(new EmployeesDTO(first_name, last_name, department_name));
		
		if (result == null) {
			return "redirect::" + request.getContextPath() + "/";			
		} else if (result > 0) {
			return "redirect::" + request.getContextPath() + "/employees/search";
		} else if (result < 0) {
			return "redirect::" + request.getContextPath() + "/";			
		}
		return null;
	}

}
