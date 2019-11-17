package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.UserInfo;
import group.geolo.defectmanager.repository.FileInfo;
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
