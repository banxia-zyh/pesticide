import axios from 'axios'
import AuthInterceptor from '../network/interceptor/AuthInterceptor'

axios.interceptors.request.use(config => {
    AuthInterceptor.beforeRequest(config)
    return config
}, error => {
    AuthInterceptor.errorRequest(error)
})
