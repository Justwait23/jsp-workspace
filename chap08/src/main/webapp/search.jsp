<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 검색해보기</title>
</head>
<body>

	<h3># Search</h3>
	
	<ul>
		<li>검색을 통해 사원들을 조회할 수 있는 페이지를 만들어보세요.</li>
		<li>검색할 수 있는 컬럼 : first_name, last_name, department_name</li>
		<li>검색어를 직접 입력하고 검색 버튼을 누르면 사원들이 조회되어야 한다</li>
	</ul>
	
	<c:url value="/employee/searchResult.jsp" var="searchURL"/>
	<div>
		<form id="searchForm" action="${searchURL}" method="POST"></form>
		검색:
		<input id="searchQueryField" type="text" name="searchQuery" form="searchForm">
		<select name="searchType" form="searchForm">
			<option value="first_name">이름</option>
			<option value="last_name">성</option>
			<option value="department_name">부서명</option>
		</select>
	</div>
	
	<script>
		const searchQueryField = document.getElementById('searchQueryField');
		const searchForm = document.getElementById('searchForm');
		
		// console.log(searchQueryField);
		// console.dir(searchForm);
		
		searchQueryField.addEventListener('keydown', (e) => {
			// e.preventDefault();
						
			// console.log(e);
			
			if (e.keyCode === 13) {
				// console.log('엔터키가 눌림');
				
				// 값들이 제대로 들어가있는지 검사를 하거나 ...
				// 여기서 요청을 보내는 주소를 변경하거나
				
				searchForm.submit();
			}

		});
	</script>
	

	
</body>
</html>



















