package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ethanliang.Domain.logininfo;
@Mapper
public interface LoginMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:15
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Select("select * from logininfo where username = #{username} and password = #{password}")
    public logininfo login(String username, String password);

    @Insert("insert logininfo value(#{id},#{username},#{password})")
    public int SignOut(logininfo logininfo);

}
