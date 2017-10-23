package com.sucaiji.web;

import com.sucaiji.service.ArticleService;
import com.sucaiji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sucaiji on 2017/10/4.
 */
@Controller
public class MainController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    //每页文章数量 回头改成从配置文件里面读取 或者数据库里面读取
    private Integer pageSize = 10;

    @RequestMapping({"/index", "/index.html", "", "/", "index.jsp"})
    public String index(@RequestParam(value = "pg",
                                        required = false,defaultValue = "1") Integer pg,
                        Model model) {
        List articleList=articleService.getArticleList(pageSize, pg);
        model.addAttribute("article_list",articleList);
        Integer pageAmount=articleService.getPageAmount(pageSize);
        model.addAttribute("page_amount", pageAmount);
        return "index";

    }

    @RequestMapping({"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping({"/login_judge"})
    public String loginJudge(@RequestParam("count")String count,
                             @RequestParam("password")String password,
                             HttpSession session,
                             Model model){
        Integer userId=userService.judgeUser(count, password);
        //如果userid小于0，代表被ban或者什么其他的
        if(userId<0){
            return "redirect:/login?code="+BaseInterceptor.LOGIN_WRONG;
        }
        session.setAttribute("user_id",userId);

        String userName=userService.getName(userId);
        session.setAttribute("user_name",userName);

        return "redirect:/index?code="+BaseInterceptor.LOGIN_SUCCESS;
    }
    @RequestMapping({"/register_judge"})
    public String registerJudge(@RequestParam("count")String count,
                                @RequestParam("password")String password,
                                @RequestParam("name")String name){
        userService.createUser(count, password, name);

        return "/redirect:/login?code="+BaseInterceptor.REGISTER_SUCCESS;
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/index?code="+BaseInterceptor.EXIT_SUCCESS;
    }
}
