<template>
    <div class="col-lg-8">
        <div class="card" style="padding: 50px">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">个人资料</h3>
            </div>
            <div class="card-body" style="text-align: center; ">
                <div class="form-horizontal">
                    <div class="form-group row">
                        <div :style="{
                            backgroundImage: 'url(' + userInfo.avatarUrl + ')',backgroundSize:'contain'}"
                             class="circle-avatar">
                            <div class="outside-button" onclick="$('#updateInput').click()">上传
                            </div>
                            <input @change="updateAvatar" accept="image/*" id="updateInput" ref="updateInput"
                                   style="visibility: hidden;" type="file">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">用户名</label>
                        <div class="col-sm-9">
                            <label class="form-control form-control-success"
                                   style="width: 70%; text-align: left">{{username}}</label>
                            <!--<small class="form-text">Example help text that remains unchanged.</small>-->
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">昵称</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-success"
                                   placeholder="昵称" style="width: 70%;" v-model="userInfo.nickname">
                            <!--<small class="form-text">Example help text that remains unchanged.</small>-->
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">性别</label>
                        <div class="col-sm-9">

                            <select :disabled="editDisable" class="form-control form-control-warning"
                                    style="width: 70%;" v-model="userInfo.sex">
                                <option disabled value="">请选择</option>
                                <option value="m">男</option>
                                <option value="w">女</option>
                            </select>
                            <!--<input :disabled="editDisable" class="form-control form-control-warning"-->
                            <!--placeholder="性别" style="width: 70%;" v-model="sexText">-->
                        </div>

                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">生日</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="生日" style="width: 70%;" type="date" v-model="userInfo.birthday">
                            <!--<el-date-picker :disabled="editDisable" type="date" v-model="userInfo.birthday"-->
                            <!--value-format="yyyy-MM-dd" style="margin-left: -100px;"/>-->
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">地址</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-control-warning"
                                   placeholder="地址" style="width: 70%;" v-model="userInfo.address">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">简介</label>
                        <div class="col-sm-9">
                            <input :disabled="editDisable" class="form-control form-contxol-warning"
                                   placeholder="简介" style="width: 70%;" v-model="userInfo.intro">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button @click="saveUserInfo" class="btn btn-primary"
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
    import EventBus from '../../util/EventBus'

    export default {
        name: 'UserInfo',
        data () {
            return {
                editDisable: true,
                username: '',
                userInfo: {
                    nickname: '',
                    sex: 'm',
                    birthday: '',
                    address: '',
                    avatarUrl: '',
                    intro: ''
                },
                selected: '',
                showUpdateView: false
            }
        },
        created () {
            EventBus.$emit('update-load', true)
            this.username = localStorage.getItem('loginUsername')
            UserService.getMyUserInfo(data => {
                this.userInfo = data
                EventBus.$emit('update-load', false)
            })
        },
        computed: {
            buttonText () {
                return this.editDisable ? '编辑' : '保存'
            },
            sexText () {
                return this.userInfo.sex === 'm' ? '男' : '女'
            }
        },
        methods: {
            saveUserInfo () {
                if (this.editDisable) {
                    this.editDisable = false
                } else {
                    console.log(this.userInfo.birthday)
                    UserService.updateUserInfo(this.userInfo, () => {
                        EventBus.$emit('userInfo-change', {
                            avatarUrl: this.userInfo.avatarUrl,
                            nickname: this.userInfo.nickname,
                            intro: this.userInfo.intro
                        })
                        this.editDisable = true
                    }, error => {
                        alert('网络错误')
                        console.log(error)
                    })
                }
            },
            updateAvatar () {
                let self = this
                UserService.updateAvatar(this.$refs.updateInput.files[0], data => {
                    console.log('头像上传成功')
                    UserService.getMyUserInfo(data => {
                        self.userInfo.avatarUrl = data.avatarUrl
                        EventBus.$emit('userInfo-change', data)
                    })
                }, (code, message) => {
                    console.log('上传错误: code:' + code + ', message:' + message)
                })
            }
        }
    }
</script>

<style scoped>
    @import '../../../static/template/css/circleAvatar.css';
</style>
