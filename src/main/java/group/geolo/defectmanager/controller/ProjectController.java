package group.geolo.defectmanager.controller;

import group.geolo.defectmanager.annotation.Auth;
import group.geolo.defectmanager.entity.Project;
import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public ResponseEntity<Project> getProject(Integer id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(0, project, null);
    }

    @Auth
    @PostMapping
    public ResponseEntity<Void> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return new ResponseEntity<>(0);
    }

    @PutMapping
    public ResponseEntity<Void> updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return new ResponseEntity<>(0);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeProject(Integer id) {
        projectService.removeProject(id);
        return new ResponseEntity<>(0);
    }
}
