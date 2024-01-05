<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>광고</title>
</head>
<body>

	<c:url value="/assets/img/samsaek4.jpg" var="catImage"></c:url>
		
	<img src="${catImage}" alt="삼색이" height="100%" width="100%"/>
	
	<div>
		<input id="nm_pm_chk" name="nm_pm" type="checkbox" />30초동안 보이지 않음
	</div>
	
	<script>
		const nmPm = document.querySelector('#nm_pm_chk');
		nmPm.addEventListener('click', (e) => {
			console.log(e);
			
			// 체크박스는 checked라는 속성을 통해 체크 여부를 판단할 수 있다
			console.log(nmPm.checked);
			
			if (nmPm.checked) {
				console.log('체크가 되었습니다!');
				
				// 클라이언트 측에서 직접 30초짜리 쿠키 추가
				document.cookie = "nmpm2=1; max-age=30; path=/chap09/quiz";			
				window.close();
				// location.href = 'nmpm.jsp'; 서버측으로 보내서 30초짜리 쿠키 추가
			}
		});
	</script>

</body>
</html>