package com.sucaiji.entity;

import java.util.Date;

/**
 * Created by sucaiji on 2017/10/5.
 */
public class Article {
    //文章
    private Integer id;
    //标题
    private String title;
    //文章内容
    private String content;
    //发布日期
    private Date time;
    //点击量
    private Integer click;

    public Article() {
    }

    public Article(Integer id, String title, String content, Date time, Integer click) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.click = click;
    }

    public Article(String title, String content, Date time, Integer click) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.click = click;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return time;
    }

    public void setDate(Date time) {
        this.time = time;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Override
    public String toString(){
        return "\ntitle:"+title;
    }
}
