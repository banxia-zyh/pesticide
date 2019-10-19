<template>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>职位</th>
        </tr>
        </thead>
        <el-dialog
            :title="dialogTitle"
            :visible="dialogVisible"
            @close="dialogVisible = false">
            <personnel-editor
                :nickname="dialogNickname"
                :personnel="dialogPersonnel"
                @save-personnel="onSavePersonnel">
            </personnel-editor>
        </el-dialog>
        <tbody>
        <tr :key="index" v-for="(personnel,index) in personnelList">
            <th scope="row">{{index + 1}}</th>
            <td>{{getUsername(personnel.userId)}}</td>
            <td>{{getRoleTypeName(personnel.roleType)}}</td>
            <td>
                <button @click="edit(personnel)" class="btn btn-primary btn-sm" v-if="hasPermission('EDIT')">编辑</button>
                <button @click="remove(personnel.id)" class="btn btn-primary btn-sm" v-if="hasPermission('DELETE')">删除</button>
            </td>
        </tr>
        </tbody>
    </table>

</template>

<script>
    import PersonnelService from '../../service/PersonnelService'
    import RoleTypeNameMap from '../../entity/RoleTypeNameMap'
    import PersonnelEditor from './PersonnelEditor'
    import EventBus from '../../util/EventBus'
    import UserService from '../../service/UserService'
    import PermissionService from '../../service/PermissionService'

    export default {
        name: 'PersonnelList',
        components: {PersonnelEditor},
        created () {
            this.getData()
            EventBus.$on('refresh-personnel-list', () => {
                this.getData()
            })
        },
        props: {
            projectId: '',
            myRole: ''
        },
        data () {
            return {
                map: RoleTypeNameMap,
                personnelList: [],
                dialogTitle: '',
                dialogVisible: false,
                dialogPersonnel: '',
                dialogNickname: '',
                userInfoList: []
            }
        },
        watch: {
            projectId () {
                this.getData()
            }
        },
        methods: {
            getPersonnelList () {
                PersonnelService.getPersonnelList(this.projectId, data => {
                    this.personnelList = data
                })
            },
            getUserInfoList (callback) {
                let self = this
                UserService.getUserInfoOfProject(this.projectId, data => {
                    self.userInfoList = data
                    callback()
                })
            },
            getData () {
                this.getUserInfoList(() => {
                    this.getPersonnelList()
                })
            },
            getUsername (userId) {
                for (let i = 0; i < this.userInfoList.length; i++) {
                    if (this.userInfoList[i].id === userId) {
                        return this.userInfoList[i].nickname
                    }
                }
                return null
            },
            getRoleTypeName (roleType) {
                return this.map.get(roleType)
            },
            edit (personnel) {
                this.dialogTitle = '编辑'
                this.dialogNickname = this.getUsername(personnel.userId)
                this.dialogPersonnel = personnel
                this.dialogVisible = true
            },
            remove (personnelId) {
                if (!confirm('是否删除？')) {
                    return
                }
                PersonnelService.removePersonnel(personnelId, () => {
                    this.dialogVisible = false
                    this.getData()
                })
            },
            onSavePersonnel (personnel) {
                PersonnelService.updatePersonnel(personnel, () => {
                    this.getData()
                    this.dialogVisible = false
                })
            },
            hasPermission (permission) {
                return PermissionService.hasPermission(this.myRole, 'PERSONNEL', permission)
            }
        }
    }
</script>

<style scoped>

</style>
