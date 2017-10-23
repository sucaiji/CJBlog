<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <!--如果没有登陆 则显示注册/登陆按钮-->
                <c:if test="${sessionScope.user_id==null}">
                    <li><a href="/login">注册/登陆</a></li>
                </c:if>

            </ul>
            <div class="nav navbar-nav navbar-right col-lg-6">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="请输入搜索内容">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                    </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <c:if test="${sessionScope.user_name!=null}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="">用户:${sessionScope.user_name}</a>
                    </li>
                    <li><a href="/exit">退出</a></li>

                </ul>
            </c:if>

        </div><!--/.nav-collapse -->
    </div>
</nav>

<c:set var="login_success" value="<%=BaseInterceptor.LOGIN_SUCCESS%>"/>
<c:set var="comment_success" value="<%=BaseInterceptor.COMMENT_SUCCESS%>"/>
<c:set var="exit_success" value="<%=BaseInterceptor.EXIT_SUCCESS%>"/>
<c:set var="register_success" value="<%=BaseInterceptor.REGISTER_SUCCESS%>"/>

<c:set var="login_wrong" value="<%=BaseInterceptor.LOGIN_WRONG%>"/>
<c:set var="no_permission" value="<%=BaseInterceptor.NO_PERMISSION%>"/>
<c:set var="no_login" value="<%=BaseInterceptor.NO_LOGIN%>"/>


<c:if test="${param.code!=null}">
    <c:if test="${param.code>=100&&param.code<=199}">
        <div class="alert alert-success" role="alert">
            <c:choose>
                <c:when test="${param.code==login_success}">
                    登陆成功
                </c:when>
                <c:when test="${param.code==comment_success}">
                    评论成功
                </c:when>
                <c:when test="${param.code==exit_success}">
                    退出成功
                </c:when>
                <c:when test="${param.code==register_success}">
                    注册成功
                </c:when>
                <c:otherwise>
                    成功
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>
    <c:if test="${param.code>=200&&param.code<=299}">
        <div class="alert alert-danger" role="alert">
            <c:choose>
                <c:when test="${param.code==login_wrong}">
                    账号或密码错误
                </c:when>
                <c:when test="${param.code==no_permission}">
                    没有权限
                </c:when>
                <c:when test="${param.code==no_login}">
                    没有登陆
                </c:when>
                <c:otherwise>
                    失败
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>
</c:if>




