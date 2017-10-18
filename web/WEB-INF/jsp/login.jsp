<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/5
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
登陆
<form action="/login_judge" method="post">
    账号：<input type="text" name="count"/>
    密码：<input type="password" name="password"/>
    <input type="submit" value="提交balabala">
</form>
注册
<form action="/register_judge" method="post">
    账号：<input type="text" name="count"/>
    姓名：<input type="text" name="name"/>
    密码：<input type="password" name="password"/>
    确认密码<>
    <input type="submit" value="提交balabala">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
