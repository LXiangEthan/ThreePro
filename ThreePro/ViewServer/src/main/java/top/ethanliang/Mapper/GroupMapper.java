package top.ethanliang.Mapper;

import org.apache.ibatis.annotations.*;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.mygroup;

import java.util.List;
@Mapper
public interface GroupMapper {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:16
     * @ description  写下注释时请使用@方法名 描述
     **/
    @Insert("insert groupcontainer values(#{groupId},#{userId},0)")
    public int intoGroup(groupcontainer groupcontainer);

    @Insert("insert groupcontainer values(#{groupId},#{userId},1)")
    public int intoGroup2(groupcontainer groupcontainer);

    @Delete("delete from groupcontainer where groupId = #{groupId} and userId = #{userId}")
    public int deleteGroup(groupcontainer groupcontainer);

    @Select("select * from mygroup where mygroup.id in (select groupId from groupcontainer where userId = #{id})")
    public List<mygroup> getGroupById(String id);

    @Select("select * from mygroup where id = #{groupId}")
    public mygroup getGroupList(String groupId);

    @Select("select * from mygroup where groupname = #{groupname}")
    public List<mygroup> getGroupListByName(String groupname);

    @Select("select * from groupcontainer where groupId = #{groupId} and userId = #{userId} and groupRel = 1")
    public groupcontainer verifyGroup(groupcontainer groupcontainer);

    @Select("select * from groupcontainer where groupId in (select id from mygroup where groupMasterId = #{masterId}) and groupRel = 0")
    public List<groupcontainer> getGroupMasterList(String masterId);

    @Update("update groupcontainer set groupRel = 1 where userId = #{userId} and groupId = #{groupId}")
    public int updateGroup(groupcontainer groupcontainer);

    @Insert("insert mygroup values(#{id},#{introduce},#{groupMasterId},#{groupname})")
    public int insertGroup(mygroup mygroup);
}
