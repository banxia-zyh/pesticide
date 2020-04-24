package pers.geolo.pesticide.service;

import pers.geolo.pesticide.entity.UserInfo;
import pers.geolo.pesticide.repository.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface UserInfoService {

    UserInfo getUserInfo(Integer id);

    List<UserInfo> getAllUserInfo();

    void updateUserInfo(UserInfo userInfo);

    void updateAvatar(Integer userId, MultipartFile avatarFile);

    FileInfo getAvatar(String avatarId);

    List<UserInfo> getUserInfoOfProject(Integer projectId);
}
