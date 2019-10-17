<template>
    <form class="form-horizontal" style="text-align: center">
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">项目名称</label>
            <div class="col-sm-9">
                <input class="form-control form-control-success" type="text" v-model="project.name">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">项目简介</label>
            <div class="col-sm-9">
                            <textarea class="form-control form-control-success" rows="4" type="text"
                                      v-model="project.intro"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">创建时间</label>
            <div class="col-sm-9">
                <input class="form-control form-control-warning" type="date" v-model="project.createTime">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button @click="addProject" class="btn btn-primary" style="width: 30%">保存</button>
            </div>
        </div>
    </form>
</template>

<script>
    import ProjectService from '../../service/ProjectService'

    export default {
        name: 'EditProject',
        props: {
            project: ''
        },
        methods: {
            addProject () {
                let self = this
                ProjectService.updateProject(this.project, () => {
                    self.$emit('update-project-success')
                    self.$message('保存成功')
                }, (code, message) => {
                    alert('保存失败！' + message)
                })
            }
        }
    }
</script>

<style scoped>

</style>
