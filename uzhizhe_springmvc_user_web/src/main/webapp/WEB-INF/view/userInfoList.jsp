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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#userInfoList a").click(function () {
                let uid = $(this).attr("uid");
                let userName = $(this).attr("userName");
                let flag = confirm("确定要删除  [" + userName + "]  吗?");
                return flag;
            });

            let page = ${userPage.page};
            let pageSize = ${userPage.pageSize};
            let totalSize = ${userPage.totalSize};

            let lastPage = Math.ceil(totalSize / pageSize);
            $("#lastPage").attr("href", "${pageContext.request.contextPath}/uzhizhe/users?page=" + lastPage);

            for (let i = 1; i <= lastPage; i++) {
                $("#prePage").append("[<a href='${pageContext.request.contextPath}/uzhizhe/users?page=" + i + "'> " + i + " </a>]");
            }
        });
    </script>

</head>
<body>
<header>
    <form action="${pageContext.request.contextPath}/uzhizhe/users" method="post">
        <table align="center" border="1" cellspacing="0" cellpadding="10">
            <thead>
            <tr>
                <th colspan="6">添加用户信息</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>用户名:<input type="text" name="userName"/></td>
                <td>密码:<input type="password" name="password" value="123456"/></td>
                <td>年龄:<input type="number" name="age" value="18"/></td>
                <td>性别:
                    <input type="radio" name="gender" value="1" checked="checked"/>男
                    <input type="radio" name="gender" value="2"/>女
                </td>
                <td>地址:
                    <select name="address">
                        <option value="河南省郑州市">河南省郑州市</option>
                        <option value="河南省洛阳市" selected="selected">河南省洛阳市</option>
                        <option value="湖北省武汉市">湖北省武汉市</option>
                        <option value="湖南省长沙市">湖南省长沙市</option>
                        <option value="河北省邯郸市">河北省邯郸市</option>
                    </select>
                </td>
                <th><input width="140" type="submit" value="提交"/></th>
            </tr>
            </tbody>
        </table>
    </form>
</header>

<hr>

<table id="userInfoList" align="center" width="1200" bgcolor="#f0f8ff" border="1" cellpadding="10" cellspacing="0">
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
    <c:forEach items="${userPage.list}" var="user" begin="0" varStatus="seq">
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
            <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td><a href="${pageContext.request.contextPath}/uzhizhe/user/delete?uid=${user.uid}" uid="${user.uid}" userName="${user.userName}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<div id="pagination" align="center">
    <a id="firstPage" href="${pageContext.request.contextPath}/uzhizhe/users?page=1">首页</a>&nbsp;&nbsp;
    <a id="prePage" href="${pageContext.request.contextPath}/uzhizhe/users?page=${userPage.page < 2 ? 1 : userPage.page-1}">上一页</a>&nbsp;&nbsp;
    <a id="nextPage" href="${pageContext.request.contextPath}/uzhizhe/users?page=${userPage.page + 1}">下一页</a>&nbsp;&nbsp;
    <a id="lastPage" href="">尾页</a>
</div>
</body>
</html>
