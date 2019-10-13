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
    }
}
