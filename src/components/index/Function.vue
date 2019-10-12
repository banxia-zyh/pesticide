<template>
    <div>
        <!-- Sidebar Navidation Menus-->
        <span class="heading">功能</span>
        <ul class="list-unstyled">
            <li class="active"><a href="index.html"> <i class="icon-home"></i>Home </a></li>
            <li><a href="tables.html"> <i class="icon-grid"></i>Tables </a></li>
            <li><a href="charts.html"> <i class="fa fa-bar-chart"></i>Charts </a></li>
            <li><a href="forms.html"> <i class="icon-padnote"></i>Forms </a></li>
            <li><a aria-expanded="false" data-toggle="collapse" href="#exampledropdownDropdown"> <i
                class="icon-interface-windows"></i>Example dropdown </a>
                <ul class="collapse list-unstyled " id="exampledropdownDropdown">
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                </ul>
            </li>
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
    export default {
        name: 'Function'
    }
</script>

<style scoped>

</style>
