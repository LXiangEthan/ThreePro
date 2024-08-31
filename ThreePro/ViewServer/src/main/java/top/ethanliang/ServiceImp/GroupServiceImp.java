package top.ethanliang.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.mygroup;
import top.ethanliang.Mapper.GroupMapper;
import top.ethanliang.Service.GroupService;
import top.ethanliang.Util.pocketClass;

import java.util.List;

@Transactional
@Service
public class GroupServiceImp implements GroupService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:24
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    GroupMapper groupMapper;
    @Override
    public pocketClass intoGroup(groupcontainer groupcontainer) {
        int row = groupMapper.intoGroup(groupcontainer);
        return new pocketClass(row!=0?"加入成功":"加入失败",row!=0?200:400);
    }

    @Override
    public pocketClass deleteGroup(groupcontainer groupcontainer) {
        int row = groupMapper.deleteGroup(groupcontainer);
        return new pocketClass(row!=0?"退出群聊成功":"退出群聊失败",row!=0?200:400);
    }

    @Override
    public pocketClass getGroupById(String id) {
        List<mygroup> mygroup = groupMapper.getGroupById(id);
        return new pocketClass(mygroup.size() != 0?"查询群聊成功":"没有找到任何群聊",200,mygroup);
    }

    @Override
    public pocketClass getGroupList(String groupId) {
        mygroup groupList = groupMapper.getGroupList(groupId);
        List<mygroup> mygroupList = groupMapper.getGroupListByName(groupId);
        mygroupList.add(groupList);
        return new pocketClass(mygroupList.getFirst() != null?"查询群聊成功":"没有找到任何群聊",mygroupList.getFirst() != null?200:400,mygroupList);
    }

    @Override
    public pocketClass verifyGroup(groupcontainer groupcontainer) {
        groupcontainer lg = groupMapper.verifyGroup(groupcontainer);
        return new pocketClass(lg != null?"验证成功你在该群中":"快去加入和他们聊聊吧",lg != null?200:400);
    }

    @Override
    public pocketClass getGroupMasterList(String masterId){
        List<groupcontainer> lg = groupMapper.getGroupMasterList(masterId);
        System.out.println(lg);
        return new pocketClass(lg.size() != 0?"查询到的所有入群请求":"没有人想来哦",200,lg);
    }

    @Override
    public pocketClass updateGroup(groupcontainer groupcontainer){
        System.out.println(groupcontainer);
        int row = groupMapper.updateGroup(groupcontainer);
        return new pocketClass(row!=0?"已经同意":"加群失败",row!=0?200:400);
    }

    @Override
    public pocketClass addGroup(mygroup mygroup){
        int row = groupMapper.insertGroup(mygroup);
        groupcontainer groupcontainer = new groupcontainer();
        groupcontainer.setGroupId(mygroup.getId());
        groupcontainer.setUserId(mygroup.getGroupMasterId());
        groupcontainer.setGroupRel(1);
        int row2 = groupMapper.intoGroup2(groupcontainer);
        return new pocketClass(row!=0&&row2 != 0?"创建群组成功":"创建失败",row!=0 && row2 != 0?200:400);
    }
}
