package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Project;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
public interface ProjectService {

    void addProject(Project project);

    void updateProject(Project project);

    void removeProject(Integer projectId);

    Project getProject(Integer projectId);

    List<Project> getProjectList(Integer userId);
}
