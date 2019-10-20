<template>
    <!-- Inline Form-->
    <div class="col-lg-10">
        <div class="card">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">选择项目</h3>
            </div>
            <div class="card-body">
                <form class="form-inline">
                    <div class="form-group">
                        <!--<label class="sr-only" for="inlineFormInput">选择项目</label>-->
                        <input @click="projectDialogVisible = true"
                               class="mr-3 form-control"
                               placeholder="选择项目" type="text" v-model="project.name">
                    </div>
                    <div class="form-group">
                        <button @click="statistics" class="btn btn-primary" type="submit">统计</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="card" v-if="defectList !== null">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">概况</h3>
            </div>
            <div class="card-body" style="padding: 10px;">
                <defect-overview :defect-list="defectList"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="card" v-if="defectList !== null">
                    <div class="card-header d-flex align-items-center">
                        <h3 class="h4">每日趋势统计</h3>
                    </div>
                    <div class="card-body" style="padding: 5px;">
                        <defect-daily-trend-chart :defect-list="defectList"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card" v-if="defectList !== null">
                    <div class="card-header d-flex align-items-center">
                        <h3 class="h4">人员缺陷统计</h3>
                    </div>
                    <div class="card-body" style="padding: 5px;">
                        <personnel-defect-bar-chart :defect-list="defectList" :project-user-list="projectUserList"/>
                    </div>
                </div>
            </div>
        </div>
        <el-dialog
            :visible.sync="projectDialogVisible"
            @close="projectDialogVisible = false"
            title="选择项目">
            <project-list @select-project="onSelectProject"></project-list>
        </el-dialog>
    </div>
</template>

<script>
    import DefectOverview from './DefectOverview'
    import ProjectList from '../project/ProjectList'
    import DefectService from '../../service/DefectService'
    import DefectDailyTrendChart from './DefectDailyTrendChart'
    import PersonnelDefectBarChart from './PersonnelDefectBarChart'
    import UserService from '../../service/UserService'
    import EventBus from '../../util/EventBus'

    export default {
        name: 'ProjectDefectStatistics',
        components: {PersonnelDefectBarChart, DefectDailyTrendChart, ProjectList, DefectOverview},
        data () {
            return {
                projectDialogVisible: false,
                defectList: null,
                project: '',
                projectUserList: ''
            }
        },
        methods: {
            onSelectProject (project) {
                this.projectDialogVisible = false
                this.project = project
                this.getProjectUserList()
            },
            statistics () {
                let self = this
                self.defectList = null
                EventBus.$emit('update-load', true)
                DefectService.getProjectDefectList(this.project.id, data => {
                    self.defectList = data
                    EventBus.$emit('update-load', false)
                })
            },
            getProjectUserList () {
                let self = this
                UserService.getUserInfoOfProject(this.project.id, data => {
                    self.projectUserList = data
                })
            }
        }
    }
</script>

<style scoped>

</style>
