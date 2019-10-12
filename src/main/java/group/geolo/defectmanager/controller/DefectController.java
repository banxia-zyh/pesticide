package group.geolo.defectmanager.controller;

import group.geolo.defectmanager.entity.Defect;
import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@RestController
@RequestMapping("defect")
public class DefectController {

    @Autowired
    private DefectService defectService;

    @GetMapping
    public ResponseEntity<Object> getDefects(Integer id, Integer projectId, Integer submitUserId, Integer resolveUserId) {
        Object defects = null;
        if (id != null) {
            defects = defectService.getDefect(id);
        } else if (projectId != null) {
            defects = defectService.getDefectsOfProject(projectId);
        } else if (submitUserId != null) {
            defects = defectService.getDefectsOfSubmitUser(submitUserId);
        } else if (resolveUserId != null) {
            defects = defectService.getDefectsOfResolveUser(resolveUserId);
        }
        return new ResponseEntity<>(0, defects, null);
    }

    @PostMapping
    public ResponseEntity<Void> addDefect(@RequestBody Defect defect) {
        defectService.addDefect(defect);
        return new ResponseEntity<>(0);
    }

    @PutMapping
    public ResponseEntity<Void> updateDefect(@RequestBody Defect defect) {
        defectService.updateDefect(defect);
        return new ResponseEntity<>(0);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeDefect(int id) {
        defectService.removeDefect(id);
        return new ResponseEntity<>(0);
    }
}
