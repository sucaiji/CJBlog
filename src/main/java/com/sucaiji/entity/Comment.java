package com.sucaiji.entity;

import java.util.Date;

/**
 * Created by sucaiji on 2017/10/5.
 */
public class Comment {
    private Integer likes;
    private Date time;
    private Integer articleId;
    private Integer userId;
    private String content;

    public Comment() {
    }

    public Comment(Integer likes, Date time, Integer articleId, Integer userId, String content) {
        this.likes = likes;
        this.time = time;
        this.articleId = articleId;
        this.userId = userId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "likes=" + likes +
                ", time=" + time +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
