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

	<h3>��ȸ �� ��</h3>
	
	���� : <input type="text" value="${detail.board_title}" readonly/> <br>
	�ۼ��� : <input type="text" value="${detail.board_writer}" readonly/> <br />
	��ȸ�� : ${detail.view_count} �ۼ��� : ${detail.write_date}<br />
	<textarea name="" id="" cols="30" rows="10" readonly>${detail.board_content }</textarea>

</body>
</html>