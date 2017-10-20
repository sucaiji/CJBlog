<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sucaiji.entity.Article" %><%--
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

<jsp:include page="backend_aside.jsp"/>
<%
    Article article=(Article)request.getAttribute("article");
    String title=article.getTitle();
    String content=article.getContent();
    Integer id=article.getId();
%>
<form action="/backend/edit" method="post">
    标题<input name="title" type="text" value="<%=title%>">
    正文<input name="content" type="text" value="<%=content%>">
    <input name="id" value="<%=id%>">
    <input type="submit" value="提交">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
