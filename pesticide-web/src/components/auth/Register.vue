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
                                <form class="form-validate">
                                    <div class="form-group">
                                        <input class="input-material" data-msg="Please enter your username"
                                               id="register-username"
                                               name="registerUsername" placeholder="用户名"
                                               required
                                               type="text" v-model="userAuth.username">
                                        <!--<label class="label-material" for="register-username">用户名</label>-->
                                    </div>
                                    <div class="form-group">
                                        <input class="input-material" data-msg="Please enter your password"
                                               id="register-password" name="registerPassword"
                                               placeholder="密码" required
                                               type="password"
                                               v-model="userAuth.password">
                                        <!--<label class="label-material" for="register-password">密码</label>-->
                                    </div>
                                    <!--<div class="form-group terms-conditions">-->
                                        <!--<input class="checkbox-template" data-msg="Your agreement is required"-->
                                               <!--id="register-agree" name="registerAgree"-->
                                               <!--required type="checkbox"-->
                                               <!--value="1">-->
                                        <!--<label for="register-agree">我已阅读并同意隐私政策</label>-->
                                    <!--</div>-->
                                    <div class="form-group">
                                        <button @click="register" class="btn btn-primary" id="regidter"
                                                name="registerSubmit" type="button">注册
                                        </button>
                                    </div>
                                </form>
                                <small>已有账号?</small>
                                <router-link :to="{path: '/auth/login'}" class="signup">登录</router-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyrights text-center">
            <p>Copyright &copy; 2019. <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect
                from <a href="http://www.cssmoban.com/" target="_blank" title="网页模板">网页模板</a></p>
        </div>
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
            register () {
                // let self = this
                AuthService.register(this.userAuth, data => {
                    alert('注册成功！')
                    this.$router.replace({name: 'Login', params: {userAuth: this.userAuth}})
                }, (code, message) => {
                    console.log('code = ' + code + ', message = ' + message)
                    alert('注册失败！' + message)
                })
            }
        }
    }
</script>

<style scoped>

</style>
