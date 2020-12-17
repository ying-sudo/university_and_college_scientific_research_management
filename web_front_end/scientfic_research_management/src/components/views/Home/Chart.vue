<template>
  <div id="statisticsChart" style="width: 500px; height: 750px; float: left;">

<!--   时间框，今天的时间进行标红
    天气框
    统计图，统计表格，统计图点击可以展开统计表格？
    统计图
    统计图 -->

  </div>
</template>

<script>
  import ChartGlobal from '@/components/views/Home/chartGlobal.vue'

  export default {
    data() {
      return {
        statisticsChart: {},
        number: {
          project: 1,
          paper: 2,
          patent: 3,
          scientific: 5,
          work: 1,
        },
      };
    },
    mounted() {
      this.drawChart();
    },
    methods: {
      drawChart() {
        this.statisticsChart = ChartGlobal.methods.getElementById(this, 'statisticsChart');
        this.chart();
      },
      chart() {
        let option = {
          title: {
            text: '项目总览图',
            x: 'center'
          },
          legend: {
            orient: 'vertical',
            left: 'left',
          },
          tooltip: {
            formatter: '{b}: {d}%'
          },
          dataset: {
            source: [{
                value: this.number.project,
                name: '项目'
              },
              {
                value: this.number.paper,
                name: '论文成果'
              },
              {
                value: this.number.work,
                name: '著作成果'
              },
              {
                value: this.number.scientific,
                name: '科研成果'
              },
              {
                value: this.number.patent,
                name: '专利产品'
              }
            ]
          },
          series: [{
            type: 'pie',
            radius: '60%', //饼图的半径
            label: {
              formatter: '{b}: {@value} ({d}%)'
            },
            selectedMode: 'single',
          }]
        };
        this.statisticsChart.setOption(option);
      },
    },
    components: {
    }
  };
</script>

<style>

</style>
