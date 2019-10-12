<template>
    <!-- Side Navbar -->
    <nav class="side-navbar">
        <Profile></Profile>
        <Function></Function>
    </nav>
</template>

<script>
    import Function from './Function'
    import Profile from './Profile'
    export default {
        name: 'Navigation',
        components: {Profile, Function}
    }
</script>

<style scoped>

</style>
