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
</head>
<body>
<header>
    <h3>User Info</h3>
</header>
<section>
    <div id="uid">${user.uid}</div>
    <div id="userName">${user.userName}</div>
    <div id="age">${user.age}</div>
    <div id="gender">${user.gender}</div>
    <div id="address">${user.address}</div>
    <div id="createTime">${user.createTime}</div>
</section>

</body>
</html>
