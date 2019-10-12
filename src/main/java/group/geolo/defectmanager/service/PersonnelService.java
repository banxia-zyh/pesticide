package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Personnel;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface PersonnelService {

    Personnel getPersonnel(int personnelId);

    List<Personnel> getPersonnels(int projectId);

    void addPersonnel(Personnel personnel);

    void updatePersonnel(Personnel personnel);

    void removePersonnel(int personnelId);
}
