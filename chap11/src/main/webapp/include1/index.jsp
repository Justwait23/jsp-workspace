<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jsp:include�� forwardó�� webapp���� ��θ� ����ؾ� �Ѵ�(�ܺο��� ��û������ �ּҰ� �ƴ�!) --%>
<jsp:include page="./top.jsp"/>

<h1>Index.jsp</h1>


<p>
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
	Doloribus alias sed hic atque recusandae necessitatibus culpa ratione id 
	aspernatur eligendi accusantium deleniti eos similique. 
	Sunt consequuntur harum nihil nam in.
</p>

<p>�ڹٽ�ũ��Ʈ�� Ŭ���̾�Ʈ���� �۵��ϴ� ����̱� ������ 3������ ������ ���� �ʴ´�...</p>

<p>
	����� �ϳ��� ���������� �ٸ� ������������ �ϼ��� ����� �������� ���̱� ������ 
	�� JSP�������� �ϼ��ϱ� ���� ���� �� �������� ���� �����Ͼ� �Ѵ�(ex : jstl, page...)
</p>

<c:forEach begin="0" end="9" var="i">
	<p>paragraph${i}, ${fruit}</p>
</c:forEach>



<jsp:include page="./bottom.jsp"/>
