package com.sucaiji.service.impl;

import com.sucaiji.dao.CommentDao;
import com.sucaiji.entity.Comment;
import com.sucaiji.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sucaiji on 2017/10/10.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommentListById(Integer articleId) {
        List<Comment> list=commentDao.selectCommentById(articleId);
        return list;
    }

    @Override
    public void saveComment(String content, Integer articleId, Integer userId) {
        Date date=new Date();
        Comment comment=new Comment(0,date,articleId,userId,content);
        commentDao.insertComment(comment);
    }
}
