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
    }
}
