package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ethanliang.Domain.relation;
import top.ethanliang.Domain.user;
import top.ethanliang.Mapper.FriendMapper;
import top.ethanliang.Mapper.UserMapper;
import top.ethanliang.Service.FriendService;
import top.ethanliang.Util.pocketClass;

import java.util.ArrayList;
import java.util.List;
@Service
public class FriendServiceImp implements FriendService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:23
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public pocketClass insertFriend(relation rela) {
        rela.setRelationShip(0);
        int row = friendMapper.insertFriend(rela);
        return new pocketClass(row!=0?"添加好友成功了哟，亲！":"很抱歉，添加失败了失败了",row!=0?200:400);
    }

    @Override
    public pocketClass deleteFriend(relation rela) {
        int row = friendMapper.deleteFriend(rela);
        return new pocketClass(row!=0?"删得了好友删得了记忆吗":"命运在挽留你们",row!=0?200:400);
    }

    @Override
    public pocketClass changeRelationShip(relation rela) {
        int row = friendMapper.changeRelationShip(rela);
        return new pocketClass(row!=0?"已经同意添加好友成功":"添加失败",row!=0?200:400);
    }

    @Override
    public pocketClass selectFriend(String username) {
        List<user> u = friendMapper.selectFriend(username);
        user u1 = userMapper.getUserById(username);
        u.add(u1);
        return new pocketClass(u.getFirst() != null?"查询到用户":"目前没有该用户哦",u.getFirst() != null?200:400,u);
    }

    @Override
    public pocketClass selectAllFriend(String presId) {
        List<user> u = friendMapper.selectAllFriend(presId);
        return new pocketClass(u.size()!=0?"您的所有好友":"赶快去交朋友吧",200,u);
    }

    @Override
    public pocketClass verifyFriend(relation rela) {
        List<relation> lr = friendMapper.verifyFriend(rela);
        return new pocketClass(lr.size() != 0?"你们是好朋友哦":"你们还不是好友请先添加好友",lr.size() != 0?200:400);
    }

    @Override
    public pocketClass agreeFriend(relation rela){
        int row = friendMapper.changeRelationShip(rela);
        relation rel_plus = new relation();
        rel_plus.setAfterId(rela.getPresId());
        rel_plus.setPresId(rela.getAfterId());
        rel_plus.setRelationShip(1);
        int row2 = friendMapper.insertFriend(rel_plus);
        if(row2!=0 && row != 0 ){
            return new pocketClass("添加好友成功",200);
        }
        else{
            return new pocketClass("添加好友失败",200);
        }
    }

    @Override
    public pocketClass getWantFriend(String myId) {
        List<user> lu = friendMapper.getWantFriend(myId);
        return new pocketClass(lu.size() != 0?"当前所有好友请求":"空空如也",200,lu);
    }
}
