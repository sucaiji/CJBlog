package com.sucaiji.service;


/**
 * Created by sucaiji on 2017/10/16.
 */
public interface UserService {
    /**
     * 创建一个用户
     * @param count
     * @param password
     * @param name
     */
    void createUser(String count,String password,String name);

    /**
     * 验证用户密码是否正确
     * 返回用户id
     * 如果错误，返回小于0的状态码
     * @param count
     * @param password
     * @return
     */
    Integer judgeUser(String count,String password);

    /**
     * 获得用户名称 通过userid
     * @param userId
     * @return
     */
    String getName(Integer userId);

    /**
     * 验证用户是否有权限
     * @param userId
     * @return
     */
    Boolean judgeAuthorization(Integer userId);

}
