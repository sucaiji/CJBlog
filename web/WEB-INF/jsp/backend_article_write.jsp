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

<%@ include file="backend_aside.html"%>


<!--<form action="/backend/article_commit" method="post">
    标题<input name="title" type="text">
    正文<input name="content" type="text">
    <input type="submit">
</form>-->
<!-- include libraries(jQuery, bootstrap) -->

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<article id="article">
    <form id="write_form" action="/backend/article_commit" method="post">
        标题:<input type="text" name="title">
        <div id="summernote"></div>
        <script>
            $(document).ready(function () {
                $('#summernote').summernote({
                    height: 300,
                    minHeight: null,
                    maxHeight: null,
                    focus: true
                });
            });
        </script>

        <button class="btn btn-default" id="write_btn">提交</button>
    </form>
    <script>
        $("#write_btn").click(function click() {
            var value=$('#summernote').summernote('code');
            var form=$('#write_form'); //得到form对象

            var tmpInput=$("<input type='text' name='content'  hidden='hidden'/>");
            tmpInput.attr("value",value);

            form.append(tmpInput);
            form.submit();
        })
    </script>


</article>
<jsp:include page="footer.jsp"/>

</body>
</html>