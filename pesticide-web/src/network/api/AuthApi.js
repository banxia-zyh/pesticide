import HttpClient from '../HttpClient'
// import axios from 'axios'

export default {
    registerUrl: '/api/auth/register',
    register (userAuth, success, error, failure) {
        HttpClient.request({
            url: this.registerUrl,
            method: 'POST',
            data: userAuth,
            success: success,
            error: error,
            failure: failure
        })
    },

    loginUrl: '/api/auth/login',
    login (userAuth, success, error, failure) {
        HttpClient.request({
            url: this.loginUrl,
            method: 'POST',
            data: userAuth,
            success: data => {
                localStorage.setItem('token', data)
                success(data)
            },
            error: error,
            failure: failure
        })
    }
}
