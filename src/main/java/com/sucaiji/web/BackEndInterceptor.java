package com.sucaiji.web;

import com.sucaiji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sucaiji on 2017/10/16.
 */
public class BackEndInterceptor extends BaseInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Integer userId=(Integer) session.getAttribute("user_id");
        if(userId==null){
            response.sendRedirect("/login?code="+NO_LOGIN);
            return false;
        }
        if(!userService.judgeAuthorization(userId)){
            response.sendRedirect("/index?code="+NO_PERMISSION);
            return false;
        }
        return true;
    }
}
