<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/5
  Time: 13:31
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
<aside id="aside">
    <div class="col-sm-7">
        <ul class="list-group">
            <li class="list-group-item"><a href="/backend/edit">写文章</a> </li>
            <li class="list-group-item">10月</li>
            <li class="list-group-item">9月</li>
            <li class="list-group-item">8月</li>
            <li class="list-group-item">7月</li>
        </ul>
    </div>
</aside>
<jsp:include page="footer.jsp"/>
</body>
</html>
