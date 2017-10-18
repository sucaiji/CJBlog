package com.sucaiji.service;

import com.sucaiji.dto.ArticleDto;
import com.sucaiji.entity.Article;

import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
public interface ArticleService {
    /**
     * 根据id获取文章
     *
     * @param id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 获取所有文章
     *
     * @return
     */
    List<Article> getArticleList();

    /**
     * 根据分页大小获得总页数
     * @param size
     * @return
     */
    Integer getPageAmount(Integer size);

    /**
     * 设定分页大小，再根据页数获取指定范围的文章id列表
     *
     * @param size
     * @param pageNumber
     * @return
     */
    List<ArticleDto> getArticleList(Integer size, Integer pageNumber);

    /**
     * 提交一篇博客到数据库存储
     * @param content
     */
    void commitArticle(String title,String content);
}
