package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Defect;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
public interface DefectService {

    Defect getDefect(int id);

    List<Defect> getDefectsOfProject(int projectId);

    List<Defect> getDefectsOfSubmitUser(int submitUserId);

    List<Defect> getDefectsOfResolveUser(int resolveUserId);

    void addDefect(Defect defect);

    void updateDefect(Defect defect);

    void removeDefect(int id);
}
