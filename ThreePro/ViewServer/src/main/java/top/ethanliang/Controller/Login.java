package top.ethanliang.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ethanliang.Domain.SignOutPojo;
import top.ethanliang.Domain.logininfo;
import top.ethanliang.Domain.user;
import top.ethanliang.Service.LoginService;
import top.ethanliang.Service.UserService;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;
import java.util.Calendar;

@RestController
@RequestMapping("/login")
public class Login {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午5:23
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public pocketClass login(@RequestBody(required = false) logininfo lif , HttpServletRequest request, HttpServletResponse response) {
        String username = lif.getUsername();
        String password = lif.getPassword();
        if("".equals(password) || "".equals(username)){
            return new pocketClass("用户名或者密码错误",400);
        }
        HttpSession session = request.getSession();
        pocketClass result = loginService.login(username,password);
        if(result.getCode() == 200) {
            logininfo myInfo = (logininfo) result.getData();
            String id = myInfo.getId();
            System.out.println("登录成功");
            session.setAttribute("SessionTime", Calendar.getInstance().getTimeInMillis()+(1000*60*60));
            session.setAttribute("id", id);
            return new pocketClass("欢迎来到ThreePro", 200,id);
        }
        else{
            return new pocketClass("用户名或者密码错误",400);
        }
    }
    @PostMapping("/signOut")
    public pocketClass signOut(@RequestBody SignOutPojo sopj, HttpSession session) {
        String username = sopj.getUsername();
        String password = sopj.getPassword();
        String description = sopj.getDescription();
        String introduce = sopj.getIntroduce();
        int age = sopj.getAge();
        String gender = sopj.getGender();

        if("".equals(password) ||
                "".equals(username) ||
                username.length()>16 ||
                password.length()>16 ||
                introduce.length()>100 ||
                description.length()>3000 ){
            return new pocketClass("账号和密码不得超过16位",400);
        }
        pocketClass results = loginService.login(username,password);
        if(results.getCode() == 200) {
            return new pocketClass("用户名已经存在,如果仍然想要使用改用户名可以选择修改密码",400);
        }
        String id = "U@"+UUID.get();
        logininfo lf = new logininfo();
        lf.setUsername(username);
        lf.setPassword(password);
        lf.setId(id);
        loginService.SignOut(lf);
        user u = new user();
        u.setId(id);
        u.setUsername(username);
        u.setDescription(description);
        u.setAge(age);
        u.setGender(gender);
        u.setIntroduce(introduce);
        pocketClass result = userService.addUser(u);
        if(result.getCode() == 200) {
            System.out.println("注册成功");
            session.setAttribute("SessionTime", Calendar.getInstance().getTimeInMillis()+(1000*60*60));
            session.setAttribute("id", id);
            return new pocketClass("欢迎来到ThreePro", 200,id);
        }
        else{
            return new pocketClass("注册失败",400);
        }
    }
}
