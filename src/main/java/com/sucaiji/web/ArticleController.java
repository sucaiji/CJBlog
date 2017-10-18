package com.sucaiji.web;

import com.sucaiji.entity.Article;
import com.sucaiji.entity.Comment;
import com.sucaiji.service.ArticleService;
import com.sucaiji.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sucaiji on 2017/10/5.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/{id}")
    public String articleById(@PathVariable("id")Integer id,Model model){
        Article article=articleService.getArticleById(id);
        model.addAttribute("article",article);
        List<Comment> commentList=commentService.getCommentListById(id);
        model.addAttribute("comment_list",commentList);
        return "article";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String commitComment(@PathVariable("id")Integer id,
                                @RequestParam("comment")String comment,
                                Model model,
                                HttpSession session){
        Integer userId=(Integer) session.getAttribute("user_id");
        if(userId==null) {
            model.addAttribute("code",BaseInterceptor.NO_LOGIN);
            return "/login";
        }

        commentService.saveComment(comment,id,userId);
        model.addAttribute("code",BaseInterceptor.COMMENT_SUCCESS);
        return "redirect:/article/"+id+"?code="+BaseInterceptor.COMMENT_SUCCESS;
    }
}
