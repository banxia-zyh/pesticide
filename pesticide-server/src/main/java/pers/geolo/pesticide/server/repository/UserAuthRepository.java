package pers.geolo.pesticide.server.repository;

import pers.geolo.pesticide.server.entity.UserAuth;
import pers.geolo.pesticide.server.entity.UserAuthType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

    UserAuth getUserAuthByAuthTypeAndUsername(UserAuthType authType, String username);
}
