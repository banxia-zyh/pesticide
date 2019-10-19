import HttpClient from '../HttpClient'

export default {
    addDefect (defect, success, error, failure) {
        HttpClient.request({
            url: '/api/defect',
            method: 'POST',
            data: defect,
            success: success,
            error: error,
            failure: failure
        })
    },
    getSubmitDefectList (submitUserId, success, error, failure) {
        HttpClient.request({
            url: '/api/defect',
            method: 'GET',
            params: {
                submitUserId: submitUserId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    getReceivedDefectList (resolveUserId, success, error, failure) {
        HttpClient.request({
            url: '/api/defect',
            method: 'GET',
            params: {
                resolveUserId: resolveUserId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    getProjectDefectList (projectId, success, error, failure) {
        HttpClient.request({
            url: '/api/defect',
            method: 'GET',
            params: {
                projectId: projectId
            },
            success: success,
            error: error,
            failure: failure
        })
    }
}
