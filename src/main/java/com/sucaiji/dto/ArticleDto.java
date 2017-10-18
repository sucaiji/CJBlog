package com.sucaiji.dto;

import java.util.Date;

/**
 * Created by sucaiji on 2017/10/6.
 */
public class ArticleDto {
    //题目
    private String title;
    //文章id
    private Integer id;
    //发布日期
    private Date time;
    //点击量
    private Integer click;

    public ArticleDto() {
    }

    public ArticleDto(String title, Integer id, Date time, Integer click) {
        this.title = title;
        this.id = id;
        this.time = time;
        this.click = click;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
