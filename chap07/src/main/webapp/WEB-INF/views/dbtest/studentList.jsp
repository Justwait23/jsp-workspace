<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, chap07.dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Student List</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/stuList.css" />
</head>
<body>

	<h3># All Students</h3>
	
	<div class="stu-list">
	<%
		Object students = request.getAttribute("students");
		
		if (students != null) {
			for (StudentDTO stu : (List<StudentDTO>) students) {
				out.print(stu.getDivRow());
			}			
		} else {
			out.print("<div>No students here.</div>");
		}

	%>
	</div>
	
	<div>
		<form action="<%=request.getContextPath() %>/dbtest/studentList/add" method="POST">
	    <label for="name">�̸�:</label>
	    <input type="text" id="name" name="name" /> <br />
	    <label for="major">�а�:</label>
	    <input type="text" id="major" name="major" /> <br />
	    <label for="admission">���г⵵:</label>
	    <input type="number" id="admission" name="admission" /> <br />
	    <label for="phone_number">��ȭ��ȣ:</label>
	    <input type="number" id="phone_number" name="phone_number"/> <br />
	    <label for="email">�̸���:</label>
	    <input type="text" id="email" name="email"/> <br>
    	<button type="submit">�߰�</button>
		</form>
	</div>
	
	<div>
    	<form action="<%=request.getContextPath() %>/dbtest/studentList/delete" method="POST">
        <label for="studentIdToDelete">������ �л��� ID:</label>
        <input type="text" id="studentIdToDelete" name="studentIdToDelete" /> <br>
        <button type="submit">����</button>
    	</form>
	</div>

</body>
</html>