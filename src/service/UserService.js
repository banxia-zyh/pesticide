import UserApi from '../network/UserApi'

export default {
    getUserInfo (success, error) {
        UserApi.getUserInfo(success, error)
    },
    updateUserInfo (userInfo, success, error) {
        UserApi.updateUserInfo(userInfo, success, error)
    }
}
