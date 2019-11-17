<template>
    <div>
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
                    <br>
                </div>
            </div>
        </div>
        <button @click="toDetail" class="btn btn-primary btn-sm">详情</button>
        <button @click="edit" class="btn btn-primary btn-sm" v-if="hasPermission('EDIT')">编辑</button>
        <button @click="remove" class="btn btn-primary btn-sm" v-if="hasPermission('DELETE')">删除</button>

        <el-dialog
            :visible="dialogVisible"
            @close="dialogVisible = false"
            title="编辑">
            <edit-project
                :project="project"
                @update-project-success="dialogVisible = false">
            </edit-project>
        </el-dialog>

        <!--<project-detail-->
        <!--:project="project"-->
        <!--:style="{marginLeft : '-15px', visibility: detailVisible}"-->
        <!--class="col-lg-7"/>-->
    </div>
</template>

<script>
    import ProjectService from '../../service/ProjectService'
    import ProjectDetail from './ProjectDetail'
    import EditProject from './EditProject'
    import PersonnelService from '../../service/PersonnelService'
    import PermissionService from '../../service/PermissionService'

    export default {
        name: 'ProjectItem',
        components: {EditProject, ProjectDetail},
        created () {
            this.getPersonnelCount()
            let self = this
            PersonnelService.getMyPersonnel(this.project.id, data => {
                self.myRole = data.roleType
            })
        },
        props: {
            project: null
        },
        data () {
            return {
                personnelNum: '',
                dialogVisible: false,
                detailVisible: false,
                myRole: ''
            }
        },
        methods: {
            getPersonnelCount () {
                PersonnelService.getPersonnelList(this.project.id, personnelList => {
                    this.personnelNum = personnelList.length
                })
            },
            toDetail () {
                this.$emit('to-project-detail', this.project)
            },
            edit () {
                this.dialogVisible = true
            },
            remove () {
                if (!confirm('是否删除？')) {
                    return
                }
                let self = this
                ProjectService.removeProject(this.project.id, () => {
                    alert('删除成功')
                    self.$emit('delete')
                })
            },
            hasPermission (permission) {
                return PermissionService.hasPermission(this.myRole, 'PROJECT', permission)
            }
        }
    }
</script>

<style scoped>

</style>
