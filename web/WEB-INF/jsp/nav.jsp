<%@ page import="com.sucaiji.web.BaseInterceptor" %>
<%--
  Created by IntelliJ IDEA.
  User: sufchick
  Date: 2017/10/5
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse">
    <div class="container">

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">主页</a></li>
                <li><a href="/backend/main">后台</a></li>
                <li><a href="/login">注册/登陆</a></li>
            </ul>
            <%
                String name=(String)session.getAttribute("user_name");
                if (name!=null) {
            %>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="">用户:<%=name%></a>
                </li>
                <li><a href="/exit">退出</a></li>
            </ul>
            <%

                }
            %>

        </div><!--/.nav-collapse -->
    </div>
</nav>
<%
    String str=request.getParameter("code");
    if(str==null){
        return;
    }
    Integer code=Integer.valueOf(str);
    String message="";
    if(code>=100&&code<=199){
        switch (code){
            case BaseInterceptor.LOGIN_SUCCESS:
                message="登陆成功";
                break;
            case BaseInterceptor.COMMENT_SUCCESS:
                message="评论成功";
                break;
            case BaseInterceptor.EXIT_SUCCESS:
                message="退出成功";
                break;
            default:
                message="成功";
        }
        %>
            <div class="alert alert-success" role="alert"><%=message%></div>
        <%
    }
    if(code>=200&&code<=299){
        switch (code){
            case BaseInterceptor.LOGIN_WRONG:
                message="账户或者密码错误";
                break;
            case BaseInterceptor.NO_PERMISSION:
                message="没有权限";
                break;
            case BaseInterceptor.NO_LOGIN:
                message="没有登陆";
                break;
            default:
                message="错误";
        }
        %>
            <div class="alert alert-danger" role="alert"><%=message%></div>
        <%
    }
%>



