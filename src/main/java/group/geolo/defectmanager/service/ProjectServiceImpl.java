package group.geolo.defectmanager.service;

import group.geolo.defectmanager.entity.Personnel;
import group.geolo.defectmanager.entity.Project;
import group.geolo.defectmanager.entity.RoleType;
import group.geolo.defectmanager.repository.PersonnelRepository;
import group.geolo.defectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    @Autowired
    private HttpServletRequest request;

    private Comparator<Project> createTimeDescComparator = new Comparator<Project>() {
        @Override
        public int compare(Project o1, Project o2) {
            return -(int) (o1.getCreateTime().getTime() - o2.getCreateTime().getTime());
        }
    };

    @Override
    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow(() ->
                new EntityNotFoundException("project of id = " + projectId + " is not found"));
    }

    @Override
    public List<Project> getProjectList(Integer userId) {
        return projectRepository.findProjectListByUserId(userId)
                .stream()
                .sorted(createTimeDescComparator)
                .collect(Collectors.toList());
    }

    @Override
    public void addProject(Project project) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        project.setManagerId(userId);
        project.setCreateTime(new Date());
        project = projectRepository.save(project);
        Personnel personnel = new Personnel();
        personnel.setProjectId(project.getId());
        personnel.setUserId(project.getManagerId());
        personnel.setRoleType(RoleType.ADMINISTRATOR);
        personnelRepository.save(personnel);
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
