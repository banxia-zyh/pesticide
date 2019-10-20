<template>
    <div class="page">
        <Header></Header>
        <div class="page-content d-flex align-items-stretch">
            <Navigation></Navigation>
            <Content></Content>
        </div>
    </div>
</template>

<script>
    import Header from './Header'
    import Navigation from './Navigation'
    import Content from './Content'

    export default {
        name: 'Index',
        components: {Content, Navigation, Header},
        created () {
            let userId = localStorage.getItem('userId')
            if (userId === undefined || userId === null || userId === '') {
                this.$router.replace({path: '/auth/login'})
            }
        }
    }
</script>

<style scoped>

</style>
