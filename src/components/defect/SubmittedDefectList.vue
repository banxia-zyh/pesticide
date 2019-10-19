<template>
    <div class="col-lg-10">
        <div class="card">
            <div class="card-header d-flex align-items-center">
                <h3 class="h4">已提交缺陷</h3>
            </div>
            <div class="card-body">
                <!--<div class="daily-feeds card">-->
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <!--<th>序号</th>-->
                        <th>标题</th>
                        <th>问题描述</th>
                        <th>提交日期</th>
                        <th>缺陷状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--<div>-->
                    <!--<td scope="row">{{index}}</td>-->
                    <defect-item :defect="defect" :key="index" class="card-body no-padding" my-role="ADMINISTRATOR"
                                 v-for="(defect, index) in defectList"/>
                    <!--</div>-->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    import DefectItem from './DefectItem'
    import DefectService from '../../service/DefectService'
    import EventBus from '../../util/EventBus'

    export default {
        name: 'SubmittedDefectList',
        components: {DefectItem},
        created () {
            EventBus.$emit('update-load', true)
            this.getDefectList()
            let self = this
            EventBus.$on('add-defect-modification-success', () => {
                self.getDefectList()
            })
        },
        data () {
            return {
                defectList: [],
                myRole: ''
            }
        },
        methods: {
            getDefectList () {
                DefectService.getMyDefectList(data => {
                    this.defectList = data
                    EventBus.$emit('update-load', false)
                })
            }
        }
    }
</script>

<style scoped>

</style>
