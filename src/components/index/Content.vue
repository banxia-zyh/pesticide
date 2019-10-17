<template>
    <div class="content-inner" style="margin: 20px 0px">
        <component :is="componentName" v-loading="loading"></component>
    </div>
</template>

<script>
    import UserInfo from '../user/UserInfo'
    import EventBus from '../../util/EventBus'
    import NewProject from '../project/NewProject'
    import MyProjectList from '../project/MyProjectList'

    export default {
        name: 'Content',
        components: {UserInfo, NewProject, MyProjectList},
        data () {
            return {
                componentName: '',
                loading: false
            }
        },
        mounted () {
            EventBus.$on('change-content', newComponentName => {
                if (newComponentName !== this.componentName) {
                    this.componentName = newComponentName
                }
            })
            EventBus.$on('update-load', state => {
                this.loading = state
            })
        }
    }
</script>

<style scoped>

</style>
