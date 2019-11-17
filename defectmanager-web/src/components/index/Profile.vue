<template>
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar" @click="toUserInfo" >
            <div :style="{backgroundImage: 'url(' + userInfo.avatarUrl + ')',backgroundSize:'contain'}"
                 class="circle-avatar" style="width: 55px;height: 55px;margin: 0px">
            </div>
        </div>
        <div class="title">
            <h1 class="h4">{{userInfo.nickname}}</h1>
            <p>{{userInfo.intro}}</p>
        </div>
    </div>
</template>

<script>
    import EventBus from '../../util/EventBus'
    import UserService from '../../service/UserService'

    export default {
        name: 'Profile',
        data () {
            return {
                userInfo: {
                    avatarUrl: '',
                    nickname: '',
                    intro: ''
                }
            }
        },
        created () {
            EventBus.$on('userInfo-change', userInfo => {
                this.userInfo = userInfo
            })
            UserService.getMyUserInfo(userInfo => {
                this.userInfo = userInfo
            })
        },
        methods: {
            toUserInfo () {
                EventBus.$emit('change-content', 'UserInfo')
            }
        }
    }
</script>

<style scoped>
    @import "../../../static/template/css/circleAvatar.css";
</style>
