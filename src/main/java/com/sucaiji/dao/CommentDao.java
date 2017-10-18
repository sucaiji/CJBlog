package com.sucaiji.dao;

import com.sucaiji.entity.Comment;

import java.util.Date;
import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
public interface CommentDao {
    /**
     * 通过文章id找到所有该文章的评论
     * @param articleId
     */
    List<Comment> selectCommentById(Integer articleId);


    /**
     * comment表插入一条数据
     * @param comment
     */
    void insertComment(Comment comment);
}
