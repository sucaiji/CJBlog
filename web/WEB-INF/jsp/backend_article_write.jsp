<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/9
  Time: 20:30
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

<form action="/backend/article_commit" method="post">
    标题<input name="title" type="text">
    正文<input name="content" type="text">
    <input type="submit">
</form>





<jsp:include page="footer.jsp"/>

</body>
</html>
