<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Memo</title>
</head>
<body>
	
	<h3>메모 작성</h3>
	<form action="MemoServlet" method="POST">
		메모 : <textarea name="content" id="" cols="30" rows="10"></textarea>
		<input type="submit" value="작성" />		
	</form>
	
	<h3>이전 메모</h3>
	<ul>
		<%
			Map<String, List<String>> memos = (HashMap<String, List<String>>) application.getAttribute("memos");
			String userId = (String) session.getAttribute("userId");
			
			if (memos != null && memos.containsKey(userId)) {
				List<String> userMemos = memos.get(userId);
				
				for (String memo : userMemos) {
		%>
					<li><%= memo %></li>
		<%
				}
			}
		%>
	</ul>
	
	
	


</body>
</html>