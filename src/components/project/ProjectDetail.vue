<template>
    <div>
        <personnel-list :project-id="projectId"></personnel-list>
    </div>
</template>

<script>

    import PersonnelList from './PersonnelList'
    export default {
        name: 'ProjectDetail',
        components: {PersonnelList},
        props: {
            projectId: ''
        },
        created () {
        }
    }
</script>

<style scoped>

</style>
