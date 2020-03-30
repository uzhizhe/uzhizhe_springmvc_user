<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script type="text/javascript" src="http://www.broofa.com/Tools/Math.uuid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>

</head>
<body>
<header>
    <form action="${pageContext.request.contextPath}/uzhizhe/users" method="post">
        <table align="center" border="1" cellspacing="0" cellpadding="10">
            <thead>
                <tr>
                    <th colspan="4">添加用户信息</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>用户名:</td>
                    <td><input type="text" name="userName"/></td>

                    <td>密码:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td><input type="number" name="age"/></td>

                    <td>性别:</td>
                    <td>
                        <input type="radio" name="gender" value="1"/>男
                        <input type="radio" name="gender" value="2"/>女
                    </td>
                </tr>
                <tr>
                    <td>地址:</td>
                    <td colspan="3"><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <th colspan="4">
                        <input width="80" type="reset" value="重置"/>
                        <input width="80" type="submit" value="提交"/>
                    </th>
                </tr>
            </tbody>
        </table>
    </form>
</header>

<hr>

<table align="center" width="1200" bgcolor="#f0f8ff" border="1" cellpadding="10" cellspacing="0">
    <thead>
        <tr align="center">
            <td colspan="8">用户信息列表</td>
        </tr>
        <tr>
            <td>序号</td>
            <td>UID</td>
            <td>UserName</td>
            <td>Age</td>
            <td>Address</td>
            <td>Gender</td>
            <td>CreateTime</td>
            <td>操作</td>
        </tr>
    </thead>
    <tbody id="userBody">
        <c:forEach items="${userList}" var="user" begin="0" varStatus="seq">
        <tr>
            <td>${seq.index}</td>
            <td>${user.uid}</td>
            <td>${user.userName}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <c:if test="${user.gender == 1}">
                <td>男</td>
            </c:if>
            <c:if test="${user.gender == 2}">
                <td>女</td>
            </c:if>
            <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
            <td><a href="${pageContext.request.contextPath}/uzhizhe/user/delete?uid=${user.uid}">Delete</a> </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
