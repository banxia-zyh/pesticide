<template>
    <div>
        <!-- Sidebar Navidation Menus-->
        <span class="heading">功能</span>
        <ul class="list-unstyled">
            <li><a aria-expanded="false" data-toggle="collapse" href="#exampledropdownDropdown"> <i
                class="icon-grid"></i>项目管理 </a>
                <ul class="collapse list-unstyled " id="exampledropdownDropdown">
                    <li><a @click.prevent="toNewProject" href="#">新建项目</a></li>
                    <li><a @click.prevent="toMyProjectList" href="#">我的项目</a></li>
                </ul>
            </li>
            <li><a href="index.html"> <i class="icon-home"></i>Home </a></li>
            <li><a href="charts.html"> <i class="fa fa-bar-chart"></i>Charts </a></li>
            <li><a href="forms.html"> <i class="icon-padnote"></i>Forms </a></li>
            <li><a href="login.html"> <i class="icon-interface-windows"></i>Login page </a></li>
            <span class="heading">Extras</span>
            <ul class="list-unstyled">
                <li><a href="#"> <i class="icon-flask"></i>Demo </a></li>
                <li><a href="#"> <i class="icon-screen"></i>Demo </a></li>
                <li><a href="#"> <i class="icon-mail"></i>Demo </a></li>
                <li><a href="#"> <i class="icon-picture"></i>Demo </a></li>
            </ul>
        </ul>
    </div>
</template>

<script>
    import EventBus from '../../util/EventBus'

    export default {
        name: 'Function',
        methods: {
            toNewProject () {
                EventBus.$emit('change-content', 'NewProject')
            },
            toMyProjectList () {
                EventBus.$emit('change-content', 'ProjectList')
            }
        }
    }
</script>

<style scoped>

</style>
