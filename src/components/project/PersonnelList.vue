<template>
    <div>
        <div class="card">
            <div class="card-close">
                <div class="dropdown">
                    <button aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            id="closeCard3" type="button"><i class="fa fa-ellipsis-v"></i></button>
                    <div aria-labelledby="closeCard3" class="dropdown-menu dropdown-menu-right has-shadow"><a
                        class="dropdown-item remove"
                        href="#">
                        <i class="fa fa-times"></i>Close</a><a class="dropdown-item edit" href="#"> <i
                        class="fa fa-gear"></i>Edit</a></div>
                </div>
            </div>
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">项目人员</h3>
                <button @click="addPersonnel">添加</button>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>职位</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr :key="index" v-for="(personnel,index) in personnelList">
                            <th scope="row">{{index + 1}}</th>
                            <td>{{personnel.userId}}</td>
                            <td>{{getRoleTypeName(personnel.roleType)}}</td>
                            <button @click="edit(personnel)">编辑</button>
                            <button @click="remove(personnel.id)">删除</button>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <el-dialog
            :title="dialogTitle"
            :visible.sync="dialogVisible"
            @close="dialogVisible = false">
            <personnel-editor
                :personnel="dialogPersonnel"
                @save-personnel="onSavePersonnel">
            </personnel-editor>
        </el-dialog>
    </div>
</template>

<script>
    import PersonnelService from '../../service/PersonnelService'
    import RoleTypeNameMap from '../../entity/RoleTypeNameMap'
    import PersonnelEditor from './PersonnelEditor'

    export default {
        name: 'PersonnelList',
        components: {PersonnelEditor},
        created () {
            this.getPersonnelList()
        },
        props: {
            projectId: ''
        },
        data () {
            return {
                map: RoleTypeNameMap,
                personnelList: [],
                dialogTitle: '',
                dialogVisible: false,
                dialogPersonnel: ''
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
            getPersonnelList () {
                if (this.projectId === null || this.projectId === '') {
                    return
                }
                PersonnelService.getPersonnelList(this.projectId, data => {
                    this.personnelList = data
                })
            },
            getRoleTypeName (roleType) {
                return this.map.get(roleType)
            },
            addPersonnel () {
                this.dialogTitle = '新增'
                this.dialogPersonnel = {
                    projectId: this.projectId
                }
                this.dialogVisible = true
            },
            edit (personnel) {
                this.dialogTitle = '编辑'
                this.dialogPersonnel = personnel
                this.dialogVisible = true
            },
            onSavePersonnel (personnel) {
                if (this.dialogTitle === '新增') {
                    PersonnelService.addPersonnel(personnel, () => {
                        this.dialogVisible = false
                    })
                } else if (this.dialogTitle === '编辑') {
                    PersonnelService.updatePersonnel(personnel, () => {
                        this.dialogVisible = false
                    })
                }
            },
            remove (personnelId) {
                PersonnelService.removePersonnel(personnelId, () => {
                    this.dialogVisible = false
                    this.getPersonnelList()
                })
            }
        }
    }
</script>

<style scoped>

</style>
