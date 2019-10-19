<template>
    <form class="form-horizontal" style="text-align: center">
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">用户名</label>
            <div class="col-sm-9">
                <input @click="selectUser" class="form-control form-control-success" type="text"
                       v-model="newNickname">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">职位</label>
            <div class="col-sm-9">
                <select class="form-control" v-model="personnel.roleType">
                    <option disabled value="">请选择</option>
                    <option :key="value" :value="value" v-for="(value) in roleTypeNameMap.keys()">
                        {{roleTypeNameMap.get(value)}}
                    </option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button @click="$emit('save-personnel', personnel)" class="btn btn-primary"
                        style="width: 30%">保存
                </button>
            </div>
        </div>
        <el-dialog
            :visible.sync="dialogVisible"
            @close="dialogVisible = false"
            append-to-body
            title="选择用户">
            <user-list
                @select="onSelectUser">
            </user-list>
        </el-dialog>
    </form>
</template>

<script>

    import RoleTypeNameMap from '../../entity/RoleTypeNameMap'
    import UserList from '../user/UserList'

    export default {
        name: 'PersonnelEditor',
        components: {UserList},
        props: {
            personnel: {
                userId: '',
                projectId: '',
                roleType: ''
            },
            nickname: ''
        },
        mounted () {
            this.newNickname = this.nickname
        },
        data () {
            return {
                roleTypeNameMap: RoleTypeNameMap,
                dialogVisible: false,
                newNickname: null
            }
        },
        watch: {
            nickname () {
                this.newNickname = this.nickname
            }
        },
        methods: {
            selectUser () {
                this.dialogVisible = true
            },
            onSelectUser (user) {
                this.dialogVisible = false
                this.newNickname = user.nickname
                this.personnel.userId = user.id
            }
        }
    }
</script>

<style scoped>

</style>
