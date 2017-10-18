package com.sucaiji.web;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sucaiji on 2017/10/16.
 */
public class CommentInterceptor extends BaseInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        String method=request.getMethod();
        if(method.equals("GET")) {
            return true;
        }
        Integer userId=(Integer) session.getAttribute("user_id");
        if(userId==null){
            response.sendRedirect("/login?code="+NO_LOGIN);
            return false;
        }
        return true;
    }
}
