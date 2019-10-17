import DefectModificationApi from '../network/api/DefectModificationApi'

export default {
    getDefectModificationList (defectId, success, error, failure) {
        DefectModificationApi.getDefectModificationList(defectId, success, error, failure)
    }
}
