<template>
    <!--<div class="col-lg-6">-->
    <!--<div class="card">-->
    <!--<div class="card-header d-flex align-items-center">-->
    <!--<h3 class="h4">已提交缺陷</h3>-->
    <!--</div>-->
    <!--<div class="card-body">-->
    <!--<div class="daily-feeds card">-->
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <!--<th>序号</th>-->
            <th>标题</th>
            <th width="100px">问题描述</th>
            <th>提交日期</th>
            <th>缺陷状态</th>
        </tr>
        </thead>
        <tbody>
        <!--<div>-->
        <!--<td scope="row">{{index}}</td>-->
        <defect-item :defect="defect" :my-role="myRole" :key="index" class="card-body no-padding"
                     v-for="(defect, index) in defectList"/>
        <!--</div>-->
        </tbody>
    </table>
    <!--</div>-->
    <!--</div>-->
    <!--</div>-->
</template>

<script>
    import DefectItem from './DefectItem'
    import DefectService from '../../service/DefectService'
    import EventBus from '../../util/EventBus'

    export default {
        name: 'ProjectDefectList',
        components: {DefectItem},
        props: {
            projectId: '',
            myRole: ''
        },
        created () {
            this.getDefectList()
            let self = this
            EventBus.$on('add-defect-modification-success', () => {
                self.getDefectList()
            })
        },
        data () {
            return {
                defectList: []
            }
        },
        watch: {
            projectId () {
                this.getDefectList()
            }
        },
        methods: {
            getDefectList () {
                let self = this
                DefectService.getProjectDefectList(this.projectId, data => {
                    self.defectList = data
                })
            }
        }
    }
</script>

<style scoped>

</style>
