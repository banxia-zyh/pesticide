<template>
    <div>
        <!-- Sidebar Navidation Menus-->
        <ul class="list-unstyled">
            <!--<li><a aria-expanded="false" data-toggle="collapse" href="#exampledropdownDropdown"> <i-->
            <!--class="icon-grid"></i>项目管理 </a>-->
            <!--<ul class="collapse list-unstyled " id="exampledropdownDropdown">-->
            <!--</ul>-->
            <!--</li>-->

            <span class="heading">项目管理</span>
            <li><a @click.prevent="toNewProject" href="#"> <i class="icon-padnote"></i>新建项目</a></li>
            <li><a @click.prevent="toMyProjectList" href="#"> <i class="icon-grid"></i>我的项目</a></li>
            <span class="heading">缺陷管理</span>
            <li><a @click.prevent="toNewDefect" href="#"> <i class="icon-padnote"></i>提交缺陷</a></li>
            <li><a @click.prevent="toMyDefectList" href="#"> <i class="icon-interface-windows"></i>已提交缺陷</a></li>
            <li><a @click.prevent="toReceivedDefectList" href="#"> <i class="icon-interface-windows"></i>收到的缺陷</a></li>
            <span class="heading">缺陷统计</span>
            <li><a @click.prevent="toProjectDefectStatistics" href="#"> <i class="icon-padnote"></i>项目缺陷统计</a></li>
            <!--<li><a href="index.html"> <i class="icon-home"></i>Home </a></li>-->
            <!--<li><a href="charts.html"> <i class="fa fa-bar-chart"></i>Charts </a></li><span class="heading">Extras</span>-->
            <!--<ul class="list-unstyled">-->
            <!--<li><a href="#"> <i class="icon-flask"></i>Demo </a></li>-->
            <!--<li><a href="#"> <i class="icon-screen"></i>Demo </a></li>-->
            <!--<li><a href="#"> <i class="icon-mail"></i>Demo </a></li>-->
            <!--<li><a href="#"> <i class="icon-picture"></i>Demo </a></li>-->
            <!--</ul>-->
        </ul>
    </div>
</template>

<script>
    import EventBus from '../../util/EventBus'
    import NewDefect from '../defect/NewDefect'
    import NewProject from '../project/NewProject'
    import MyProjectList from '../project/MyProjectList'
    import SubmittedDefectList from '../defect/SubmittedDefectList'
    import ReceivedDefectList from '../defect/ReceivedDefectList'
    import ProjectDefectStatistics from '../statistics/ProjectDefectStatistics'

    export default {
        name: 'Function',
        methods: {
            toNewProject () {
                EventBus.$emit('change-content', NewProject)
            },
            toMyProjectList () {
                EventBus.$emit('change-content', MyProjectList)
            },
            toNewDefect () {
                EventBus.$emit('change-content', NewDefect)
            },
            toMyDefectList () {
                EventBus.$emit('change-content', SubmittedDefectList)
            },
            toReceivedDefectList () {
                EventBus.$emit('change-content', ReceivedDefectList)
            },
            toProjectDefectStatistics () {
                EventBus.$emit('change-content', ProjectDefectStatistics)
            }
        }
    }
</script>

<style scoped>

</style>
