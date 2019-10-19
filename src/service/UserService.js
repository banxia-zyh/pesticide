import UserApi from '../network/api/UserApi'

export default {
    getMyUserInfo (success, error) {
        UserApi.getUserInfo(null, data => {
            localStorage.setItem('userId', data.id)
            success(data)
        }, error)
    },
    getUserInfo (userId, success, error) {
        UserApi.getUserInfo(userId, data => {
            success(data)
        }, error)
    },
    updateUserInfo (userInfo, success, error) {
        UserApi.updateUserInfo(userInfo, success, error)
    },
    updateAvatar (avatarFile, success, error, failure) {
        let data = new FormData()
        data.append('avatar', avatarFile)
        UserApi.updateAvatar(data, success, error, failure)
    },
    getAllUserList (success, error, failure) {
        UserApi.getAllUser(success, error, failure)
    },
    getUserInfoOfProject (projectId, success, error, failure) {
        UserApi.getUserInfoOfProject(projectId, success, error, failure)
    }

}
