package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.user;

import java.util.List;
@Mapper
public interface UserMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午8:59
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Select("select * from user limit #{page},10")
    public List<user> getUserList(int page);

    @Select("select * from user where id = #{id}")
    public user getUserById(String id);

    @Insert("insert user values(#{id},#{username},#{description},#{introduce},#{gender},#{age})")
    public int addUser(user user);

    @Select("select * from groupcontainer where groupId = #{id}")
    public List<groupcontainer> getGroupContainerById(String id);
}
