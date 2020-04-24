package pers.geolo.pesticide.server.service;

import pers.geolo.pesticide.server.entity.UserAuth;
import pers.geolo.pesticide.server.entity.UserInfo;
import pers.geolo.pesticide.server.exception.AuthException;
import pers.geolo.pesticide.server.repository.UserAuthRepository;
import pers.geolo.pesticide.server.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void register(UserAuth userAuth) {
        UserAuth existUserAuth = userAuthRepository
                .getUserAuthByAuthTypeAndUsername(userAuth.getAuthType(), userAuth.getUsername());
        if (existUserAuth != null) {
            throw new AuthException(-1, "register identity is exist!");
        }
        UserInfo userInfo = new UserInfo();
        // 设置默认用户名
        userInfo.setNickname(userAuth.getUsername());
        userInfo = userInfoRepository.save(userInfo);
        userAuth.setUserInfoId(userInfo.getId());
        userAuthRepository.save(userAuth);
    }

    @Override
    public UserAuth login(UserAuth userAuth) {
        UserAuth existUserAuth = userAuthRepository
                .getUserAuthByAuthTypeAndUsername(userAuth.getAuthType(), userAuth.getUsername());
        if (existUserAuth == null) {
            throw new AuthException(-2, "the user is not exist!");
        }
        if (!existUserAuth.getPassword().equals(userAuth.getPassword())) {
            throw new AuthException(-3, "authIdentity or authPassword is error!");
        }
        return existUserAuth;
    }
}
