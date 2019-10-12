package group.geolo.defectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/12
 */
@Entity
public class Defect {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer submitUserId;
    private Date submitTime;
    private String title;
    private String description;
    private DefectState defectState;
    private Integer projectId;
    private Integer resolveUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Integer submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DefectState getDefectState() {
        return defectState;
    }

    public void setDefectState(DefectState defectState) {
        this.defectState = defectState;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getResolveUserId() {
        return resolveUserId;
    }

    public void setResolveUserId(Integer resolveUserId) {
        this.resolveUserId = resolveUserId;
    }
}
