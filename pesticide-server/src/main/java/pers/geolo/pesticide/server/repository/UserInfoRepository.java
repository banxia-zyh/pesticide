package pers.geolo.pesticide.server.repository;

import pers.geolo.pesticide.server.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    @Query("select userInfo from UserInfo userInfo, pers.geolo.pesticide.server.entity.Personnel personnel" +
            " where personnel.projectId = :projectId and personnel.userId = userInfo.id")
    List<UserInfo> getUserInfoOfProject(@Param("projectId") Integer projectId);
}
