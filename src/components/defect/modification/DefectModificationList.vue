<template>
    <div>
        <defect-modification-item
            :defect-modification="modification" :key="index"
            v-for="(modification,index) in modificationList"/>
    </div>
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
