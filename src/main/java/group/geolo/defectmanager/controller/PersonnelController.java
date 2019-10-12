package group.geolo.defectmanager.controller;

import group.geolo.defectmanager.entity.Personnel;
import group.geolo.defectmanager.entity.ResponseEntity;
import group.geolo.defectmanager.service.PersonnelService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@RestController
@RequestMapping("personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping
    public ResponseEntity<Object> getPersonnel(Integer personnelId, Integer projectId) {
        if (personnelId != null) {
            Personnel personnel = personnelService.getPersonnel(personnelId);
            return new ResponseEntity<>(0, personnel, null);
        } else {
            List<Personnel> personnelList = personnelService.getPersonnels(projectId);
            return new ResponseEntity<>(0, personnelList, null);
        }
    }

    @PostMapping
    public ResponseEntity<Void> addPersonnel(@RequestBody Personnel personnel) {
        personnelService.addPersonnel(personnel);
        return new ResponseEntity<>(0);
    }

    @PutMapping
    public ResponseEntity<Void> updatePersonnel(@RequestBody Personnel personnel) {
        personnelService.updatePersonnel(personnel);
        return new ResponseEntity<>(0);
    }

    @DeleteMapping
    public ResponseEntity<Void> removePersonnel(Integer personnelId) {
        personnelService.removePersonnel(personnelId);
        return new ResponseEntity<>(0);
    }
}
