import DefectApi from '../network/api/DefectApi'

export default {
    addDefect (defect, success, error, failure) {
        defect.submitUserId = localStorage.getItem('userId')
        DefectApi.addDefect(defect, success, error, failure)
    },
    getMyDefectList (success, error, failure) {
        let userId = localStorage.getItem('userId')
        DefectApi.getSubmitDefectList(userId, success, error, failure)
    },
    getReceiveDefectList (success, error, failure) {
        let userId = localStorage.getItem('userId')
        DefectApi.getReceivedDefectList(userId, success, error, failure)
    },
    getProjectDefectList (projectId, success, error, failure) {
        DefectApi.getProjectDefectList(projectId, success, error, failure)
    }
}
