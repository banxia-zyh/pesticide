import HttpClient from '../HttpClient'

export default {
    addProject (project, success, error, failure) {
        HttpClient.request({
            url: '/api/project',
            method: 'POST',
            data: project,
            success: success,
            error: error,
            failure: failure
        })
    }
}
