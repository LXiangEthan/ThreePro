package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.logininfo;
import top.ethanliang.Mapper.LoginMapper;
import top.ethanliang.Service.LoginService;
import top.ethanliang.Util.pocketClass;
@Service
public class LoginServiceImp implements LoginService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:24
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public pocketClass login(String username, String password) {
        logininfo logininfo = loginMapper.login(username, password);
        return new pocketClass(logininfo!=null?"欢迎您进入ThreePro":"抱歉请先注册",logininfo!=null?200:400,logininfo);
    }

    @Override
    public pocketClass SignOut(logininfo logininfo) {
        int i = loginMapper.SignOut(logininfo);
        return new pocketClass(i!=0?"注册成功":"注册失败",i!=0?200:400,i!=0?true:false);
    }


}
