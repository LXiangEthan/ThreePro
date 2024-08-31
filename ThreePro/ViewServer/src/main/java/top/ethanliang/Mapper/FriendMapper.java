package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.*;
import top.ethanliang.Domain.relation;
import top.ethanliang.Domain.user;

import java.util.List;
@Mapper
public interface FriendMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:16
     * @ description  写下注释时请使用@方法名 描述
     **/

    @Insert("insert relation values(#{presId},#{afterId},#{relationShip})")
    public int insertFriend(relation rela);

    @Delete("delete from relation where presId = #{presId} and afterId = #{afterId} or presId = #{afterId} and afterId = #{presId}")
    public int deleteFriend(relation rela);

    @Update("update relation set relationShip = 1 where presId = #{presId} and afterId = #{afterId}")
    public int changeRelationShip(relation rela);

    @Select("select * from user where username = #{username}")
    public List<user> selectFriend(String username);

    @Select("select * from user where user.id in (select afterId from relation where presId = #{presId})")
    public List<user> selectAllFriend(String presId);

    @Select("select * from relation where presId = #{presId} and afterId = #{afterId}  and relationShip = 1 or presId = #{afterId} and afterId = #{presId} and relationShip = 1")
    public List<relation> verifyFriend(relation relation);

    @Select("select * from user where user.id in (select presId from relation where afterId = #{afterId} and relationShip = 0)")
    public List<user> getWantFriend(String afterId);
}
