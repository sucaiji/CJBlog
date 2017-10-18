package com.sucaiji.entity;

/**
 * Created by sucaiji on 2017/10/5.
 */
public class User {
    //管理员为0
    public static final Integer ADMIN=0;
    //普通用户为1
    public static final Integer USER =1;
    //被封禁为2
    public static final Integer BAN=-1;


    private Integer id;
    private String count;
    private String password;
    private String name;
    private Integer authorization;

    public User() {
    }

    public User(Integer id, String count, String password, String name, Integer authorization) {
        this.id = id;
        this.count = count;
        this.password = password;
        this.name = name;
        this.authorization = authorization;
    }

    public User(String count, String password, String name, Integer authorization) {
        this.count = count;
        this.password = password;
        this.name = name;
        this.authorization = authorization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Integer authorization) {
        this.authorization = authorization;
    }
}
