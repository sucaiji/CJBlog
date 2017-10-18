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
    <%
        if (request.getAttribute("article") != null) {
            Article article = (Article) request.getAttribute("article");
            out.print("标题:" + article.getTitle() + "<br/>");
            out.print("日期:" + article.getDate() + "<br/>" + "点击量:" + article.getClick() + "<br/>");
            out.print("正文:" + article.getContent() + "<br/>");

        }
        if (request.getAttribute("comment_list") != null) {
            List<Comment> commentList=(List)request.getAttribute("comment_list");
            out.print("-------------------评论区---------------------"+"<br/>");
            for (Comment comment:commentList){
                out.print("<div class=\"panel panel-default\"><div class=\"panel-heading\"><h3 class=\"panel-title\">用户:"+comment.getUserId()+"</h3></div><div class=\"panel-body\">"+comment.getContent()+"</div></div>");
            }
        }
    %>



    <form  method="post">
        <input type="text" name="comment">
        <input type="submit">
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>