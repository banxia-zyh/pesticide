<template>
    <div @click="toUserInfo" class="sidebar-header d-flex align-items-center">
        <div class="avatar">
            <img alt="..." class="img-fluid rounded-circle" src="../../../static/template/img/avatar-1.jpg">
        </div>
        <div class="title">
            <h1 class="h4">Mark Stephen</h1>
            <p>Web Designer</p>
        </div>
    </div>
</template>

<script>
    import EventBus from '../../util/EventBus'

    export default {
        name: 'Profile',
        methods: {
            toUserInfo () {
                EventBus.$emit('change-content', 'UserInfo')
            }
        }
    }
</script>

<style scoped>

</style>
