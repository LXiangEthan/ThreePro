package top.ethanliang.Service;

import org.springframework.stereotype.Service;
import top.ethanliang.Domain.user;
import top.ethanliang.Util.pocketClass;

import java.util.List;
public interface UserService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:22
     * @ description  写下注释时请使用@方法名 描述
     **/
    public pocketClass getUserList(int page);

    public pocketClass getUser(String id);

    public pocketClass addUser(user u);

    public pocketClass getGroupContainer(String id);
}
