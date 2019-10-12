package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Defect;
import group.geolo.defectmanager.entity.DefectModification;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface DefectModificationService {

    DefectModification getDefectModification(Integer id);

    List<DefectModification> getDefectModificationsOfDefect(Integer defectId);

    void addDefectModification(DefectModification defectModification);
}
