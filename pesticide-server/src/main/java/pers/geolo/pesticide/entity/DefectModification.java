package pers.geolo.pesticide.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class DefectModification {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer defectId;
    private Integer modifyUserId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    private String modifyDescription;
    private DefectState resultState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDefectId() {
        return defectId;
    }

    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyDescription() {
        return modifyDescription;
    }

    public void setModifyDescription(String modifyDescription) {
        this.modifyDescription = modifyDescription;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public DefectState getResultState() {
        return resultState;
    }

    public void setResultState(DefectState resultState) {
        this.resultState = resultState;
    }
}
