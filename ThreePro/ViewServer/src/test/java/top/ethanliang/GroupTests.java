package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Service.GroupService;

@SpringBootTest
public class GroupTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午4:52
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private GroupService groupService;
    @Test
    public void intoGroup(){
        groupcontainer group = new groupcontainer();
        group.setGroupId("g1");
        group.setUserId("3");
        groupService.intoGroup(group);
    }

    @Test
    public void deleteGroup(){
        groupcontainer group = new groupcontainer();
        group.setGroupId("g1");
        group.setUserId("3");
        groupService.deleteGroup(group);
    }

    @Test
    public void getGroupById(){
        System.out.println(groupService.getGroupById("1"));
    }

    @Test
    public void getGroupList(){
        System.out.println(groupService.getGroupList("g1"));
    }
}

