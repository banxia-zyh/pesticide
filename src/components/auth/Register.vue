<template>
    <div>
        <input title="用户名" type="text" v-model="userAuth.username"> <br>
        <input title="密码" type="password" v-model="userAuth.password"> <br>
        <button @click="login">注册</button>
    </div>
</template>

<script>

    import AuthService from '../../service/AuthService'

    export default {
        name: 'Login',
        data () {
            return {
                userAuth: {
                    authType: 'USERNAME',
                    username: '',
                    password: ''
                }
            }
        },
        methods: {
            login () {
                let self = this
                AuthService.register(this.userAuth, response => {
                    if (response.data.code === 0) {
                        alert('注册成功！')
                        self.$router.replace({name: 'Login', params: {userAuth: self.userAuth}})
                    } else {
                        alert('注册失败！' + response.data.message)
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
