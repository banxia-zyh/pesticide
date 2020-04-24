<template>
    <canvas ref="personnelDefectBarChart"></canvas>
</template>

<script>
    import Chart from '../../../static/template/vendor/chart.js/Chart.min'

    export default {
        name: 'PersonnelDefectBarChart',
        mounted () {
            this.calculateData()
            this.draw()
        },
        props: [
            'defectList',
            'projectUserList'
        ],
        data () {
            return {
                colorList: [],
                usernameList: [],
                defectCountList: []
            }
        },
        watch: {
            defectList () {
                this.calculateData()
                this.draw()
            }
        },
        methods: {
            calculateData () {
                let dateDefectMap = new Map()
                for (let i = 0; i < this.defectList.length; i++) {
                    let defect = this.defectList[i]
                    let userId = defect.resolveUserId
                    let count = dateDefectMap.get(userId)
                    if (count === undefined || count === null || count === '') {
                        count = 0
                    }
                    count++
                    dateDefectMap.set(userId, count)
                }
                // 排序
                let mapArray = Array.from(dateDefectMap)
                mapArray.sort((a, b) => {
                    return a[0] - b[0]
                })
                dateDefectMap = new Map(mapArray.map(i => [i[0], i[1]]))
                // 赋为数组
                this.colorList = []
                this.usernameList = []
                this.defectCountList = []
                // 获取颜色值
                let ctx1 = $('canvas').get(0).getContext('2d')
                let gradient1 = ctx1.createLinearGradient(150, 0, 150, 300)
                gradient1.addColorStop(0, 'rgba(133, 180, 242, 0.91)')
                gradient1.addColorStop(1, 'rgba(255, 119, 119, 0.94)')
                // 迭代赋值
                dateDefectMap.forEach((value, key) => {
                    for (let i = 0; i < this.projectUserList.length; i++) {
                        let userInfo = this.projectUserList[i]
                        if (userInfo.id === key) {
                            this.usernameList.push(userInfo.nickname)
                            break
                        }
                    }
                    this.defectCountList.push(value)
                    this.colorList.push(gradient1)
                })
            },
            draw () {
                let self = this
                // ------------------------------------------------------- //
                // Charts Gradients
                // ------------------------------------------------------ //
                let ctx1 = $('canvas').get(0).getContext('2d')
                let gradient1 = ctx1.createLinearGradient(150, 0, 150, 300)
                gradient1.addColorStop(0, 'rgba(133, 180, 242, 0.91)')
                gradient1.addColorStop(1, 'rgba(255, 119, 119, 0.94)')

                let gradient2 = ctx1.createLinearGradient(146.000, 0.000, 154.000, 300.000)
                gradient2.addColorStop(0, 'rgba(104, 179, 112, 0.85)')
                gradient2.addColorStop(1, 'rgba(76, 162, 205, 0.85)')
                // ------------------------------------------------------- //
                // Bar Chart
                // ------------------------------------------------------ //
                var chart = new Chart(this.$refs.personnelDefectBarChart, {
                    type: 'bar',
                    options: {
                        scales: {
                            xAxes: [{
                                display: true,
                                gridLines: {
                                    color: '#eee'
                                }
                            }],
                            yAxes: [{
                                display: true,
                                gridLines: {
                                    color: '#eee'
                                }
                            }]
                        }
                    },
                    data: {
                        labels: self.usernameList,
                        datasets: [
                            {
                                label: '产生缺陷数',
                                backgroundColor: self.colorList,
                                hoverBackgroundColor: self.colorList,
                                borderColor: self.colorList,
                                borderWidth: 1,
                                data: self.defectCountList
                            }
                            // ,
                            // {
                            //     label: 'Data Set 2',
                            //     backgroundColor: [
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2
                            //     ],
                            //     hoverBackgroundColor: [
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2
                            //     ],
                            //     borderColor: [
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2,
                            //         gradient2
                            //     ],
                            //     borderWidth: 1,
                            //     data: [35, 40, 60, 47, 88, 27, 30],
                            // }
                        ]
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
