<template>
    <!-- Dashboard Counts Section-->
    <section class="dashboard-counts" style="padding: 0px">
        <div class="container-fluid" style="padding: 0px;">
            <div class="row bg-white">
                <!-- Item -->
                <div class="col-xl-4 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-violet"><i class="icon-list"></i></div>
                        <div class="title"><span>总缺陷&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <div class="progress">
                                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="100"
                                     class="progress-bar bg-violet" role="progressbar"
                                     style="width: 100%; height: 4px;"></div>
                            </div>
                        </div>
                        <div class="number"><strong>{{totalDefectCount}}</strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-4 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-green"><i class="el-icon-finished"></i></div>
                        <div class="title"><span>已解决缺陷</span>
                            <div class="progress">
                                <div :style="{width: resolvedDefectCount*100/totalDefectCount + '%', height: '4px'}"
                                     aria-valuemax="100" aria-valuemin="0"
                                     aria-valuenow="100" class="progress-bar bg-green"
                                     role="progressbar"></div>
                            </div>
                        </div>
                        <div class="number"><strong>{{resolvedDefectCount}}</strong></div>
                    </div>
                </div>
                <!-- Item -->
                <div class="col-xl-4 col-sm-6">
                    <div class="item d-flex align-items-center">
                        <div class="icon bg-red"><i class="icon-bill"></i></div>
                        <div class="title"><span>未解决缺陷</span>
                            <div class="progress">
                                <div :style="{width: unresolvedDefectCount*100/totalDefectCount + '%', height: '4px'}"
                                     aria-valuemax="100" aria-valuemin="0"
                                     aria-valuenow="100" class="progress-bar bg-red"
                                     role="progressbar"></div>
                            </div>
                        </div>
                        <div class="number"><strong>{{unresolvedDefectCount}}</strong></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>

    export default {
        name: 'DefectOverview',
        props: [
            'defectList'
        ],
        data () {
            return {
                totalDefectCount: 0,
                resolvedDefectCount: 0,
                unresolvedDefectCount: 0
            }
        },
        watch: {
            defectList () {
                this.calculate()
            }
        },
        created () {
            this.calculate()
        },
        methods: {
            calculate () {
                this.totalDefectCount = this.defectList.length
                let resolved = 0
                for (let i = 0; i < this.defectList.length; i++) {
                    if (this.defectList[i].defectState === 'RESOLVED') {
                        resolved++
                    }
                }
                this.resolvedDefectCount = resolved
                this.unresolvedDefectCount = this.totalDefectCount - resolved
            }
        }
    }
</script>

<style scoped>

</style>
