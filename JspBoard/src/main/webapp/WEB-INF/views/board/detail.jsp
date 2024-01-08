<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>조회 잘 됨</h3>
	
	제목 : <input type="text" value="${detail.board_title}" readonly/> <br>
	작성자 : <input type="text" value="${detail.board_writer}" readonly/> <br />
	조회수 : ${detail.view_count} 작성일 : ${detail.write_date}<br />
	<textarea name="" id="" cols="30" rows="10" readonly>${detail.board_content }</textarea>

</body>
</html>