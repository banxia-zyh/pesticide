package pers.geolo.pesticide.service;

import pers.geolo.pesticide.entity.Personnel;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface PersonnelService {

    Personnel getPersonnel(Integer personnelId);

    List<Personnel> getPersonnels(Integer projectId);

    void addPersonnel(Personnel personnel);

    void updatePersonnel(Personnel personnel);

    void removePersonnel(Integer personnelId);

    List<Personnel> getUserPersonnelOfProject(Integer userId, Integer projectId);
}
