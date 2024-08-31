package top.ethanliang.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ethanliang.Domain.article;
import top.ethanliang.Domain.commentart;
import top.ethanliang.Domain.simpleArticle;
import top.ethanliang.Service.ArticleService;
import top.ethanliang.Service.CommentService;
import top.ethanliang.Util.Time;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;

@RestController
@RequestMapping("/Article")
public class Article {
    /**
     * @ author ethan
     * @ date  2024年08月30日 下午1:37
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;
    @GetMapping("/")
    public pocketClass getAllArticle(){
        return articleService.getAllArticle();
    }

    @GetMapping("/{id}")
    public pocketClass getArticleById(@PathVariable String id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/comment/{id}")
    public pocketClass getArticleComment(@PathVariable String id){
        return commentService.getCommentByArticleId(id);
    }

    @PostMapping("/")
    public pocketClass addArticle(@RequestBody simpleArticle sarticle, HttpSession httpSession){
        if(!httpSession.getAttribute("id").equals(sarticle.getAuthorId())) {
            return null;
        }
        article article = new article();
        article.setAuthorId(sarticle.getAuthorId());
        article.setInfoData(sarticle.getInfoData());
        article.setId("A@"+UUID.get());
        article.setTime(Time.now());
        return articleService.addArticle(article);
    }

    @PostMapping("/comment")
    public pocketClass addArticleComment(@RequestBody commentart commentart,HttpSession httpSession){
        if(!httpSession.getAttribute("id").equals(commentart.getUserGood())) {
            return null;
        }
        commentart.setId("C@"+UUID.get());
        return commentService.insertComment(commentart);
    }
}
