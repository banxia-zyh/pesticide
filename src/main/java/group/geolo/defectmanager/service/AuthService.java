package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.UserAuth;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
public interface AuthService {

    void register(UserAuth userAuth);

    UserAuth login(UserAuth userAuth);
}
