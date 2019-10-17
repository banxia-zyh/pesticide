<template>
    <div class="row">
        <div class="col-lg-4">
            <div class="daily-feeds card">
                <div class="card-body no-padding">
                    <defect-item :defect="defect" :key="index" v-for="(defect, index) in defectList"/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import DefectItem from './DefectItem'
    import DefectService from '../../service/DefectService'
    import EventBus from '../../util/EventBus'

    export default {
        name: 'ReceivedDefectList',
        components: {DefectItem},
        created () {
            EventBus.$emit('update-load', true)
            this.getDefectList()
        },
        data () {
            return {
                defectList: []
            }
        },
        methods: {
            getDefectList () {
                DefectService.getReceiveDefectList(data => {
                    this.defectList = data
                    EventBus.$emit('update-load', false)
                })
            }
        }
    }
</script>

<style scoped>

</style>
