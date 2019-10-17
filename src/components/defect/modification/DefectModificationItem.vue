<template>
    <div class="item">
        <div>{{defectModification.id}}</div>
        <div>{{defectModification.defectId}}</div>
        <div>{{defectModification.modifyUserId}}</div>
        <div>{{defectModification.modifyDescription}}</div>
        <div>{{defectModificationStateName}}</div>
    </div>
</template>

<script>
    import DefectStateMap from '../../../entity/DefectStateMap'

    export default {
        name: 'DefectModificationItem',
        props: {
            defectModification: null
        },
        computed: {
            defectModificationStateName () {
                return DefectStateMap.get(this.defectModification.resultState)
            }
        }
    }
</script>

<style scoped>

</style>
