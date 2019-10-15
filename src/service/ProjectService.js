import ProjectApi from '../network/api/ProjectApi'

export default {
    addProject (project, success, error, failure) {
        ProjectApi.addProject(project, success, error, failure)
    }
}
