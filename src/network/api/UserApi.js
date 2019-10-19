import axios from 'axios'
import HttpClient from '../HttpClient'

export default {
    getUserInfo (success, error) {
        HttpClient.request({
            url: '/api/userInfo',
            method: 'GET',
            success: success,
            error: error
        })
    },
    updateUserInfo (userInfo, success, error) {
        axios.put('/api/userInfo', userInfo)
            .then(success)
            .catch(error)
    },
    updateAvatar (fileForm, success, error, failure) {
        HttpClient.request({
            url: '/api/userInfo/avatar',
            method: 'POST',
            data: fileForm,
            success: success,
            error: error,
            failure: failure
        })
    },
    getAllUser (success, error, failure) {
        HttpClient.request({
            url: '/api/userInfo/all',
            method: 'GET',
            success: success,
            error: error,
            failure: failure
        })
    },
    getUserInfoOfProject (projectId, success, error, failure) {
        HttpClient.request({
            url: '/api/userInfo/project',
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
