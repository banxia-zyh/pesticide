<template>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>序号</th>
                <th>职工编号</th>
                <th>姓名</th>
                <th>性别</th>
            </tr>
            </thead>
            <tbody>
            <tr :key="index" @click="select(user)" v-for="(user,index) in userList">
                <th scope="row">{{index + 1}}</th>
                <td>{{user.id}}</td>
                <td>{{user.nickname}}</td>
                <td>{{user.sex === 'm'? '男' : '女'}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import UserService from '../../service/UserService'

    export default {
        name: 'UserList',
        created () {
            this.getUserList()
        },
        props: {
            projectId: ''
        },
        data () {
            return {
                userList: []
            }
        },
        watch: {
            projectId () {
                this.getPersonnelList()
            },
            dialogVisible () {
                this.getPersonnelList()
            }
        },
        methods: {
            getUserList () {
                if (this.projectId !== '' && this.projectId !== undefined && this.projectId !== null) {
                    UserService.getUserInfoOfProject(this.projectId, data => {
                        this.userList = data
                    })
                } else {
                    UserService.getAllUserList(data => {
                        this.userList = data
                    })
                }
            },
            select (user) {
                this.$emit('select', user)
            }
        }
    }
</script>

<style scoped>

</style>
