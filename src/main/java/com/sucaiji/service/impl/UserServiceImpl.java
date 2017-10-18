package com.sucaiji.service.impl;

import com.sucaiji.dao.UserDao;
import com.sucaiji.entity.User;
import com.sucaiji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sucaiji on 2017/10/16.
 */
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;


    @Override
    public void createUser(String count, String password, String name) {
        User user=new User(count,password,name,User.USER);
        userDao.insertUser(user);
    }

    @Override
    public Integer judgeUser(String count, String password) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("count",count);
        map.put("password",password);
        Integer userId=userDao.selectByCountPassword(map);
        if (userId==null){
            return -1;
        }
        return userId;
    }

    @Override
    public String getName(Integer userId) {
        return userDao.selectNameById(userId);
    }

    @Override
    public Boolean judgeAuthorization(Integer userId) {
        Integer authorization=userDao.selectAuthorizationById(userId);
        if(authorization!=User.ADMIN){
            return false;
        }else {
            return true;
        }
    }
}
