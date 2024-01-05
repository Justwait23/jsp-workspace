<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>숙제</title>
</head>
<body>

	<h3># 게시판 만들어보기</h3>
	
	<ol>
		<li>DB에 게시판 정보를 담을 수 있는 테이블 구조를 설계한다</li>
		<li>필요한 기능은 댓글을 달 수 있는 게시판이다</li>
		<li>글을 쓸 때 해당 글에 대한 비밀번호 설정이 필요하다</li>
		<li>글을 수정/삭제할 때 해당 글의 비밀번호가 맞으면 수정/삭제가 가능하다</li>
		<li>글 비밀번호는 해쉬값으로 저장해야 한다(DB에서 꺼낸 값과 파라미터로 비교하는 곳이 웹프로세스/service)</li>
		<li>글을 삭제하는 경우 해당 글의 댓글들도 DB에서 함께 삭제되어야 한다</li>
		<li>시간이 남으면 게시판의 디자인을 이쁘게 꾸며보자</li>
		<li>시간이 남으면 대댓글 기능을 어떻게 구현해야할지 생각해보자</li>
	</ol>

</body>
</html>