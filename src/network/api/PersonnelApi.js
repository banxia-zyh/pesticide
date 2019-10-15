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
    addPersonnel (personnel, success, errror, failure) {
        HttpClient.request({
            url: '/api/personnel',
            method: 'POST',
            data: personnel,
            success: success,
            errror: errror,
            failure: failure
        })
    }
}
