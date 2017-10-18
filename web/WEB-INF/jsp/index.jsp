<%@ page import="java.util.List" %>
<%@ page import="com.sucaiji.dto.ArticleDto" %><%--
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
                <%
                    if (request.getAttribute("article_list") != null) {
                        List<ArticleDto> articleList = (List) request.getAttribute("article_list");
                        for (ArticleDto articleDto : articleList) {
                            out.println("<a class=\"list-group-item\" href='/article/" + articleDto.getId() + "'>" + articleDto.getTitle() + "</a>");
                        }
                    }
                %>
            </div>
        </div>
        <div id="page_list">
                <ul class="pagination">
                    <%
                        if (request.getAttribute("page_amount") != null) {
                            Integer pageAmount = (Integer) request.getAttribute("page_amount");
                            for (int i = 1; i <= pageAmount; i++) {
                                out.println("<li><a href='/index?pg=" + i + "'>" + i + "</a></li>");
                            }
                        }
                    %>
                </ul>
        </div>
    </article>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
