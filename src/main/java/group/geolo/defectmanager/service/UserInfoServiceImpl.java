package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.MultipartFileInfo;
import group.geolo.defectmanager.entity.UserInfo;
import group.geolo.defectmanager.repository.FileInfo;
import group.geolo.defectmanager.repository.FileRepository;
import group.geolo.defectmanager.repository.UserInfoRepository;
import group.geolo.defectmanager.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("user info of id =" + id + " is not found."));
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void updateAvatar(Integer userId, MultipartFile avatarFile) {
        FileInfo fileInfo = new MultipartFileInfo(avatarFile);
        try {
            UserInfo userInfo = getUserInfo(userId);
            String avatarId = fileRepository.saveFile(fileInfo);
            String currentUrl = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort()
                    + request.getServletPath() + "?avatarId=" + avatarId;
            userInfo.setAvatarUrl(currentUrl);
            updateUserInfo(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public FileInfo getAvatar(String avatarId) {
        try {
            FileInfo fileInfo = fileRepository.getFile(avatarId);
            IOUtils.connectStream(fileInfo.getInputStream(), response.getOutputStream());
            return fileInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
