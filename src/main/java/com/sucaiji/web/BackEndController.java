package com.sucaiji.web;

import com.sucaiji.entity.Article;
import com.sucaiji.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
@Controller
@RequestMapping("/backend")
public class BackEndController {
    //每页文章数量 回头改成从配置文件里面读取 或者数据库里面读取
    private Integer pageSize = 10;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/main")
    public String main(){
        return "backend";
    }

    @RequestMapping(value = "/article_commit",method = RequestMethod.POST)
    public String articleCommit(@RequestParam("title")String title,
                                @RequestParam("content")String content){
        articleService.commitArticle(title,content);

        return "redirect:/index?code="+BaseInterceptor.COMMIT_ARTICLE_SUCCESS;
    }

    @RequestMapping(value="/write")
    public String write(){
        return "backend_article_write";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(value = "id")Integer id,
                       Model model){
        Article article=articleService.getArticleById(id);
        model.addAttribute("article",article);
        return "backend_article_edit";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editCommit(@RequestParam("id")Integer id,
                             @RequestParam("title")String title,
                             @RequestParam("content")String content ){
        System.out.println("-----------editCommit------------");

        return "redirect:/backend/manage_article";
    }

    @RequestMapping("/delete")
    public String deleteArticle(@RequestParam("id")Integer id){
        //加上提示   如果成功 提示xxx 失败 提示xxx
        articleService.delectArticleById(id);
        System.out.println("-------------删除成功"+id+"------------------");
        return "redirect:/backend/manage_article";
    }

    @RequestMapping(value = "manage_article")
    public String articleList(@RequestParam(value = "pg",
                                            required = false,
                                            defaultValue = "1") Integer pg,
                              Model model){
        List articleList=articleService.getArticleList(pageSize, pg);
        model.addAttribute("article_list",articleList);
        Integer pageAmount=articleService.getPageAmount(pageSize);
        model.addAttribute("page_amount", pageAmount);
        return "backend_manage_article";
    }
}
