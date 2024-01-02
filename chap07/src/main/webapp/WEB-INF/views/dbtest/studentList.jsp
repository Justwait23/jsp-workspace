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
	    <label for="name">이름:</label>
	    <input type="text" id="name" name="name" /> <br />
	    <label for="major">학과:</label>
	    <input type="text" id="major" name="major" /> <br />
	    <label for="admission">입학년도:</label>
	    <input type="number" id="admission" name="admission" /> <br />
	    <label for="phone_number">전화번호:</label>
	    <input type="number" id="phone_number" name="phone_number"/> <br />
	    <label for="email">이메일:</label>
	    <input type="text" id="email" name="email"/> <br>
    	<button type="submit">추가</button>
		</form>
	</div>
	
	<div>
    	<form action="<%=request.getContextPath() %>/dbtest/studentList/delete" method="POST">
        <label for="studentIdToDelete">삭제할 학생의 ID:</label>
        <input type="text" id="studentIdToDelete" name="studentIdToDelete" /> <br>
        <button type="submit">삭제</button>
    	</form>
	</div>

</body>
</html>