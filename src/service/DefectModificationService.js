import DefectModificationApi from '../network/api/DefectModificationApi'

export default {
    getDefectModificationList (defectId, success, error, failure) {
        DefectModificationApi.getDefectModificationList(defectId, success, error, failure)
    },
    addModification (defectModification, success, error, failure) {
        DefectModificationApi.addModification(defectModification, success, error, failure)
    }
}
