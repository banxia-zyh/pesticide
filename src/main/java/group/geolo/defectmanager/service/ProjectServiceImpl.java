package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Project;
import group.geolo.defectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(() ->
                new EntityNotFoundException("project of id = " + projectId + " is not found"));
    }

    @Override
    public void addProject(Project project) {
        if (projectRepository.existsById(project.getId())) {
            throw new IllegalArgumentException("the inserting project is exist.");
        }
        projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        if (!projectRepository.existsById(project.getId())) {
            throw new IllegalArgumentException("the updating project is not exist.");
        }
        projectRepository.save(project);
    }

    @Override
    public void removeProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
