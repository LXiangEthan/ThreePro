package top.ethanliang.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ethanliang.Service.UserService;
import top.ethanliang.Util.pocketClass;

@RestController
@RequestMapping("user")
public class User {
    /**
     * @ author ethan
     * @ date  2024年08月28日 下午6:27
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public pocketClass getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @GetMapping("/groupUser/{id}")
    public pocketClass getGroupUser(@PathVariable("id") String id) {
        return userService.getGroupContainer(id);
    }
}
