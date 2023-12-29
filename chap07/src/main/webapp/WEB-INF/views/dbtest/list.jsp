<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, chap07.dto.EmployeeDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Employee List</title>
<!-- css, img, js static resources 정적자원이라 webapp아래 바로  -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/empList.css" />
</head>
<body>
	
	<h3># All Employees</h3>
	
	<div class="emp-list">
	<%
		Object employees = request.getAttribute("employees");
		
		if (employees != null) {
			for (EmployeeDTO emp : (List<EmployeeDTO>) employees) {
				out.print(emp.getDivRow());
			}			
		} else {
			out.print("<div>No employees here.</div>");
		}
	
	
	%>
	</div>

</body>
</html>