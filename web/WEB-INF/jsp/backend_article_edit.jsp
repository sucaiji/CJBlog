<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>

<%@ include file="backend_aside.html"%>

<form action="/backend/edit" method="post">
    标题<input name="title" type="text" value="${requestScope.article.getTitle()}">
    正文<input name="content" type="text" value="${requestScope.article.getContent()}">
    <input name="id" value="${requestScope.article.getId()}">
    <input type="submit" value="提交">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
