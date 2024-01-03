<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	
	<ol>
		<li><a href="./employees/list">사원 명단 보기</a></li>
		<li><a href="./employees/search">검색</a></li>
	</ol>
	
	<form action="" method="POST">
		이름: <input name="keyword" type="text"></input> <br />
		<input type="submit" value="검색하기" />
	</form>	
	
	
	
	
</body>
</html>