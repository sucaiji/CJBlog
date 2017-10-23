package com.sucaiji.service.impl;

import com.sucaiji.dao.ArticleDao;
import com.sucaiji.dao.CommentDao;
import com.sucaiji.dao.UserDao;
import com.sucaiji.dto.ArticleDto;
import com.sucaiji.entity.Article;
import com.sucaiji.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentDao commentDao;


    @Override
    public Article getArticleById(Integer id) {
        return articleDao.selectById(id);
    }

    @Override
    public List<Article> getArticleList() {

        return null;
    }

    @Override
    public Integer getPageAmount(Integer size) {
        //回头改成根据配置文件来获得分页大小
        List<Article> articleIdList=articleDao.select();
        Integer listSize=articleIdList.size();

        boolean divideExactly=((listSize%size)==0);
        if(divideExactly){
            return listSize/size;
        }
        return (listSize/size)+1;
    }

    @Override
    public List<ArticleDto> getArticleList(Integer size, Integer pageNumber) {
        List<Article> articleIdList=articleDao.select();
        Integer listSize=articleIdList.size();
        //判断请求的页数是否合法（半夜脑子蒙第二天再检查一遍）
        boolean requestPageIlleagal=(listSize<=(size*(pageNumber-1)))||(pageNumber<=0);
        if(requestPageIlleagal){
            return null;
        }
        Integer fromIndex;
        boolean isEnd=(listSize-(pageNumber)*size-1)<0;
        if (isEnd){
            fromIndex=0;
        } else{
            fromIndex=listSize-(pageNumber)*size;
        }
        Integer toIndex=listSize-(pageNumber-1)*size;
        List<Article> newList=articleIdList.subList(fromIndex,toIndex);

        List<ArticleDto> resultList=new ArrayList<ArticleDto>();
        //将Article转换成ArticleTitleDto  这个是不是要放在vo里面
        for(Article article:newList){
            resultList.add(new ArticleDto(article.getTitle(),article.getId(), article.getDate(),article.getClick()));
        }
        //翻转列表
        Collections.reverse(resultList);
        return resultList;
    }

    @Override
    public void commitArticle(String title, String content) {
        Date time=new Date();
        Article article=new Article(title,content,time,0);
        articleDao.insert(article);
    }

    @Override
    public boolean delectArticleById(Integer id) {
        //这里加一个验证 如果没有这篇文章的id的话 就报错或者怎么怎么样
        commentDao.delectByArticleId(id);
        articleDao.delectById(id);
        return true;
    }
}
