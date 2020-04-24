package pers.geolo.pesticide.controller;

import pers.geolo.pesticide.annotation.Auth;
import pers.geolo.pesticide.entity.ResponseEntity;
import pers.geolo.pesticide.entity.UserInfo;
import pers.geolo.pesticide.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private HttpSession session;

    @Auth
    @GetMapping
    public ResponseEntity<UserInfo> getUserInfo(Integer userId) {
        if (userId == null) {
            userId = (Integer) session.getAttribute("userId");
        }
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        return new ResponseEntity<>(0, userInfo, null);
    }

    @Auth
    @GetMapping("project")
    public ResponseEntity<List<UserInfo>> getUserInfoOfProject(Integer projectId) {
        List<UserInfo> userInfoList = userInfoService.getUserInfoOfProject(projectId);
        return new ResponseEntity<>(0, userInfoList, null);
    }

    @Auth
    @GetMapping("all")
    public ResponseEntity<List<UserInfo>> getAllUserInfo() {
        List<UserInfo> userInfoList = userInfoService.getAllUserInfo();
        return new ResponseEntity<>(0, userInfoList, null);
    }

    @Auth
    @PutMapping
    public ResponseEntity<Void> updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return new ResponseEntity<>(0);
    }

    @GetMapping("/avatar")
    public void getAvatar(String avatarId) {
        userInfoService.getAvatar(avatarId);
    }

    @Auth
    @PostMapping(value = "/avatar")
    public ResponseEntity<Void> uploadAvatar(@SessionAttribute("userId") Integer userId,
                                             MultipartFile avatar) throws IOException {
        userInfoService.updateAvatar(userId, avatar);
        return new ResponseEntity<>(0);
    }
}
