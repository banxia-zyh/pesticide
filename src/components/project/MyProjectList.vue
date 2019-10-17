<template>
    <div class="row" style="margin: auto">
        <!-- Daily Feeds -->
        <div class="col-lg-4" id="myProjectListRoot">
            <div class="daily-feeds card">
                <div class="card-header">
                    <h3 class="h4">我的项目</h3>
                </div>
                <div class="card-body no-padding">
                    <!-- Item-->
                    <div :key="index" class="item" v-for="(project, index) in projectList">
                        <div class="feed d-flex justify-content-between">
                            <div class="feed-body d-flex justify-content-between">
                                <div class="content">
                                    <h3>{{project.name}}</h3><span>简介：{{project.intro}}</span>
                                    <div class="full-date">
                                        <small>创建时间：{{project.createTime}}</small>
                                    </div>
                                    <div class="full-date">
                                        <small>人数：{{personnelNum}}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button @click="toDetail(project.id)">详情</button>
                        <button @click="edit(project)">编辑</button>
                        <button @click="remove(project.id)">删除</button>
                    </div>
                </div>
            </div>
            <el-dialog
                :visible="dialogVisible"
                @close="dialogVisible = false"
                title="编辑">
                <edit-project
                    :project="dialogProject"
                    @update-project-success="dialogVisible = false">
                </edit-project>
            </el-dialog>
        </div>
        <ProjectDetail :project-id="projectDetailId"
                       :style="{marginLeft : '-15px', visibility: detailVisible}"
                       class="col-lg-7"/>
    </div>
</template>

<script>
    import NewProject from './NewProject'
    import EditProject from './EditProject'
    import ProjectService from '../../service/ProjectService'
    import EventBus from '../../util/EventBus'
    import ProjectDetail from './ProjectDetail'

    export default {
        name: 'MyProjectList',
        components: {ProjectDetail, EditProject, NewProject},
        created () {
            EventBus.$emit('update-load', true)
            this.getData()
        },
        data () {
            return {
                projectList: [],
                personnelNum: 34,
                dialogVisible: false,
                dialogProject: '',
                projectDetailId: null
            }
        },
        computed: {
            detailVisible () {
                return this.projectDetailId === null ? 'hidden' : 'visible'
            }
        },
        methods: {
            toDetail (id) {
                this.projectDetailId = id
            },
            getData () {
                ProjectService.getMyProjectList(projectList => {
                    this.projectList = projectList
                    EventBus.$emit('update-load', false)
                })
            },
            edit (project) {
                this.dialogProject = project
                this.dialogVisible = true
            },
            remove (id) {
                ProjectService.removeProject(id, () => {
                    alert('删除成功')
                    this.getData()
                })
            }
        }
    }
</script>

<style scoped>

</style>
