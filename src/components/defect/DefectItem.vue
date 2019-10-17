<template>
    <div class="item">
        <div class="feed d-flex justify-content-between">
            <div class="feed-body d-flex justify-content-between">
                <div class="content">
                    <div>id：{{defect.id}}</div>
                    <div>标题：{{defect.title}}</div>
                    <div class="full-date">
                        问题描述：{{defect.description}}
                    </div>
                    <div>提交日期：{{defect.submitTime}}</div>
                    <div>缺陷状态：{{defectStateName}}</div>
                    <button class="btn btn-primary" @click="toDefectModificationList">操作记录</button>
                    <el-dialog
                        :visible="dialogVisible"
                        @close="dialogVisible = false"
                        title="操作记录">
                        <defect-modification-list :defect-id="defect.id"/>
                    </el-dialog>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import DefectStateMap from '../../entity/DefectStateMap'
    import DefectModificationList from './modification/DefectModificationList'

    export default {
        name: 'DefectItem',
        components: {DefectModificationList},
        props: {
            defect: null
        },
        data () {
            return {
                dialogVisible: false
            }
        },
        computed: {
            defectStateName () {
                return DefectStateMap.get(this.defect.defectState)
            }
        },
        methods: {
            toDefectModificationList () {
                this.dialogVisible = true
            }
        }
    }
</script>

<style scoped>

</style>
