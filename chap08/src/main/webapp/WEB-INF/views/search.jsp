<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� �˻��غ���</title>
</head>
<body>

	<h3># Search</h3>
	
	<ul>
		<li>�˻��� ���� ������� ��ȸ�� �� �ִ� �������� ��������.</li>
		<li>�˻��� �� �ִ� �÷� : first_name, last_name, department_name</li>
		<li>�˻�� ���� �Է��ϰ� �˻� ��ư�� ������ ������� ��ȸ�Ǿ�� �Ѵ�</li>
	</ul>
	
	<ol>
		<li><a href="./employees/list">��� ��� ����</a></li>
		<li><a href="./employees/search">�˻�</a></li>
	</ol>
	
	<form action="" method="POST">
		�̸�: <input name="keyword" type="text"></input> <br />
		<input type="submit" value="�˻��ϱ�" />
	</form>	
	
	
	
	
</body>
</html>