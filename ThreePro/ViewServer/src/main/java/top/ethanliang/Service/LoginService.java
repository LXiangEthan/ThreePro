package top.ethanliang.Service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.logininfo;
import top.ethanliang.Util.pocketClass;
public interface LoginService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:22
     * @ description  写下注释时请使用@方法名 描述
     **/

    public pocketClass login(String username, String password);

    public pocketClass SignOut(logininfo logininfo);
}
