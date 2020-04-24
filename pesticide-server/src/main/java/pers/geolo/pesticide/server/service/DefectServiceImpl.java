package pers.geolo.pesticide.server.service;

import pers.geolo.pesticide.server.entity.Defect;
import pers.geolo.pesticide.server.entity.DefectModification;
import pers.geolo.pesticide.server.entity.DefectState;
import pers.geolo.pesticide.server.repository.DefectModificationRepository;
import pers.geolo.pesticide.server.repository.DefectRepository;
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
 * @date 2019/10/12
 */
@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectRepository defectRepository;
    @Autowired
    private DefectModificationRepository defectModificationRepository;
    @Autowired
    private HttpServletRequest request;

    private Comparator<Defect> submitTimeDescComparator = new Comparator<Defect>() {
        @Override
        public int compare(Defect o1, Defect o2) {
            return -(int) (o1.getSubmitTime().getTime() - o2.getSubmitTime().getTime());
        }
    };

    @Override
    public Defect getDefect(Integer id) {
        return defectRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("defect of id = " + id + "is not found."));
    }

    @Override
    public List<Defect> getDefectsOfProject(Integer projectId) {
        return defectRepository.findDefectsByProjectId(projectId)
                .stream()
                .sorted(submitTimeDescComparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Defect> getDefectsOfSubmitUser(Integer submitUserId) {
        return defectRepository.findDefectsBySubmitUserId(submitUserId)
                .stream()
                .sorted(submitTimeDescComparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Defect> getDefectsOfResolveUser(Integer resolveUserId) {
        return defectRepository.findDefectsByResolveUserId(resolveUserId)
                .stream()
                .sorted(submitTimeDescComparator)
                .collect(Collectors.toList());
    }

    @Override
    public void addDefect(Defect defect) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        defect.setSubmitUserId(userId);
        defect.setDefectState(DefectState.SUBMITTED);
        defect.setSubmitTime(new Date());
        defect = defectRepository.save(defect);
        DefectModification defectModification = new DefectModification();
        defectModification.setDefectId(defect.getId());
        defectModification.setModifyDescription("提交缺陷");
        defectModification.setModifyUserId(defect.getSubmitUserId());
        defectModification.setModifyTime(new Date());
        defectModification.setResultState(DefectState.SUBMITTED);
        defectModificationRepository.save(defectModification);
    }

    @Override
    public void updateDefect(Defect defect) {
        defectRepository.save(defect);
    }

    @Override
    public void removeDefect(Integer id) {
        defectRepository.deleteById(id);
    }
}
