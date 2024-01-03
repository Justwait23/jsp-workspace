<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원 검색 결과</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/empList.css" />
</head>
<body>

	<h3># 사원 검색하기</h3>

    <form action="employeeSearch" method="post">
        <label for="firstName">이름:</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">성:</label>
        <input type="text" id="lastName" name="lastName">

        <label for="departmentName">부서:</label>
        <input type="text" id="departmentName" name="departmentName">

        <input type="submit" value="검색">
    </form>
    

    <h3># 검색 결과</h3>


    <div class="emp-header">
        <div>Employee ID</div>
        <div>First Name</div>
        <div>Last Name</div>
        <div>Salary</div>
        <div>Commission Pct</div>
        <div>Hire Date</div>
        <div>Job ID</div>
        <div>Manager ID</div>
        <div>Department ID</div>
        <div>Department Name</div>
    </div>

    <c:forEach var="employee" items="${searchResults}">
        <div class="emp-list">
            <div>${employee.employee_id}</div> <!-- 추가된 부분 -->
            <div>${employee.first_name}</div>
            <div>${employee.last_name}</div>
            <div>${employee.salary}</div>
            <div>${employee.commission_pct}</div>
            <div>${employee.hire_date}</div>
            <div>${employee.job_id}</div>
            <div>${employee.manager_id}</div>
            <div>${employee.department_id}</div>
            <div>${employee.department_name}</div>
        </div>
    </c:forEach>

</body>
</html>
