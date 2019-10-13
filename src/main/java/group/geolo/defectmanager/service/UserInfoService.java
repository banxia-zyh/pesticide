package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.UserInfo;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface UserInfoService {

    UserInfo getUserInfo(Integer id);

    void updateUserInfo(UserInfo userInfo);
}
