import axios from 'axios'

export default {
    getUserInfo (success, error) {
        axios.get('/api/userInfo')
            .then(success)
            .catch(error)
    },
    updateUserInfo (userInfo, success, error) {
        axios.put('/api/userInfo', userInfo)
            .then(success)
            .catch(error)
    }
}
