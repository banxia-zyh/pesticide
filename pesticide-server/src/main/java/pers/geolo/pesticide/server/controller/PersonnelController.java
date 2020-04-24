package pers.geolo.pesticide.server.controller;

import pers.geolo.pesticide.server.entity.Personnel;
import pers.geolo.pesticide.server.entity.ResponseEntity;
import pers.geolo.pesticide.server.service.PersonnelService;
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
    public ResponseEntity<Object> getPersonnel(Integer personnelId, Integer projectId, Integer userId) {
        if (personnelId != null) {
            Personnel personnel = personnelService.getPersonnel(personnelId);
            return new ResponseEntity<>(0, personnel, null);
        } else if (projectId != null && userId != null) {
            List<Personnel> personnelList = personnelService.getUserPersonnelOfProject(userId, projectId);
            //TODO 支持一个用户在一个项目多个角色
            return new ResponseEntity<>(0, personnelList.get(0), null);
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
