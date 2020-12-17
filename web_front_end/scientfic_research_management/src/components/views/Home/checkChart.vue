<template>
  <div id="resultChart" style="float: left; width: 720px; height: 620px;">
    <!--    考核成绩
    按照顺序写过来，然后
    总，全部写过来
    横，为 项目。。。。
    纵，为平均分
    最高分，最低分
    分开来 -->
  </div>
</template>

<script>
  import ChartGlobal from '@/components/views/Home/chartGlobal.vue'
  import Global from '@/components/forms/global/global.vue'

  export default {
    data() {
      return {
        resultChart: {},
        name: ['项目考核结果', '论文考核结果', '专利考核结果', '科研考核结果', '著作考核结果'],
        minScore: [],
        maxScore: [],
        avgScore: [],
        titleName: ['最低考核成绩', '最高考核成绩', '平均考核成绩'],
      };
    },
    mounted() {
      this.resultChart = ChartGlobal.methods.getElementById(this, 'resultChart');
      this.resultChart.showLoading();
      this.getData();
    },
    methods: {
      drawChart() {
        this.chart();
        this.resultChart.hideLoading();
      },
      chart() {
        let option = {
          title: {
            text: '考核结果成绩总览表',
            left: 'left'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          legend: {
            data: this.titleName,
            left: 'right',
          },
          xAxis: {
            type: 'category',
            data: this.name,
          },
          yAxis: {
            type: 'value',
            name: '考核结果',
            min: 0,
            max: 100,
          },
          series: [{
              name: '最低考核成绩',
              data: this.minScore,
              type: 'bar',
            },
            {
              name: '最高考核成绩',
              data: this.maxScore,
              type: 'bar',
            },
            {
              name: '平均考核成绩',
              type: 'line',
              data: this.avgScore,
            }
          ]
        };
        this.resultChart.setOption(option);
      },
      getData() {
        //请求数据
        var userId = sessionStorage.getItem('userId');
        console.log(userId);
        var token = sessionStorage.getItem('token');
        this.axios.defaults.headers.common["Authorization"] = token;
        this.axios
          .post(
            this.GLOBAL.BASE_URL +
            "/mangerSys/home/assessmentresult", userId, {
              headers: {
                'Content-Type': "application/json"
              }
            }
          )
          .then((response) => {
            console.log('checkChart :');
            console.log(response);
            var chartJson = JSON.parse(response.data.data);
            console.log(chartJson);

            var i = 0;
            for (var key in chartJson) {
              var res = Global.methods.getMaxMinAvgByArray(chartJson[key]);
              this.minScore[i] = res[0];
              this.maxScore[i] = res[1];
              this.avgScore[i] = res[2];
              i++;
            }


            this.drawChart();
          })
          .catch((error) => {
            Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
          });
      },

    }
  };
</script>

<style>
</style>
