package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;

import chap07.dao.BreadDao;
import chap07.dto.BreadDTO;

public class BreadUpdateWebProcess implements WebProcess {

	BreadDao breadDao = new BreadDao();
	

	@Override
	public String process(HttpServletRequest request) {
		String bread_name = request.getParameter("bread_name");
		Integer bread_price = Integer.parseInt(request.getParameter("bread_price"));
		
		Integer deleteResult = breadDao.update(new BreadDTO(bread_name, bread_price));
		
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
