export default {
    beforeRequest (config) {
        let authorization = localStorage.getItem('token')
        config.headers.Authorization = authorization
    },
    errorRequest (error) {
        console.log(error)
    }
}
