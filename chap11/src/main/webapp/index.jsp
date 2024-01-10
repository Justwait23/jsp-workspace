<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>File Include</title>
</head>
<body>

	<h3># include 기능을 사용해 뷰 파일 분활하기</h3>
	
	<ol>
		<li>
			JSP include : 포워드처럼 request와 response를 다른 jsp로 그대로 전달하여 처리를 진행한 후에 결과를 가지고 다시 돌아오는 기능.
			다른 페이지로 잠깐 갔다가 다시 돌아오는 기능이기 때문에 include하는 페이지에서는 pageScope의 값을 사용할 수 없다.
		</li>
		<li>
			File include : 해당 파일을 컴파일하기 전에 통째로 현재 페이지에 포함해버리는 방식.
			다른 파일과 하나로 합쳐진 후 컴파일되기 때문에 pageScope가 유효하다 		
		</li>
	</ol>
	
	<a href="./include1/index.jsp">JSP include</a>
	<a href="./include2/index.jsp">File include</a>

</body>
</html>