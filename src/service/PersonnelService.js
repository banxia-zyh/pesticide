import PersonnelApi from '../network/api/PersonnelApi'

export default {
    getPersonnelList (projectId, success, error, failure) {
        PersonnelApi.getPersonnelList(projectId, success, error, failure)
    },
    addPersonnel (personnel, success, error, failure) {
        PersonnelApi.addPersonnel(personnel, success, error, failure)
    },
    updatePersonnel (personnel, success, error, failure) {
        PersonnelApi.updatePersonnel(personnel, success, error, failure)
    },
    removePersonnel (personnelId, success, error, failure) {
        PersonnelApi.removePersonnel(personnelId, success, error, failure)
    },
    getMyPersonnel (projectId, success, error) {
        let userId = localStorage.getItem('userId')
        PersonnelApi.getUserPersonnelOfProject(userId, projectId, success, error)
        // PersonnelApi.getPersonnelList(projectId, data => {
        //     for (let i = 0; i < data.length; i++) {
        //         if (data[i].userId == userId) {
        //             success(data[i])
        //             return
        //         }
        //     }
        // }, error)
    }
}
