import AuthApi from '../network/AuthApi'

export default {
    register (userAuth, success, error) {
        AuthApi.register(userAuth, success, error)
    },

    login (userAuth, success, error) {
        AuthApi.login(userAuth, success, error)
    }
}
