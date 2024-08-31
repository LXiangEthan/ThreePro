package top.ethanliang.Controller;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ethanliang.Domain.relation;
import top.ethanliang.Service.FriendService;
import top.ethanliang.Util.pocketClass;

@RestController
@RequestMapping("/friends")
public class Friends {
    /**
     * @ author ethan
     * @ date  2024年08月28日 下午5:00
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Autowired
    private FriendService friendService;

    @GetMapping("/self/{myId}")
    public pocketClass getAllFriend(@PathVariable(value="myId") String myId,HttpSession httpSession){
        if(httpSession.getAttribute("id").equals(myId)) {
            return friendService.selectAllFriend(myId);
        }else{
            return null;
        }
    }

    @GetMapping("/{username}")
    public pocketClass getFriend(@PathVariable("username") String username){
        return friendService.selectFriend(username);
    }

    @GetMapping("/verify")
    public pocketClass verifyFriend(@RequestParam("presId") String presId,@RequestParam("afterId") String afterId,HttpSession httpSession){
        if(httpSession.getAttribute("id").equals(presId)) {
            relation r = new relation();
            r.setRelationShip(1);
            r.setPresId(presId);
            r.setAfterId(afterId);
            return friendService.verifyFriend(r);
        }else{
            return null;
        }
    }

    @DeleteMapping("/")
    public pocketClass deleteFriend(@RequestBody relation r, HttpSession httpSession){
        if(httpSession.getAttribute("id").equals(r.getPresId())) {
            return friendService.deleteFriend(r);
        }else{
            return null;
        }
    }

    @PostMapping("/")
    public pocketClass addFriend(@RequestBody relation r, HttpSession httpSession){
        if(httpSession.getAttribute("id").equals(r.getPresId())) {
            return friendService.insertFriend(r);
        }else{
            return null;
        }
    }

    @PutMapping("/")
    public pocketClass updateFriend(@RequestBody relation r, HttpSession httpSession){
        System.out.println(r);
        if(httpSession.getAttribute("id").equals(r.getAfterId())) {
            return friendService.agreeFriend(r);
        }
        else{
            return null;
        }
    }

    @GetMapping("/request/{myId}")
    public pocketClass getFriendRequest(@PathVariable(value="myId") String myId,HttpSession httpSession){
        if(httpSession.getAttribute("id").equals(myId)) {
            return friendService.getWantFriend(myId);
        }
        else{
            return null;
        }
    }
}
