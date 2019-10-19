<template>
    <div class="col-lg-8">
        <div class="card">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">提交缺陷</h3>
            </div>
            <div class="card-body">
                <form class="form-horizontal" style="text-align: center">
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">缺陷标题</label>
                        <div class="col-sm-9">
                            <input class="form-control" type="text" v-model="defect.title">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">缺陷描述</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="4" type="text"
                                      v-model="defect.description"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">所属项目</label>
                        <div class="col-sm-9">
                            <input @click="selectProject" class="form-control" type="text" v-model="projectName">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label" style="margin: auto">处理人</label>
                        <div class="col-sm-9">
                            <input @click="selectResolveUser" class="form-control" type="text"
                                   v-model="resolveUserNickname">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button @click="addDefect" class="btn btn-primary" style="width: 30%">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <el-dialog
            :visible.sync="projectDialogVisible"
            @close="projectDialogVisible = false"
            title="选择项目">
            <project-list @select-project="onSelectProject"></project-list>
        </el-dialog>
        <el-dialog
            :visible.sync="userDialogVisible"
            @close="userDialogVisible = false"
            title="选择用户">
            <user-list @select="onSelectUser" :project-id="defect.projectId"></user-list>
        </el-dialog>
    </div>
</template>

<script>

    import DefectService from '../../service/DefectService'
    import MyProjectList from '../project/MyProjectList'
    import ProjectList from '../project/ProjectList'
    import UserList from '../user/UserList'

    export default {
        name: 'NewDefect',
        components: {UserList, ProjectList, MyProjectList},
        data () {
            return {
                defect: {
                    title: '',
                    description: '',
                    projectId: '',
                    resolveUserId: ''
                },
                projectName: '',
                resolveUserNickname: '',
                projectDialogVisible: false,
                userDialogVisible: false
            }
        },
        methods: {
            validate () {
                let defect = this.defect
                if (defect.title.trim() === '') {
                    alert('请填写标题')
                    return false
                }
                if (defect.description.trim() === '') {
                    alert('请填写缺陷描述')
                    return false
                }
                if (defect.projectId === '') {
                    alert('请选择所属项目')
                    return false
                }
                if (defect.resolveUserId === '') {
                    alert('请选择处理人')
                    return false
                }
                return true
            },
            addDefect () {
                if (this.validate() !== true) {
                    return
                }
                DefectService.addDefect(this.defect, () => {
                    alert('提交成功！')
                    this.defect = {}
                    this.projectName = ''
                    this.resolveUserNickname = ''
                }, (code, message) => {
                    alert('提交失败！' + message)
                })
            },
            selectProject () {
                this.projectDialogVisible = true
            },
            selectResolveUser () {
                if (this.defect.projectId === '') {
                    alert('请先选择项目')
                    return
                }
                this.userDialogVisible = true
            },
            onSelectProject (project) {
                this.projectDialogVisible = false
                this.defect.projectId = project.id
                this.projectName = project.name
            },
            onSelectUser (user) {
                this.userDialogVisible = false
                this.defect.resolveUserId = user.id
                this.resolveUserNickname = user.nickname
            }
        }
    }
</script>

<style scoped>

</style>
