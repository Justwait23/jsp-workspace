<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Quiz</title>
</head>
<body>

	<h3># �䱸����</h3>
	
	<ul>
		<li>���̵�� ��й�ȣ�� �Է��ϰ� �α��� ��ư�� ���� �α����� �� �� �ִ�</li>
		<li>ȸ�������� ���̵�� ��й�ȣ�� �Է��ϸ� �Ϸ�ȴ� (���̵� �ߺ��� üũ�ؾ��Ѵ�, ���Ե� ������ application ������ ����Ѵ�)</li>
		<li>�α��ο� ������ ����� ������ �����Ǵ� ���� �α����� ����ؼ� �����Ǿ�� �Ѵ�</li>
		<li>�α��� �� ����� ���ο� �޸� ����� �� �ְ�, ������ ����ߴ� �޸�鵵 �� �� �־�� �Ѵ�</li>
		<li>������ ����������� ��� ȸ������ �� �޸� ������� �������.</li>
		<li>������ ������ ������ ������ ��� ������ quiz���� �ؿ� ���� ��
			(������ ����ϰ� �ʹٸ� URL�� quiz�� ���� ��)</li>
	</ul>
	
	
	
	<form action="LoginServlet" method="POST">
		���̵� : <input id="userId" type="text" name="userId" /> <br />
		��й�ȣ : <input id="password" type="password" name="password" /> <br />
		<input type="submit" value="�α���" />
	</form>
	<br />
	<a href="register.jsp">ȸ������</a>

</body>
</html>