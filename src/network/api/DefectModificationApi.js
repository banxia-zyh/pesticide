import HttpClient from '../HttpClient'

export default {
    getDefectModificationList (defectId, success, error, failure) {
        HttpClient.request({
            url: '/api/defectModification',
            method: 'GET',
            params: {
                defectId: defectId
            },
            success: success,
            error: error,
            failure: failure
        })
    },
    addModification (defectModification, success, error, failure) {
        HttpClient.request({
            url: '/api/defectModification',
            method: 'POST',
            data: defectModification,
            success: success,
            error: error,
            failure: failure
        })
    }
}
