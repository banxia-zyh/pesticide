<template>
    <tr>
        <td>{{defectModification.modifyUsername}}</td>
        <td>{{defectModification.modifyDescription}}</td>
        <td :style="{color: stateColor}">{{defectModificationStateName}}</td>
        <td>{{defectModification.modifyTime}}</td>
    </tr>
</template>

<script>
    import DefectStateMap from '../../../entity/DefectStateMap'
    import StateColorMap from '../../../entity/StateColorMap'

    export default {
        name: 'DefectModificationItem',
        props: {
            defectModification: ''
        },
        computed: {
            defectModificationStateName () {
                return DefectStateMap.get(this.defectModification.resultState)
            },
            stateColor () {
                return StateColorMap.get(this.defectModification.resultState)
            }
        }
    }
</script>

<style scoped>

</style>
