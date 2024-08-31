package top.ethanliang.Service;

import org.springframework.stereotype.Service;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.mygroup;
import top.ethanliang.Util.pocketClass;

import java.util.List;

public interface GroupService {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:22
     * @ description  写下注释时请使用@方法名 描述
     **/

    public pocketClass intoGroup(groupcontainer groupcontainer);

    public pocketClass deleteGroup(groupcontainer groupcontainer);

    public pocketClass getGroupById(String id);

    public pocketClass getGroupList(String group);

    public pocketClass verifyGroup(groupcontainer groupcontainer);

    public pocketClass getGroupMasterList(String masterId);

    public pocketClass updateGroup(groupcontainer groupcontainer);

    public pocketClass addGroup(mygroup mygroup);
}
