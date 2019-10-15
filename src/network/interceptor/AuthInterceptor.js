export default {
    beforeRequest (config) {
        config.headers.Authorization = localStorage.getItem('token')
    },
    errorRequest (error) {
        console.log(error)
    }
}
