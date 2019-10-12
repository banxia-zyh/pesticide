package group.geolo.defectmanager.repository;

import group.geolo.defectmanager.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Repository
public interface DefectRepository extends JpaRepository<Defect, Integer> {

    List<Defect> findDefectsByProjectId(int projectId);

    List<Defect> findDefectsBySubmitUserId(int submitUserId);

    List<Defect> findDefectsByResolveUserId(int resolveUserId);
}
