<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>��ȸ �� ��</h3>
	
	���� : <input type="text" value="${detail.board_title}" readonly/> <br>
	�ۼ��� : <input type="text" value="${detail.board_writer}" readonly/> <br />
	��ȸ�� : ${detail.view_count} �ۼ��� : ${detail.write_date}<br />
	<textarea name="" id="" cols="30" rows="10" readonly>${detail.board_content }</textarea>
	
	<input id="inputPassword" type="password" name="board_password" />
	<button id="modiBtn">�����ϱ�</button>
	<button id="delBtn">�����ϱ�</button>
	<button id="delBtn2">�����ϱ�(�˾�â)</button>
	
	<form action="./delete" id="delForm" method="POST">
		<input type="hidden" name="board_id" value="${detail.board_id}"/>
		<input type="hidden" name="check_password" value="${detail.board_password}"/>
		<input type="hidden" name="board_password" id="hiddenPassword"/> <!-- ���޿� -->
	</form>
	
	
	<div id=replyWriteDiv>
		<textarea id="replyContent" name="reply_content" cols="60" rows="5" form="replyForm"></textarea><br />
		���ۼ���<input id="replyWriter" type="text" name="reply_writer" form="replyForm"/>
		��й�ȣ<input id="replyPassword" type="password" name="reply_password" form="replyForm"/>
		<button id="replyWriteBtn" form="replyForm">��� ����</button>
	</div>
	
	<form action="./reply/add" id="replyForm" method="POST">
		<input type="hidden" name="board_id" value="${detail.board_id }"/>
	</form>
	
	<c:url value="/resources/board/js/detail.js" var="detailJS"></c:url>
	<c:url value="/resources/board/js/detailReply.js" var="detailReplyJS"></c:url>
	<c:url value="/resources/board/js/sha256.js" var="sha256"></c:url>
	
	<script>
		const boardPassword = '${detail.board_password}';
		const board_id = ${detail.board_id};
	</script>
	
	<script src="${sha256}"></script>
	<script src="${detailJS}"></script>
	<script src="${detailReplyJS}"></script>

</body>
</html>
