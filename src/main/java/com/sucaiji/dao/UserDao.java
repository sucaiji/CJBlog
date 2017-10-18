package com.sucaiji.dao;

import com.sucaiji.entity.User;

import java.util.Map;

/**
 * Created by sucaiji on 2017/10/5.
 */
public interface UserDao {
    /**
     * 插入一条用户信息
     */
    void insertUser(User user);



    /**
     * 通过账号密码返回用户id
     * @param user
     * @return
     */
    Integer selectByCountPassword(Map user);

    /**
     * 通过id获取权限
     * @param userId
     * @return
     */
    Integer selectAuthorizationById(Integer userId);

    /**
     * 通过id获取姓名
     * @param id
     * @return
     */
    String selectNameById(Integer id);
}
