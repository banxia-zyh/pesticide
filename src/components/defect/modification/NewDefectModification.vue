<template>
    <!--<div>-->
    <!--<input v-model="defectModification.modifyDescription"/>-->
    <!--<select class="form-control" v-model="defectModification.resultState">-->
    <!--<option disabled value="">请选择</option>-->
    <!--<option :key="index" :value="value" v-for="(value, index) in defectStateMap.keys()" v-if="index !== 0">-->
    <!--{{defectStateMap.get(value)}}-->
    <!--</option>-->
    <!--</select>-->
    <!--<button @click="addModification" class="btn btn-primary">提交</button>-->
    <!--</div>-->
    <form class="form-horizontal" style="text-align: center">
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">修改描述</label>
            <div class="col-sm-9">
                <textarea class="form-control form-control-success" type="text"
                          v-model="defectModification.modifyDescription">
                </textarea>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-3 form-control-label" style="margin: auto">结果状态</label>
            <div class="col-sm-9">
                <select class="form-control" v-model="defectModification.resultState">
                    <option disabled value="">请选择</option>
                    <option :key="index" :value="value" v-for="(value, index) in defectStateMap.keys()"
                            v-if="index !== 0">
                        {{defectStateMap.get(value)}}
                    </option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <button @click="addModification" class="btn btn-primary" style="width: 30%">提交</button>
            </div>
        </div>
    </form>
</template>

<script>
    import DefectModificationService from '../../../service/DefectModificationService'
    import DefectStateMap from '../../../entity/DefectStateMap'
    import EventBus from '../../../util/EventBus'

    export default {
        name: 'NewDefectModification',
        props: {
            defectId: ''
        },
        data () {
            return {
                defectModification: {
                    modifyDescription: '',
                    resultState: ''
                },
                defectStateMap: DefectStateMap
            }
        },
        methods: {
            addModification () {
                if (this.defectModification.modifyDescription.trim() === '') {
                    alert('请输入描述')
                    return
                }
                if (this.defectModification.resultState.trim() === '') {
                    alert('请选择结果状态')
                    return
                }
                this.defectModification.defectId = this.defectId
                DefectModificationService.addModification(this.defectModification, () => {
                    EventBus.$emit('add-defect-modification-success')
                })
            }
        }
    }
</script>

<style scoped>

</style>
