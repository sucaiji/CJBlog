<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/5
  Time: 21:58
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
<form action="/login_judge" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="count" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="count" name="count" placeholder="请输入账号">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
</form>
</div>
<div>
<form action="/register_judge" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label for="count1" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="count1" name="count" placeholder="请输入账号">
        </div>
    </div>
    <div class="form-group">
        <label for="password1" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="password1" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="name1" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="name1" name="name" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">注册</button>
        </div>
    </div>
</form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
