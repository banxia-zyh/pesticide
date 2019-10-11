package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Project;
import group.geolo.defectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void removeProject(int projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project getProject(int projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }
}
