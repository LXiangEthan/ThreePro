package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.logininfo;
import top.ethanliang.Service.LoginService;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
public class LoginTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午5:07
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private LoginService loginService;

    @Test
    public void login(){
        String username = "admin";
        String password = "123456";
        System.out.println(loginService.login(username, password));
    }

    @Test
    public void SignOut(){
        String uuid = UUID.get();
        logininfo logininfo = new logininfo();
        logininfo.setUsername("admin");
        logininfo.setPassword("123456");
        logininfo.setId(uuid);
        loginService.SignOut(logininfo);
    }
}
