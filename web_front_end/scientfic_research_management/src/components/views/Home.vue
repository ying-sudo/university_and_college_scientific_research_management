<template>
  <div id="outerContainer">

    <el-row :gutter="20">
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <span style="font-weight: bold; font-size: 130%;">{{ userName }},您好!</span>
          <div class="all-label-margin">
            <el-card class="box-card">
              <div
                slot="header"
                class="clearfix"
              >
                <span>项目统计</span>
              </div>

              <div
                v-for="o in 4"
                :key="o"
                class="text item"
                id="itemContainer"
              >
                {{'列表内容 ' + o }}
                <a href="#"><i
                    class="el-icon-right"
                    style="float: right; padding: 3px 0; color: black"
                  ></i></a>
              </div>

            </el-card>
          </div>

        </div>
      </el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple">
          <el-progress
            class="all-label-margin"
            type="dashboard"
            :percentage="percentage"
            :color="colors"
          ></el-progress>

          <div class="project-desc"><span>项目开始于：{{ startTime }}</span></div>
          <div class="project-desc"><span>距离结束还有{{ remainDay }}天</span></div>
          <div>
            <el-button-group>
              <el-button
                icon="el-icon-minus"
                @click="decrease"
              ></el-button>
              <el-button
                icon="el-icon-plus"
                @click="increase"
              ></el-button>
            </el-button-group>
          </div>

        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userName: "大司马",
      percentage: 10,
      colors: [
        { color: "#f56c6c", percentage: 20 },
        { color: "#e6a23c", percentage: 40 },
        { color: "#5cb87a", percentage: 60 },
        { color: "#1989fa", percentage: 80 },
        { color: "#6f7ad3", percentage: 100 },
      ],
      startTime: "2020年11月19日",
      remainDay: 50,
    };
  },
  methods: {
    increase() {
      this.percentage += 10;
      if (this.percentage > 100) {
        this.percentage = 100;
      }
    },
    decrease() {
      this.percentage -= 10;
      if (this.percentage < 0) {
        this.percentage = 0;
      }
    },
  },
};
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 360px;
}

#outerContainer {
  text-align: left;
}

#itemContainer {
  overflow: auto;
  max-height: 220px;
}
.project-desc {
  position: relative;
  left: 12em;
  bottom: 7em;
  width: 30%;
  /* top: 10px; */
  /* float: left; */
}

.all-label-margin {
  margin: 10px 6px 8px 5px;
}
</style>