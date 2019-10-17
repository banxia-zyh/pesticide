package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Defect;
import group.geolo.defectmanager.entity.DefectModification;
import group.geolo.defectmanager.repository.DefectModificationRepository;
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
public class DefectModificationServiceImpl implements DefectModificationService {

    @Autowired
    private DefectModificationRepository defectModificationRepository;
    @Autowired
    private DefectRepository defectRepository;

    @Override
    public DefectModification getDefectModification(Integer id) {
        return defectModificationRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("DefectModification of id = " + id + "is not found."));
    }

    @Override
    public List<DefectModification> getDefectModificationsOfDefect(Integer defectId) {
        return defectModificationRepository.getDefectModificationsByDefectId(defectId);
    }

    @Override
    public void addDefectModification(DefectModification defectModification) {
        defectModificationRepository.save(defectModification);
        Defect defect = defectRepository.findById(defectModification.getDefectId()).orElseThrow(() ->
                new EntityNotFoundException("the defect of modification is not found."));
        defect.setDefectState(defectModification.getResultState());
        defectRepository.save(defect);
    }
}
