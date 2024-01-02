<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Update Bread!!</title>
</head>
<body>

	<h3>빵 수정하기</h3>
	
	<form action="" method="POST">
		이름: <input name="bread_name" type="text"></input> <br />
		가격: <input name="bread_price" type="number" min="0" step="1000"/> <br />
		<input type="submit" value="수정하기" />
	</form>

</body>
</html>