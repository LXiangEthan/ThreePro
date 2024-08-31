package top.ethanliang.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ethanliang.Domain.groupcontainer;
import top.ethanliang.Domain.mygroup;
import top.ethanliang.Service.GroupService;
import top.ethanliang.Util.UUID;
import top.ethanliang.Util.pocketClass;

import java.util.List;

@RestController
@RequestMapping("/group")
public class Groups {
    /**
     * @ author ethan
     * @ date  2024年08月29日 下午8:02
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private GroupService groupService;

    @GetMapping("/self/{myId}")
    public pocketClass self(@PathVariable String myId, HttpSession httpSession) {
        if(httpSession.getAttribute("id").equals(myId)) {
            return groupService.getGroupById(myId);
        }else{
            return null;
        }
    }

    @GetMapping("/verify")
    public pocketClass verify(@RequestParam String userId ,@RequestParam String groupId, HttpSession httpSession) {
        if(httpSession.getAttribute("id").equals(userId)) {
            groupcontainer g = new groupcontainer();
            g.setUserId(userId);
            g.setGroupId(groupId);
            return groupService.verifyGroup(g);
        }else{
            return null;
        }
    }

    @GetMapping("/{groupId}")
    public pocketClass group(@PathVariable String groupId, HttpSession httpSession) {
        return groupService.getGroupList(groupId);
    }

    @PostMapping("/")
    public pocketClass addGroup(@RequestBody groupcontainer groupcontainer, HttpSession httpSession) {
        if(httpSession.getAttribute("id").equals(groupcontainer.getUserId())) {
            return groupService.intoGroup(groupcontainer);
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/")
    public pocketClass delGroup(@RequestBody groupcontainer groupcontainer, HttpSession httpSession) {
        if(httpSession.getAttribute("id").equals(groupcontainer.getUserId())) {
            return groupService.deleteGroup(groupcontainer);
        }
        else{
            return null;
        }
    }

    @GetMapping("/request/{masterId}")
    public pocketClass request(@PathVariable String masterId, HttpSession httpSession) {
        if(httpSession.getAttribute("id").equals(masterId)) {
            return groupService.getGroupMasterList(masterId);
        }
        return null;
    }

    @PutMapping("/")
    public pocketClass updateGroup(@RequestBody groupcontainer groupcontainer, HttpSession httpSession) {
            return groupService.updateGroup(groupcontainer);
    }

    @PostMapping("/create")
    public pocketClass createGroup(@RequestBody mygroup mygroup, HttpSession httpSession) {
        mygroup.setId("G@"+ UUID.get());
        if(httpSession.getAttribute("id").equals(mygroup.getGroupMasterId())) {
            return groupService.addGroup(mygroup);
        }
        else{
            return null;
        }
    }
}
