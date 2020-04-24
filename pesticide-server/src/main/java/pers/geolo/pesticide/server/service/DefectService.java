package pers.geolo.pesticide.server.service;

import pers.geolo.pesticide.server.entity.Defect;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface DefectService {

    Defect getDefect(Integer id);

    List<Defect> getDefectsOfProject(Integer projectId);

    List<Defect> getDefectsOfSubmitUser(Integer submitUserId);

    List<Defect> getDefectsOfResolveUser(Integer resolveUserId);

    void addDefect(Defect defect);

    void updateDefect(Defect defect);

    void removeDefect(Integer id);
}
