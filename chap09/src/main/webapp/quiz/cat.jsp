<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�˾�â</title>
</head>
<body>

	<h3>�Ϳ��� �����</h3>
	
	<div>
		<img src="/chap09/assets/img/samsaek.jpg" alt="samsaek" />
	</div>
	<div>
		30�ʵ��� ���� �ʱ�<input type="checkbox" id="closeAd"/>
	</div>
	<script src="/chap09/assets/js/quiz/cat.js"></script>
	
	<%
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cname = cookie.getName();
				
				if (cname.equals("JSESSIONID")) {
					cookie.setMaxAge(30); // ���� ����Ⱓ�� �����̴� ��Ű�� 5������ ����
					
					// ��û���κ��� ���޹��� ��Ű���� path������ ����
					// ������ ��� path�� �״�� ����� �Ұ����ϴ�
					System.out.println("age path: " + cookie.getPath());
					
					response.addCookie(cookie); // ���信 �Ǿ�� ���������� �ݿ���
				} 
				
			}
		}
	
	%>

</body>
</html>