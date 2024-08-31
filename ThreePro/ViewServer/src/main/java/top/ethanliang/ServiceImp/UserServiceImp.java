package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.user;
import top.ethanliang.Mapper.UserMapper;
import top.ethanliang.Service.UserService;
import top.ethanliang.Util.pocketClass;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:24
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private UserMapper usermapper;
    @Override
    public pocketClass getUserList(int page) {
        List<user> listU = usermapper.getUserList(page);
        return new pocketClass(listU.size()!=0?"推荐好友":"空空如也",200,listU);
    }
    @Override
    public pocketClass getUser(String id) {
        user u = usermapper.getUserById(id);
        return new pocketClass(u != null ? "你好有个性啊":"你还没填写信息呢",200,u);
    }

    @Override
    public pocketClass addUser(user u) {
        int row = usermapper.addUser(u);
        return new pocketClass(row!=0?"创建成功了":"创建用户失败了请稍后再试",row!=0?200:400);
    }

    @Override
    public pocketClass getGroupContainer(String id) {
        List<groupcontainer> lg = usermapper.getGroupContainerById(id);
        return new pocketClass(lg.size()!=0?"该群全部成员":"该群暂时没有成员",lg.size()!=0?200:400,lg);
    }
}
