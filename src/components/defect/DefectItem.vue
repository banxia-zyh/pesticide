<template>
    <!--<div class="item">-->
    <!--<div class="feed d-flex justify-content-between">-->
    <!--<div class="feed-body d-flex justify-content-between">-->
    <tr>
        <td>{{defect.title}}</td>
        <td :title="defect.description" class="full-date" style="max-width: 200px">
            {{defect.description}}
        </td>
        <td>{{defect.submitTime}}</td>
        <td :style="{color: stateColor}">{{defectStateName}}</td>
        <td>
            <button
                @click="newModificationDialogVisible = true"
                class="btn btn-primary btn-sm"
                v-if="hasPermission('EDIT_STATE')">修改状态
            </button>
            <button
                @click="modificationListDialogVisible = true"
                class="btn btn-primary btn-sm">操作记录
            </button>
        </td>
        <el-dialog
            :visible="newModificationDialogVisible"
            @close="newModificationDialogVisible = false"
            title="修改状态">
            <new-defect-modification
                :defect-id="defect.id"
                v-if="newModificationDialogVisible"/>
        </el-dialog>
        <el-dialog
            :destroy-on-close="true"
            :visible="modificationListDialogVisible"
            @close="modificationListDialogVisible = false"
            title="操作记录">
            <defect-modification-list :defect-id="defect.id" v-if="modificationListDialogVisible"/>
        </el-dialog>
    </tr>
    <!--</div>-->
    <!--</div>-->
    <!--</div>-->
</template>

<script>
    import DefectStateMap from '../../entity/DefectStateMap'
    import DefectModificationList from './modification/DefectModificationList'
    import NewDefectModification from './modification/NewDefectModification'
    import EventBus from '../../util/EventBus'
    import StateColorMap from '../../entity/StateColorMap'
    import PermissionService from '../../service/PermissionService'

    export default {
        name: 'DefectItem',
        components: {NewDefectModification, DefectModificationList},
        props: {
            defect: null,
            myRole: ''
        },
        created () {
            let self = this
            EventBus.$on('add-defect-modification-success', () => {
                self.newModificationDialogVisible = false
            })
        },
        data () {
            return {
                newModificationDialogVisible: false,
                modificationListDialogVisible: false
            }
        },
        computed: {
            defectStateName () {
                return DefectStateMap.get(this.defect.defectState)
            },
            stateColor () {
                return StateColorMap.get(this.defect.defectState)
            }
        },
        methods: {
            hasPermission (permission) {
                return PermissionService.hasPermission(this.myRole, 'DEFECT', permission)
            }
        }
    }
</script>

<style scoped>

</style>
