package group.geolo.defectmanager.controller;

import group.geolo.defectmanager.annotation.Auth;
import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.entity.UserInfo;
import group.geolo.defectmanager.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Auth
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public ResponseEntity<UserInfo> getUserInfo(@SessionAttribute("userId") Integer userId) {
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        return new ResponseEntity<>(0, userInfo, null);
    }

    @PutMapping
    public ResponseEntity<Void> updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return new ResponseEntity<>(0);
    }
}
