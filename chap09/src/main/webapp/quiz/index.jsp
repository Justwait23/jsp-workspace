<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>퀴즈</title>
</head>
<body>

	<h3># Quiz</h3>
	
	<ul>
		<li>이 페이지에 접속할 때 광고창(팝업창)이 하나 뜨게 만들어주세요</li>
		<li>광고창에는 적당한 이미지 하나와 체크박스 버튼이 있어야 한다</li>
		<li>체크 박스를 체크하고 창을 닫으면 30초동안 이 페이지에 접속하더라도 광고창이 뜨지 않아야한다</li>
	</ul>
	
	<c:url value="/quiz/promotion.jsp" var="pmURL"></c:url>
	
	<!-- JSP 페이지에서는 EL로 쿠키값을 쉽게 꺼내쓸 수 있다 -->
	<c:if test="${cookie.nmpm2.value != '1'}">
		<script>
			// open할 때 내가 연 새창의 인스턴스를 반환한다
			const a = open('${pmURL}', '_blank', 'width=500,height=500');
			
			// a.close();
		</script>
	</c:if>
	
	<script src="/chap09/assets/js/quiz/index.js"></script>

</body>
</html>