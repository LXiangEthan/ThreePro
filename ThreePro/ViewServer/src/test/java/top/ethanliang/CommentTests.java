package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.commentart;
import top.ethanliang.Service.CommentService;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
public class CommentTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午4:16
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private CommentService commentService;

    @Test
    public void getCommentByArticleIdTest(){
        pocketClass pocketClass = commentService.getCommentByArticleId("a1");
        System.out.println(pocketClass);
    }

    @Test
    public void insertCommentTest(){
        commentart commentart = new commentart();
        String id = UUID.get();
        commentart.setId(id);
        commentart.setArticleId("a2");
        commentart.setInfo("非常棒");
        commentart.setUserGood("1");
        pocketClass pocketClass = commentService.insertComment(commentart);
        System.out.println(pocketClass);

    }

    @Test
    public void deleteCommentTest(){
        System.out.println(commentService.deleteComment("003"));
    }
}
