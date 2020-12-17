<template>
  <div id="statisticsChart" style="float: left; width: 700px; height: 620px;">

    <!--    时间框，今天的时间进行标红
    天气框
    统计图，统计表格，统计图点击可以展开统计表格？
    统计图
    统计图 -->

  </div>
</template>

<script>
  import ChartGlobal from '@/components/views/Home/chartGlobal.vue'
  import Global from '@/components/forms/global/global.vue'

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
        name: {
          project: "项目",
          paper: "论文成果",
          patent: "专利产品",
          scientific: "科研成果",
          work: "著作成果",
        }
      };
    },
    mounted() {
      this.statisticsChart = ChartGlobal.methods.getElementById(this, 'statisticsChart');
      this.statisticsChart.showLoading();
      this.getData();
    },
    methods: {
      drawChart() {
        this.chart();
        this.statisticsChart.hideLoading();
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
                name: this.name.project,
              },
              {
                value: this.number.paper,
                name: this.name.paper,
              },
              {
                value: this.number.work,
                name: this.name.work,
              },
              {
                value: this.number.scientific,
                name: this.name.scientific,
              },
              {
                value: this.number.patent,
                name: this.name.patent,
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
      getData() {
        //请求数据
        var userId = sessionStorage.getItem('userId');
        var token = sessionStorage.getItem('token');
        this.axios.defaults.headers.common["Authorization"] = token;
        this.axios
          .post(
            this.GLOBAL.BASE_URL +
            "/mangerSys/home/overview",
            userId, {
              headers: {
                'Content-Type': "application/json"
              }
            }
          )
          .then((response) => {
            var chartJson = JSON.parse(response.data.data);
            Global.methods.getValueOne(chartJson, this.number);
            console.log('pichart:')
            console.log(this.number);
            this.drawChart();
          })
          .catch((error) => {
            Global.methods.message_error(this, '出现错误，请稍后重试');
          });
      },

    },
    components: {},
    
  };
</script>

<style>

</style>
