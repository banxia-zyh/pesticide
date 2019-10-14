<template>
    <div class="col-lg-8">
        <div class="card" style="padding: 50px">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">个人资料</h3>
            </div>
            <div class="card-body" style="text-align: center">
                <div class="form-horizontal">
                    <div class="form-group row">
                        <div :style="{
                            backgroundImage: 'url(' + userInfo.avatarUrl + ')',backgroundSize:'contain'}"
                             class="center">
                            <div class="outside" onclick="$('#updateInput').click()">上传
                            </div>
                            <input @change="updateAvatar" accept="image/*" id="updateInput" ref="updateInput"
                                   style="visibility: hidden;" type="file">
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
                },
                selected: '',
                showUpdateView: false
            }
        },
        created () {
            UserService.getUserInfo(data => {
                this.userInfo = data
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
                    UserService.updateUserInfo(this.userInfo, data => {
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
                    UserService.getUserInfo(data => {
                        self.userInfo.avatarUrl = data.avatarUrl
                    })
                }, (code, message) => {
                    console.log('上传错误: code:' + code + ', message:' + message)
                })
            }
        }
    }
</script>

<style scoped>
    .center {
        display: block;
        position: relative;
        width: 200px;
        height: 200px;
        cursor: pointer;
        background-size: 100%;
        background-position: top left;
        border-radius: 100%;
        margin: 10px auto;
        -webkit-transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
        transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
        box-shadow: 0px 5px 10px #000;
    }

    .center:hover {
        box-shadow: 0px 5px 20px #000;
        background-size: 115%;
    }

    .center:hover .outside {
        -webkit-transform: rotate(-45deg) translate(0px) rotate(-315deg);
        -ms-transform: rotate(-45deg) translate(0px) rotate(-315deg);
        transform: rotate(-45deg) translate(0px) rotate(-315deg);
        background: rgba(121, 106, 238, 0.35);
        width: 200px;
        letter-spacing: 10px;
        line-height: 200px;
        height: 200px;
        margin-top: -100px;
        margin-left: -100px;
        -webkit-transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1), letter-spacing 1.5s ease-out;
        transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1), letter-spacing 1.5s ease-out;
    }

    .center .outside {
        display: block;
        position: absolute;
        line-height: 70px;
        text-align: center;
        letter-spacing: 2px;
        font-weight: 300;
        color: #fff;
        font-family: Oswald;
        border-radius: 100%;
        width: 70px;
        height: 70px;
        background: #796AEE;
        left: 50%;
        top: 50%;
        margin-top: -50px;
        margin-left: -50px;
        -webkit-transform: rotate(-180deg) translate(-100px) rotate(180deg);
        -ms-transform: rotate(-180deg) translate(-100px) rotate(180deg);
        transform: rotate(-180deg) translate(-100px) rotate(180deg);
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.5);
        -webkit-transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
        transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
    }

    .center .outside span {
        letter-spacing: 0;
    }
</style>
