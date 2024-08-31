package top.ethanliang.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ethanliang.Domain.relation;
import top.ethanliang.Domain.user;
import top.ethanliang.Util.pocketClass;

import java.util.List;

@Transactional
public interface FriendService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:21
     * @ description  写下注释时请使用@方法名 描述
     **/
    public pocketClass insertFriend(relation rela);

    public pocketClass deleteFriend(relation rela);

    public pocketClass changeRelationShip(relation rela);

    public pocketClass selectFriend(String afterId);

    public pocketClass selectAllFriend(String presId);

    public pocketClass verifyFriend(relation rela);

    public pocketClass agreeFriend(relation rela);

    public pocketClass getWantFriend(String myId);
}
