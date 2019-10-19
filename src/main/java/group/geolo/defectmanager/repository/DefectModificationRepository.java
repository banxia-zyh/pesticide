package group.geolo.defectmanager.repository;

import group.geolo.defectmanager.entity.DefectModification;
import group.geolo.defectmanager.entity.DefectModificationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Repository
public interface DefectModificationRepository extends JpaRepository<DefectModification, Integer> {

    List<DefectModification> getDefectModificationsByDefectId(Integer defectId);

//    @Query("select new group.geolo.defectmanager.entity.DefectModificationTable(d, u) from DefectModification d, " +
//            "group.geolo.defectmanager.entity.UserInfo u where ?1 = d.defectId and d.modifyUserId = u.id")
//    List<DefectModificationTable> getDefectModificationTablesByDefectId( Integer defectId);
}
