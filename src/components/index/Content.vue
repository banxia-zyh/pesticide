<template>
    <div class="content-inner">
        <component :is="componentName"></component>
    </div>
</template>

<script>
    import UserInfo from '../user/UserInfo'
    import EventBus from '../../util/EventBus'
    import NewProject from '../project/NewProject'
    import ProjectList from '../project/ProjectList'

    export default {
        name: 'Content',
        components: {UserInfo, NewProject, ProjectList},
        data () {
            return {
                componentName: ''
            }
        },
        mounted () {
            EventBus.$on('change-content', newComponentName => {
                this.componentName = newComponentName
            })
        }
    }
</script>

<style scoped>

</style>
