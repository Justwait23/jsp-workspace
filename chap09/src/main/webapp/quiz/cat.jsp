<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>팝업창</title>
</head>
<body>

	<h3>귀여운 고양이</h3>
	
	<div>
		<img src="/chap09/assets/img/samsaek.jpg" alt="samsaek" />
	</div>
	<div>
		30초동안 보지 않기<input type="checkbox" id="closeAd"/>
	</div>
	<script src="/chap09/assets/js/quiz/cat.js"></script>
	
	<%
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cname = cookie.getName();
				
				if (cname.equals("JSESSIONID")) {
					cookie.setMaxAge(30); // 원래 만료기간이 세션이던 쿠키를 5분으로 설정
					
					// 요청으로부터 전달받은 쿠키에는 path정보가 없다
					// 예전에 썼던 path를 그대로 쓰기는 불가능하다
					System.out.println("age path: " + cookie.getPath());
					
					response.addCookie(cookie); // 응답에 실어야 수정사항이 반영됨
				} 
				
			}
		}
	
	%>

</body>
</html>