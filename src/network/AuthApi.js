import axios from 'axios'

export default {
    register (userAuth, success, error) {
        axios.post('/api/auth/register', userAuth)
            .then(success)
            .catch(error)
    },

    login (userAuth, success, error) {
        axios.post('/api/auth/login', userAuth)
            .then(success)
            .catch(error)
    }
}
