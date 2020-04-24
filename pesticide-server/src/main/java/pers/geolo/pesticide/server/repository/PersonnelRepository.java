package pers.geolo.pesticide.server.repository;

import pers.geolo.pesticide.server.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    List<Personnel> findPersonnelsByProjectId(int projectId);

    List<Personnel> findPersonnelsByUserIdAndProjectId(Integer userId, Integer projectId);
}
