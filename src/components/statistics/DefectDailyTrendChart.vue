<template>
    <canvas ref="defectDailyTrendChart"></canvas>
</template>

<script>
    import Chart from '../../../static/template/vendor/chart.js/Chart.min'

    export default {
        name: 'DefectDailyTrendChart',
        mounted () {
            this.calculateData()
            this.draw()
        },
        props: [
            'defectList'
        ],
        data () {
            return {
                dateList: [],
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
                    let date = defect.submitTime.substring(0, 10)
                    let count = dateDefectMap.get(date)
                    if (count === undefined || count === null || count === '') {
                        count = 0
                    }
                    count++
                    dateDefectMap.set(date, count)
                }
                // 排序
                let mapArray = Array.from(dateDefectMap)
                mapArray.sort((a, b) => {
                    return a[0].localeCompare(b[0])
                })
                dateDefectMap = new Map(mapArray.map(i => [i[0], i[1]]))
                // 赋为数组
                this.dateList = []
                this.defectCountList = []
                dateDefectMap.forEach((value, key) => {
                    this.dateList.push(key)
                    this.defectCountList.push(value)
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

                let example = new Chart(this.$refs.defectDailyTrendChart, {
                    type: 'line',
                    options: {
                        legend: {labels: {fontColor: '#777', fontSize: 12}},
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
                        labels: self.dateList,
                        datasets: [
                            {
                                label: '今日缺陷',
                                fill: true,
                                lineTension: 0.3,
                                backgroundColor: gradient1,
                                borderColor: gradient1,
                                borderCapStyle: 'butt',
                                borderDash: [],
                                borderDashOffset: 0.0,
                                borderJoinStyle: 'miter',
                                borderWidth: 1,
                                pointBorderColor: gradient1,
                                pointBackgroundColor: '#fff',
                                pointBorderWidth: 1,
                                pointHoverRadius: 5,
                                pointHoverBackgroundColor: gradient1,
                                pointHoverBorderColor: 'rgba(220,220,220,1)',
                                pointHoverBorderWidth: 2,
                                pointRadius: 1,
                                pointHitRadius: 10,
                                data: self.defectCountList,
                                spanGaps: false
                            }
                            // ,
                            // {
                            //     label: 'Data Set Two',
                            //     fill: true,
                            //     lineTension: 0.3,
                            //     backgroundColor: gradient2,
                            //     borderColor: gradient2,
                            //     borderCapStyle: 'butt',
                            //     borderDash: [],
                            //     borderDashOffset: 0.0,
                            //     borderJoinStyle: 'miter',
                            //     borderWidth: 1,
                            //     pointBorderColor: gradient2,
                            //     pointBackgroundColor: '#fff',
                            //     pointBorderWidth: 1,
                            //     pointHoverRadius: 5,
                            //     pointHoverBackgroundColor: gradient2,
                            //     pointHoverBorderColor: 'rgba(220,220,220,1)',
                            //     pointHoverBorderWidth: 2,
                            //     pointRadius: 1,
                            //     pointHitRadius: 10,
                            //     data: [50, 40, 50, 40, 45, 40, 30],
                            //     spanGaps: false
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
