import PersonnelApi from '../network/api/PersonnelApi'

export default {
    getPersonnelList (projectId, success, error, failure) {
        PersonnelApi.getPersonnelList(projectId, success, error, failure)
    },
    addPersonnel (personnel, success, error, failure) {
        PersonnelApi.addPersonnel(personnel, success, error, failure)
    }
}
