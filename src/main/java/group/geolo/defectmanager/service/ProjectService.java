package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Project;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
public interface ProjectService {

    void addProject(Project project);

    void updateProject(Project project);

    void removeProject(int projectId);

    Project getProject(int projectId);
}
