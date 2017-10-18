package com.sucaiji.web;

import com.sucaiji.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sucaiji on 2017/10/5.
 */
@Controller
@RequestMapping("/backend")
public class BackEndController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/main")
    public String main(){
        return "backend";
    }

    @RequestMapping(value = "/article_commit",method = RequestMethod.POST)
    public String articleCommit(@RequestParam("title")String title,
                                @RequestParam("content")String content,
                                Model model){
        articleService.commitArticle(title,content);

        return "redirect:/index?code="+BaseInterceptor.COMMIT_ARTICLE_SUCCESS;
    }

    @RequestMapping(value="/edit")
    public String edit(){
        return "backend_article_edit";
    }
}
