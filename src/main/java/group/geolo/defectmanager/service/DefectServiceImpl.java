package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Defect;
import group.geolo.defectmanager.repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectRepository defectRepository;

    @Override
    public Defect getDefect(int id) {
        return defectRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("defect of id = " + id + "is not found."));
    }

    @Override
    public List<Defect> getDefectsOfProject(int projectId) {
        return defectRepository.findDefectsByProjectId(projectId);
    }

    @Override
    public List<Defect> getDefectsOfSubmitUser(int submitUserId) {
        return defectRepository.findDefectsBySubmitUserId(submitUserId);
    }

    @Override
    public List<Defect> getDefectsOfResolveUser(int resolveUserId) {
        return defectRepository.findDefectsByResolveUserId(resolveUserId);
    }

    @Override
    public void addDefect(Defect defect) {
        defectRepository.save(defect);
    }

    @Override
    public void updateDefect(Defect defect) {
        defectRepository.save(defect);
    }

    @Override
    public void removeDefect(int id) {
        defectRepository.deleteById(id);
    }
}
