<template>
    <!-- Daily Feeds -->
    <div class="col-lg-4">
        <div class="daily-feeds card">
            <div class="card-header">
                <h3 class="h4">Daily Feeds</h3>
            </div>
            <div class="card-body no-padding">
                <!-- Item-->
                <div :key="index" class="item" v-for="(project, index) in projectList">
                    <div class="feed d-flex justify-content-between">
                        <div class="feed-body d-flex justify-content-between">
                            <div class="content">
                                <h3>{{project.name}}</h3><span>简介：{{project.intro}}</span>
                                <div class="full-date">
                                    <small>创建时间：{{project.createTime}}</small>
                                </div>
                                <div class="full-date">
                                    <small>人数：{{personnelNum}}</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'ProjectList',
        data () {
            return {
                projectList: [{name: 'fdf', intro: 'intro....', createTime: '2015-02-02'}],
                personnelNum: 34
            }
        }
    }
</script>

<style scoped>

</style>
