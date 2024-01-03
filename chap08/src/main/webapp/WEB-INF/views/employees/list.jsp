<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, chap08.dto.EmployeesDTO" %>
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
	<form action="<%=request.getContextPath() %>/employees/search" method="post">
	    <label for="firstName">First Name:</label>
	    <input type="text" id="firstName" name="firstName" value="${param.firstName}"><br>
	
	    <label for="lastName">Last Name:</label>
	    <input type="text" id="lastName" name="lastName" value="${param.lastName}"><br>
	
	    <label for="departmentName">Department Name:</label>
	    <input type="text" id="departmentName" name="departmentName" value="${param.departmentName}"><br>
	
	    <input type="submit" value="Search">
	</form>
	
	 <div class="emp-header">
            <div>Employee ID</div>
            <div>First Name</div>
            <div>Last Name</div>
            <div>Salary</div>
            <div>Commission Pct</div>
            <div>Hire Date</div>
            <div>Job ID</div>
            <div>Manager ID</div>
            <div>Department ID</div>
        </div>
	
	<div class="emp-list">
	<%
		Object employees = request.getAttribute("employees");
		
		if (employees != null) {
			for (EmployeesDTO emp : (List<EmployeesDTO>) employees) {
				out.print(emp.getDivRow());
			}			
		} else {
			out.print("<div>No employees here.</div>");
		}
	
	
	%>
	</div>

</body>
</html>