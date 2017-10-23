<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/4
  Time: 19:23
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
<div>
    <aside id="aside">
        <div class="col-sm-7">
            <ul class="list-group">
                <li class="list-group-item">分类</li>
                <li class="list-group-item">10月</li>
                <li class="list-group-item">9月</li>
                <li class="list-group-item">8月</li>
                <li class="list-group-item">7月</li>
            </ul>
        </div>
    </aside>
    <article id="article">
        <div id="article_list" class="col-sm-12">
            <div class="list-group">
                <li class="list-group-item active">
                    文章列表
                </li>
                <c:if test="${requestScope.article_list!=null}" >
                    <c:forEach items="${requestScope.article_list}" var="article">
                        <a class="list-group-item" href='/article/${article.getId()}'>${article.getTitle()}</a>
                    </c:forEach>
                </c:if>

            </div>
        </div>
        <div id="page_list">
                <ul class="pagination">
                    <c:if test="${requestScope.page_amount!=null}">
                        <c:forEach  begin="1" end="${page_amount}" var="page">
                            <li><a href='/index?pg=${page}'>${page}</a></li>
                        </c:forEach>
                    </c:if>
                </ul>
        </div>
    </article>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
