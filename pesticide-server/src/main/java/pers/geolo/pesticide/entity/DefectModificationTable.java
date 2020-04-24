package pers.geolo.pesticide.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/19
 */
public class DefectModificationTable {

    private Integer id;
    private Integer defectId;
    private Integer modifyUserId;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    private String modifyDescription;
    private DefectState resultState;
    private String modifyUsername;

    public DefectModificationTable(DefectModification defectModification, String username) {
        this.id = defectModification.getId();
        this.defectId = defectModification.getDefectId();
        this.modifyUserId = defectModification.getModifyUserId();
        this.modifyTime = defectModification.getModifyTime();
        this.modifyDescription = defectModification.getModifyDescription();
        this.resultState = defectModification.getResultState();
        this.modifyUsername = username;
    }

    public DefectModificationTable() {
    }

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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyDescription() {
        return modifyDescription;
    }

    public void setModifyDescription(String modifyDescription) {
        this.modifyDescription = modifyDescription;
    }

    public DefectState getResultState() {
        return resultState;
    }

    public void setResultState(DefectState resultState) {
        this.resultState = resultState;
    }

    public String getModifyUsername() {
        return modifyUsername;
    }

    public void setModifyUsername(String modifyUsername) {
        this.modifyUsername = modifyUsername;
    }
}
