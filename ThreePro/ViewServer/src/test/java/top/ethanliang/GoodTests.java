package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.goodart;
import top.ethanliang.Service.GoodService;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
public class GoodTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午4:41
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private GoodService goodService;

    @Test
    public void getGoodByArticleId(){
        System.out.println(goodService.getGoodByArticleId("a1"));
    }

    @Test
    public void insertComment(){
        goodart goodart = new goodart();
        goodart.setArticleId("a1");
        goodart.setUserGood("1");
        System.out.println(goodService.insertComment(goodart));
    }

    @Test
    public void delete(){
        goodart goodart = new goodart();
        goodart.setArticleId("a1");
        goodart.setUserGood("1");
        goodService.delete(goodart);
    }

}
