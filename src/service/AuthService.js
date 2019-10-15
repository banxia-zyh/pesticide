import AuthApi from '../network/api/AuthApi'

export default {
    register (userAuth, success, error) {
        AuthApi.register(userAuth, success, error)
    },

    login (userAuth, success, error, failure) {
        AuthApi.login(userAuth, data => {
            localStorage.setItem('loginUsername', userAuth.username)
            success(data)
        }, error)
    }
}
