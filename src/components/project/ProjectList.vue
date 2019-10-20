<template>
    <div>
        <!-- Item-->
        <div :key="index" class="item" v-for="(project, index) in projectList">
            <div @click="select(project)" class="feed-body d-flex justify-content-between">
                <div class="content">
                    <h3>{{project.name}}</h3>
                    <span>简介：{{project.intro}}</span>
                    <div class="full-date">
                        <small>创建时间：{{project.createTime}}</small>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import ProjectItem from './ProjectItem'
    import ProjectService from '../../service/ProjectService'

    export default {
        name: 'ProjectList',
        components: {ProjectItem},
        created () {
            this.getProjectList()
        },
        data () {
            return {
                projectList: ''
            }
        },
        methods: {
            getProjectList () {
                let self = this
                ProjectService.getMyProjectList(data => {
                    self.projectList = data
                })
            },
            select (project) {
                this.$emit('select-project', project)
            }
        }
    }
</script>

<style scoped>

</style>
