package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Mapper.UserMapper;
import top.ethanliang.Service.UserService;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
public class UserTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午5:18
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private UserService userService;

    @Test
    public void getUserList(){
        System.out.println(userService.getUserList(0));
    }
    @Test
    public void getUser(){
        System.out.println(userService.getUser("1"));
    }
}
