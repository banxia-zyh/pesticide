package pers.geolo.pesticide.service;

import pers.geolo.pesticide.entity.DefectModification;
import pers.geolo.pesticide.entity.DefectModificationTable;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface DefectModificationService {

    DefectModification getDefectModification(Integer id);

    List<DefectModification> getDefectModificationsOfDefect(Integer defectId);

    List<DefectModificationTable> getDefectModificationTablesOfDefect(Integer defectId);

    void addDefectModification(DefectModification defectModification);
}
