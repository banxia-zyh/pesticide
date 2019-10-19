<template>
    <div class="row" style="margin: auto">
        <!-- Daily Feeds -->
        <div class="col-lg-5" id="myProjectListRoot">
            <div class="daily-feeds card">
                <div class="card-header">
                    <h3 class="h4">我的项目</h3>
                </div>
                <div class="card-body no-padding">
                    <!-- Item-->
                    <div :key="index" class="item" v-for="(project, index) in projectList">
                        <project-item
                            :project="project"
                            @delete="getData"
                            @to-project-detail="detailProject = project">
                        </project-item>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-7">
            <project-detail :project="detailProject" v-if="detailProject !== ''"></project-detail>
        </div>
    </div>
</template>

<script>
    import NewProject from './NewProject'
    import EditProject from './EditProject'
    import ProjectService from '../../service/ProjectService'
    import EventBus from '../../util/EventBus'
    import ProjectDetail from './ProjectDetail'
    import ProjectItem from './ProjectItem'

    export default {
        name: 'MyProjectList',
        components: {ProjectItem, ProjectDetail, EditProject, NewProject},
        created () {
            this.getData()
            EventBus.$emit('update-load', true)
            let self = this
            EventBus.$on('refresh-project-list', () => {
                self.getData()
            })
        },
        data () {
            return {
                projectList: [],
                personnelNum: 34,
                detailProject: ''
            }
        },
        methods: {
            getData () {
                ProjectService.getMyProjectList(projectList => {
                    this.projectList = projectList
                    EventBus.$emit('update-load', false)
                })
            }
        }
    }
</script>

<style scoped>

</style>
