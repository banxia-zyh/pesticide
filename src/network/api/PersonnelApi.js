import HttpClient from '../HttpClient'

export default {
    getPersonnelList (projectId, success, error, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'GET',
            params: {
                projectId: projectId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    addPersonnel (personnel, success, error, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'POST',
            data: personnel,
            success: success,
            error: error,
            failure: failure
        })
    },
    updatePersonnel (personnel, success, error, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'PUT',
            data: personnel,
            success: success,
            error: error,
            failure: failure
        })
    },
    removePersonnel (personnelId, success, error, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'DELETE',
            params: {
                personnelId: personnelId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    getUserPersonnelOfProject (userId, projectId, success, error, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'GET',
            params: {
                userId: userId,
                projectId: projectId
            },
            success: success,
            error: error,
            failure: failure
        })
    }
}
