<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap07.dto.BreadDTO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3># All Breads</h3>
	
	<div>
	
	<%
	for (BreadDTO bread : (List<BreadDTO>) request.getAttribute("breads")) {
		out.print(String.format("<div>%s</div><div>%d</div>", bread.getBread_name(), bread.getBread_price()));
		
		}
	
	%>
	</div>
</body>
</html>