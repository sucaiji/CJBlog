<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sucaiji.entity.Article" %>
<%@ page import="com.sucaiji.entity.Comment" %><%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/5
  Time: 13:11
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
<div>
    标题:${requestScope.article.getTitle()}<br/>
    日期:${requestScope.article.getDate()}<br/>
    点击量:${requestScope.article.getClick()}<br/>
    正文:${requestScope.article.getContent()}<br/>
    -------------------评论区---------------------
    <c:forEach items="${requestScope.comment_list}" var="comment">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">用户:${comment.getUserId()}</h3>
            </div>
            <div class="panel-body">${comment.getContent()}</div>
        </div>
    </c:forEach>

    <form  method="post">
        <input type="text" name="comment">
        <input type="submit">
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
