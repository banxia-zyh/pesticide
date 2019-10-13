package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.UserInfo;
import group.geolo.defectmanager.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("user info of id =" + id + " is not found."));
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
