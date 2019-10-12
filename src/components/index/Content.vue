<template>
    <div class="content-inner">
        <component :is="componentName"></component>
    </div>
</template>

<script>
    import UserInfo from '../user/UserInfo'
    import EventBus from '../../util/EventBus'

    export default {
        name: 'Content',
        components: {UserInfo},
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
