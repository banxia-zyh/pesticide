package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Personnel;
import group.geolo.defectmanager.repository.PersonnelRepository;
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
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public Personnel getPersonnel(int personnelId) {
        return personnelRepository.findById(personnelId).orElseThrow(() ->
                new EntityNotFoundException("personnel of id = " + personnelId + " not found."));
    }

    @Override
    public List<Personnel> getPersonnels(int projectId) {
        return personnelRepository.findPersonnelsByProjectId(projectId);
    }

    @Override
    public void addPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    @Override
    public void updatePersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    @Override
    public void removePersonnel(int personnelId) {
        personnelRepository.deleteById(personnelId);
    }
}
