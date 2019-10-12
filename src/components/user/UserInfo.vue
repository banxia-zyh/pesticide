<template>
    <div class="col-lg-8">
        <div class="card" style="padding: 50px">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">个人资料</h3>
            </div>
            <div class="card-body" style="text-align: center">
                <div class="form-horizontal">
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">昵称</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-success"
                                   placeholder="昵称" style="width: 70%;" type="text">
                            <!--<small class="form-text">Example help text that remains unchanged.</small>-->
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">性别</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="性别" style="width: 70%;" type="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">生日</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="生日" style="width: 70%;" type="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">地址</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="地址" style="width: 70%;" type="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">简介</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="简介" style="width: 70%;" type="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button @click="editDisable? editDisable=false: saveUserInfo" class="btn btn-primary"
                                    style="width: 30%">{{buttonText}}
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import UserService from '../../service/UserService'

    export default {
        name: 'UserInfo',
        data () {
            return {
                editDisable: true,
                userInfo: {
                    nickname: '',
                    sex: 'm',
                    birthday: '',
                    address: '',
                    avatarUrl: '',
                    intro: ''
                }
            }
        },
        created () {
            UserService.getUserInfo(response => {
                if (response.data.code === 0) {
                    this.userInfo = response.data.data
                }
                // TODO 错误提示
            })
        },
        computed: {
            buttonText () {
                return this.editDisable ? '编辑' : '保存'
            }
        },
        methods: {
            saveUserInfo () {
                UserService.updateUserInfo(this.userInfo, response => {
                    if (response.data.code === 0) {
                        this.editDisable = true
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
