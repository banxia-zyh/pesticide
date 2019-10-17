import UserApi from '../network/api/UserApi'

export default {
    getUserInfo (success, error) {
        UserApi.getUserInfo(data => {
            localStorage.setItem('userId', data.id)
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
    getAllUserList (succes, error, failure) {
        // UserApi.getAllUserList(succes, error, failure)
        let userList = []
        for (let i = 0; i < 10; i++) {
            userList.push({
                nickname: '用户' + i,
                sex: 'm',
                intro: 'intro..' + i
            })
        }
        succes(userList)
    }

}
