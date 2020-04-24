<template>
    <!--<div class="col-lg-10">-->
        <!--<div class="card">-->
            <!--<div class="card-header d-flex align-items-center">-->
                <!--<h3 class="h4">修改记录</h3>-->
            <!--</div>-->
            <!--<div class="card-body">-->
                <!--<div class="daily-feeds card">-->
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <!--<th>序号</th>-->
                        <th>修改人</th>
                        <th>修改描述</th>
                        <th>结果状态</th>
                        <th>提交日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <defect-modification-item
                        :defect-modification="modification" :key="index"
                        v-for="(modification,index) in modificationList"/>
                    </tbody>
                </table>
            <!--</div>-->
        <!--</div>-->
    <!--</div>-->
</template>

<script>
    import DefectModificationService from '../../../service/DefectModificationService'
    import DefectModificationItem from './DefectModificationItem'

    export default {
        name: 'DefectModificationList',
        components: {DefectModificationItem},
        props: {
            defectId: null
        },
        data () {
            return {
                modificationList: []
            }
        },
        mounted () {
            console.log('mounted')
            this.getModificationList()
        },
        methods: {
            getModificationList () {
                DefectModificationService.getDefectModificationList(this.defectId, data => {
                    this.modificationList = data
                })
            }
        }
    }
</script>

<style scoped>

</style>
