import UserApi from '../network/api/UserApi'

export default {
    getUserInfo (success, error) {
        UserApi.getUserInfo(success, error)
    },
    updateUserInfo (userInfo, success, error) {
        UserApi.updateUserInfo(userInfo, success, error)
    },
    updateAvatar (avatarFile, success, error, failure) {
        let data = new FormData()
        data.append('avatar', avatarFile)
        UserApi.updateAvatar(data, success, error, failure)
    }

}
