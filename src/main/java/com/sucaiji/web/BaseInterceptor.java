package com.sucaiji.web;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseInterceptor extends HandlerInterceptorAdapter {
    //正确码100~199  错误码200~299
    /**
     * 登陆成功
     */
    public static final int LOGIN_SUCCESS=100;
    /**
     * 评论成功
     */
    public static final int COMMENT_SUCCESS=101;
    /**
     * 提交文章成功
     */
    public static final int COMMIT_ARTICLE_SUCCESS=102;
    /**
     * 退出成功
     */
    public static final int EXIT_SUCCESS=103;
    /**
     * 注册成功
     */
    public static final int REGISTER_SUCCESS=104;
    /**
     * 没有权限
     */
    public static final int NO_PERMISSION=200;
    /**
     * 账户或者密码错误
     */
    public static final int LOGIN_WRONG=201;
    /**
     * 还未登录
     */
    public static final int NO_LOGIN=202;
}
