<template>
    <div>
        <div class="card">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">{{project.name}}</h3>
            </div>

            <el-dialog
                :visible.sync="dialogVisible"
                @close="dialogVisible = false"
                title="新增人员">
                <new-personnel
                    :project-id="newDialogProjectId"
                    v-if="dialogVisible">
                </new-personnel>
            </el-dialog>

            <div class="card-body">
                <div class="table-responsive">
                    <span class="h4">项目人员</span>
                    <button @click="addPersonnel" class="btn btn-primary btn-sm"
                    v-if="hasPermission('ADD')">+ 添加</button>
                    <br><br>
                    <personnel-list :my-role="myRole" :project-id="project.id"></personnel-list>
                </div>

            </div>
            <div class="card-body">
                <div class="h4">缺陷列表</div>
                <project-defect-list :my-role="myRole" :project-id="project.id"></project-defect-list>
            </div>
        </div>
    </div>
</template>

<script>

    import PersonnelList from './PersonnelList'
    import ProjectDefectList from '../defect/ProjectDefectList'
    import PersonnelEditor from './PersonnelEditor'
    import NewPersonnel from './NewPersonnel'
    import EventBus from '../../util/EventBus'
    import PersonnelService from '../../service/PersonnelService'
    import PermissionService from '../../service/PermissionService'

    export default {
        name: 'ProjectDetail',
        components: {NewPersonnel, PersonnelEditor, ProjectDefectList, PersonnelList},
        props: {
            project: ''
        },
        data () {
            return {
                dialogVisible: false,
                newDialogProjectId: '',
                myRole: ''
            }
        },
        created () {
            let self = this
            EventBus.$on('new-personnel-success', () => {
                self.dialogVisible = false
            })
            PersonnelService.getMyPersonnel(this.project.id, data => {
                self.myRole = data.roleType
            })
        },
        methods: {
            addPersonnel () {
                this.newDialogProjectId = this.project.id
                this.dialogVisible = true
            },
            hasPermission (permission) {
                return PermissionService.hasPermission(this.myRole, 'PERSONNEL', permission)
            }
        }
    }
</script>

<style scoped>

</style>
