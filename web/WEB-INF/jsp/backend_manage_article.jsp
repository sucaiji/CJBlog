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
                <%
                    if (request.getAttribute("article_list") != null) {
                        List<ArticleDto> articleList = (List) request.getAttribute("article_list");
                        for (ArticleDto articleDto : articleList) {
                %>
                <li class="list-group-item">
                    <%=articleDto.getTitle()%>
                    <a href="/backend/edit?id=<%=articleDto.getId()%>">编辑</a>
                    <a href="/backend/delete?id=<%=articleDto.getId()%>">删除</a>
                </li>
                <%
                        }
                    }
                %>
            </div>
        </div>
        <div id="manage_page_list">
            <ul class="pagination">
                <%
                    if (request.getAttribute("page_amount") != null) {
                        Integer pageAmount = (Integer) request.getAttribute("page_amount");
                        for (int i = 1; i <= pageAmount; i++) {
                            out.println("<li><a href='/backend/manage_article?pg=" + i + "'>" + i + "</a></li>");
                        }
                    }
                %>
            </ul>
        </div>
    </article>

<jsp:include page="footer.jsp"/>

</body>
</html>
