import axios from 'axios'

export default {

    request (config) {
        axios.request({
            url: config.url,
            method: config.method,
            headers: config.headers,
            params: config.params,
            data: config.data
        }).then(function (response) {
            let responseEntity = response.data
            if (responseEntity.code === 0) {
                if (config.success != null) {
                    config.success(responseEntity.data)
                }
            } else {
                if (config.error != null) {
                    config.error(responseEntity.code, responseEntity.message)
                }
            }
        }).catch(function (e) {
            if (config.failure != null) {
                config.failure(e)
            }
        })
    }
}
