package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ethanliang.Domain.relation;
import top.ethanliang.Service.FriendService;
import top.ethanliang.Util.pocketClass;

@SpringBootTest
public class FriendTests {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午4:28
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private FriendService friendService;
    @Test
    public void insertFriend(){
        relation relation = new relation();
        relation.setPresId("2");
        relation.setAfterId("3");
        relation.setRelationShip(1);
        friendService.insertFriend(relation);
    }
    @Test
    public void deleteFriend(){
        relation relation = new relation();
        relation.setPresId("2");
        relation.setAfterId("3");
        relation.setRelationShip(1);
        friendService.deleteFriend(relation);
    }
    @Test
    public void changeRelationShip(relation rela){
        relation relation = new relation();
        relation.setPresId("1");
        relation.setAfterId("2");
        relation.setRelationShip(0);
        friendService.changeRelationShip(relation);
    }
    @Test
    public void selectFriend(){
        System.out.println(friendService.selectFriend("1"));
    }
    @Test
    public void selectAllFriend(){
        System.out.println(friendService.selectAllFriend("1"));
    }
}
