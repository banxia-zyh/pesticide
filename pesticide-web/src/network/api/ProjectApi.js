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
    },
    updateProject (project, success, error, failure) {
        HttpClient.request({
            url: '/api/project',
            method: 'PUT',
            data: project,
            success: success,
            error: error,
            failure: failure
        })
    },
    getProjectList (userId, success, error, failure) {
        HttpClient.request({
            url: '/api/project',
            method: 'GET',
            params: {
                userId: userId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    removeProject (id, success, error, failure) {
        HttpClient.request({
            url: '/api/project',
            method: 'DELETE',
            params: {
                id: id
            },
            success: success,
            error: error,
            failure: failure
        })
    }
}
