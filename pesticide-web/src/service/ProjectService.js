import ProjectApi from '../network/api/ProjectApi'

export default {
    addProject (project, success, error, failure) {
        ProjectApi.addProject(project, success, error, failure)
    },
    updateProject (project, success, error, failure) {
        ProjectApi.updateProject(project, success, error, failure)
    },
    getMyProjectList (success, error, failure) {
        let userId = localStorage.getItem('userId')
        if (userId == null) {
            // TODO 重新获取
        }
        ProjectApi.getProjectList(userId, success, error, failure)
    },
    removeProject (id, success, error, failure) {
        ProjectApi.removeProject(id, success, error, failure)
    }
}
