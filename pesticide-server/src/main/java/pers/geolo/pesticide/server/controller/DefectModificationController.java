package pers.geolo.pesticide.server.controller;

import pers.geolo.pesticide.server.entity.DefectModification;
import pers.geolo.pesticide.server.entity.ResponseEntity;
import pers.geolo.pesticide.server.service.DefectModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@RestController
@RequestMapping("defectModification")
public class DefectModificationController {

    @Autowired
    private DefectModificationService defectModificationService;

    @GetMapping
    public ResponseEntity<Object> getDefectModifications(Integer id, Integer defectId) {
        Object defectModifications = null;
        if (id != null) {
            defectModifications = defectModificationService.getDefectModification(id);
        } else if (defectId != null) {
            defectModifications = defectModificationService.getDefectModificationTablesOfDefect(defectId);
        }
        return new ResponseEntity<>(0, defectModifications, null);
    }

    @PostMapping
    public ResponseEntity<Void> addDefectModification(@RequestBody DefectModification defectModification) {
        defectModificationService.addDefectModification(defectModification);
        return new ResponseEntity<>(0);
    }
}
