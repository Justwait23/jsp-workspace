package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;

import chap07.dao.BreadDao;
import chap07.dto.BreadDTO;

public class BreadDeleteWebProcess implements WebProcess {

	BreadDao breadDao = new BreadDao();

	@Override
	public String process(HttpServletRequest request) {
		String bread_name = request.getParameter("bread_name");
		
		Integer deleteResult = breadDao.delete(new BreadDTO(bread_name));
		
		if (deleteResult == null) {
			return "redirect::" + request.getContextPath() + "/";			
		} else if (deleteResult > 0) {
			return "redirect::" + request.getContextPath() + "/dbtest/bread/list";
		} else if (deleteResult < 0) {
			return "redirect::" + request.getContextPath() + "/";			
		}
		return null;
	}

}
