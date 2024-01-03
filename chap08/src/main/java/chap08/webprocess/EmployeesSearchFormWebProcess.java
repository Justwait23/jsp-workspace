package chap08.webprocess;

import javax.servlet.http.HttpServletRequest;

public class EmployeesSearchFormWebProcess implements WebProcess {

	@Override
	public String process(HttpServletRequest request) {
		return "./searchForm.jsp";
	}

}
