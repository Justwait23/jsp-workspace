<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Register</title>
</head>
<body>

	<h3>ȸ�����Ԥ���</h3>

	<form action="RegisterServlet" method="POST">
		���̵� : <input id="userId" type="text" name="userId" /> 
		<button type="button" onclick="isUserIdChk()" name="chkId">�ߺ�Ȯ��</button><br />
		��й�ȣ : <input id="password" type="password" name="password" /> <br />
		<input type="hidden" value="idUncheck" name="idDuplication"/>
		<input type="submit" value="ȸ������" />
	</form>
	

</body>
</html>