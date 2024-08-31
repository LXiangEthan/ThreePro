package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.article;
import top.ethanliang.Service.ArticleService;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
class ArticleTests {
    @Autowired
    private ArticleService articleService;

    @Test
    public void ArticleGetAllTest(){
        System.out.println(articleService.getAllArticle());
    }

    @Test
    public void getArticleByIdTest(){
        System.out.println(articleService.getArticleById("a1"));
    }
    @Test
    public void addArticleTest(){
        String uuid = UUID.get();
        article article = new article();
        article.setId(uuid);
        article.setAuthorId("1");
        article.setInfoData("非常厉害的动画片，创造了历史");
        article.setTime("2024-08-27 15:58:45");
        System.out.println(articleService.addArticle(article));
    }
    @Test
    public void getArticleByAuthorIdTest(){
        System.out.println(articleService.getArticleByAuthorId("2"));
    }
    @Test
    public void updateArticleTest(){
        article article = new article();
        article.setId("a1");
        article.setAuthorId("1");
        article.setInfoData("9999999");
//        article.setDateTime("2024-08-27 15:58:45");
        System.out.println(articleService.updateArticle(article));
    }
    @Test
    public void deleteArticleTest(){
        System.out.println(articleService.deleteArticle("634054f9-ec28-4a3a-a01d-2ed736931478"));
    }

}
