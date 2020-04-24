<template>
    <div class="page login-page">
        <div class="container d-flex align-items-center">
            <div class="form-holder has-shadow">
                <div class="row">
                    <!-- Logo & Information Panel-->
                    <div class="col-lg-6">
                        <div class="info d-flex align-items-center">
                            <div class="content">
                                <div class="logo">
                                    <h1>软件缺陷管理系统</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Form Panel    -->
                    <div class="col-lg-6 bg-white">
                        <div class="form d-flex align-items-center">
                            <div class="content">
                                <form class="form-validate" method="post">
                                    <div class="form-group">
                                        <input class="input-material" data-msg="Please enter your username"
                                               id="login-username"
                                               name="username" placeholder="用户名"
                                               required type="text"
                                               v-model="userAuth.username">
                                        <!--<label class="label-material" for="login-username" v-if="!hasData">用户名</label>-->
                                    </div>
                                    <div class="form-group">
                                        <input class="input-material" data-msg="Please enter your password"
                                               id="login-password"
                                               name="password" placeholder="密码"
                                               required type="password"
                                               v-model="userAuth.password">
                                        <!--<label class="label-material" for="login-password" v-if="!hasData">密码</label>-->
                                    </div>
                                    <div class="form-group">
                                        <button @click="login" class="btn btn-primary"
                                                name="registerSubmit" type="button">登录
                                        </button>
                                    </div>
                                    <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                                </form>
                                <a class="forgot-pass" href="#">忘记密码?</a><br>
                                <small>没有账号?</small>
                                <router-link :to="{path: '/auth/register'}" class="signup">注册</router-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyrights text-center">
            <p>Design by <a class="external" href="#">Bootstrapious</a>
                <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            </p>
        </div>
    </div>
</template>

<script>

    import AuthService from '../../service/AuthService'

    export default {
        name: 'Login',
        mounted () {
            let userAuth = this.$route.params.userAuth
            if (userAuth != null) {
                this.userAuth = userAuth
                this.hasData = true
            }
        },
        data () {
            return {
                userAuth: {
                    authType: 'USERNAME',
                    username: '',
                    password: ''
                },
                hasData: false
            }
        },
        methods: {
            login () {
                AuthService.login(this.userAuth, data => {
                    console.log(data)
                    this.$router.replace({path: '/index'})
                }, function (code, message) {
                    alert('登录失败！' + message)
                })
            }
        }
    }
</script>

<style>

</style>
