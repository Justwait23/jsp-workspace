package chap08.webprocess;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import chap08.dao.EmployeesDao;
import chap08.dto.DepartmentDTO;
import chap08.dto.EmployeesDTO;

public class EmployeesSearchWebProcess implements WebProcess {
	
	
	EmployeesDao employeesDao = new EmployeesDao();
	
	@Override
    public String process(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String departmentName = request.getParameter("departmentName");

        List<EmployeesDTO> employees = employeesDao.search(new EmployeesDTO(firstName, lastName), new DepartmentDTO(departmentName));
        
        request.setAttribute("employees", employees);

        return "/WEB-INF/employees/search";
	}

}
