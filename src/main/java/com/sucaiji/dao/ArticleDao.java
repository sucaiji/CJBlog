package com.sucaiji.dao;

import com.sucaiji.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
public interface ArticleDao {
    /**
     * 获得所有文章的列表
     * @return
     */
    List<Article> select();

    /**
     * 通过id返回一个文章实体
     * @param id
     * @return
     */
    Article selectById(Integer id);

    List<String> selectTitle();
    List<Integer> selectId();

    /**
     * 添加一篇文章
     * @param article
     */
    void insert(Article article);

    /**
     * 通过id删除一篇文章
     * @param id
     */
    void delectById(Integer id);

}
