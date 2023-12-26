<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Register</title>
</head>
<body>

	<h3>회원가입ㅋㅋ</h3>

	<form action="RegisterServlet" method="POST">
		아이디 : <input id="userId" type="text" name="userId" /> 
		<button type="button" onclick="isUserIdChk()" name="chkId">중복확인</button><br />
		비밀번호 : <input id="password" type="password" name="password" /> <br />
		<input type="hidden" value="idUncheck" name="idDuplication"/>
		<input type="submit" value="회원가입" />
	</form>
	

</body>
</html>