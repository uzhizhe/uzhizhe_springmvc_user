<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liqingjiang
  Date: 2020/3/19
  Time: 11:46 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>

</head>
<body>
<h3>User Info List</h3>
<img id="addUser" src="${pageContext.request.contextPath}/image/add1.jpg" width="50" height="50" alt="ADD">
<table align="left" width="500" bgcolor="#f0f8ff" border="1" cellpadding="10" cellspacing="0">
    <thead>
        <tr align="center">
            <td colspan="4">User Info List</td>
        </tr>
    </thead>
    <tbody id="userBody">
        <c:forEach items="${userList}" var="user" begin="0" varStatus="id">
        <tr>
            <td>${id.index}</td>
            <td>${user.uid}</td>
            <td>${user.userName}</td>
            <td>${user.age}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<br/><br/>

<button id="clickMe" >Click Me</button>

</body>
</html>
