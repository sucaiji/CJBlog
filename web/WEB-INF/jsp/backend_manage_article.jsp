<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sucaiji.dto.ArticleDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/19
  Time: 14:14
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

    <article id="article">
        <div id="manage_article_list" class="col-sm-12">
            <div class="list-group">
                <li class="list-group-item active">
                    文章列表
                </li>
                <c:if test="${requestScope.article_list!=null}">
                    <c:forEach items="${requestScope.article_list}" var="article">
                        <li class="list-group-item">
                            ${article.getTitle()}
                            <a href="/backend/edit?id=${article.getId()}">编辑</a>
                            <a href="/backend/delete?id=${article.getId()}">删除</a>
                        </li>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div id="manage_page_list">
            <ul class="pagination">
                <c:if test="${requestScope.page_amount!=null}">
                    <c:forEach begin="1" end="${requestScope.page_amount}" var="page">
                        <li><a href='/backend/manage_article?pg=${page}'>${page}</a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </article>

<jsp:include page="footer.jsp"/>

</body>
</html>
