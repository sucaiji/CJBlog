package com.sucaiji.service;

import com.sucaiji.entity.Comment;

import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
public interface CommentService {
    /**
     * 通过文章id获取这个文章的全部评论
     * @param articleId
     * @return
     */
    List<Comment> getCommentListById(Integer articleId);

    /**
     * 保存评论
     * @param content
     * @param articleId
     */
    void saveComment(String content,Integer articleId,Integer userId);
}
