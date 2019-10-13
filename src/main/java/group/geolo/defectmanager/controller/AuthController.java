package group.geolo.defectmanager.controller;

import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.entity.UserAuth;
import group.geolo.defectmanager.service.AuthService;
import group.geolo.defectmanager.util.JwtAuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody UserAuth userAuth) {
        authService.register(userAuth);
        return new ResponseEntity<>(0);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserAuth userAuth) {
        userAuth = authService.login(userAuth);
        String token = JwtAuthUtils.createToken(userAuth.getUserInfoId(), 24 * 60 * 60 * 1000);
        return new ResponseEntity<>(0, token, null);
    }
}
