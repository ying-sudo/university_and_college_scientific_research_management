<template>
  <!-- 学院考核 -->

  <div>

    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="学院考核详情" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>


        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="college.id" :sort="'college'"></ScoreTable>


        <!-- 表单内容 -->
        <div style="float: left; padding: 10px; width: 1550px; margin: 0 20px;">
          <el-form :model="college" ref="college" :label-position="labelPosition" label-width="1000">

            <el-form-item class="mu-demo-min-form" prop="id" label="学院编号">
              <el-input v-model="college.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="name" label="学院名称">
              <el-input v-model="college.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="state" label="学院状态">
              <el-select v-model="college.state" :disabled="notDisabled">
                <!-- <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="phone" label="职工人数">
              <el-input v-model="college.phone" :disabled="notDisabled"></el-input>
            </el-form-item>


            <el-form-item class="mu-demo-min-form" prop="collegeId" label="校区">
              <el-select v-model="college.collegeId" :disabled="notDisabled">
                <!-- <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <!-- 项目数据表格 -->
              <div>
                学院的项目
                每个项目的分数
              </div>

            <!-- 表单备注 -->
            <el-form-item style="float: left; width: 1470px;" prop="note" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="college.note" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="float: left; text-align: center; width: 100%; margin-bottom: 15px;">
          <div>
            <mu-button @click="closeAlertDialog" color="primary">
              返回&nbsp;&nbsp;
            </mu-button>
          </div>
        </div>

      </el-dialog>
    </mu-container>

  </div>

</template>

<script>
  import Global from '@/components/forms/global/global.vue'
  import ScoreTable from '@/components/forms/global/ScoreTable.vue'

  export default {
    props: [
      'flag',
      "TableRow",
    ],
    model: {
      prop: 'flag',
      event: 'click'
    },
    data() {
      return {
        labelPosition: 'top',
        notDisabled: true, //部分不能更改的标志
        loading: false,
        /*
    姓名 name
    学院 Id
    状态 state
    校区 location
    职工人数 snumber
    信息 information

    */
        college: {
          id: null,
          name: null,
          state: 's',
          location: null,
          snumber: null,
          information: null
        },
        //学院的所有项目
        projects: [
          {

          }
        ],
      };
    },
    created: function() {
      // this.college = this.TableRow;
      this.notDisabled = true;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
    },
    components: {
      ScoreTable,
    },
  };
</script>

<style>
  .mu-demo-min-form {
    width: 100%;
    max-width: 300px;
    padding-right: 40px;
    padding-left: 10px;
    float: left;
  }

  .el-dialog__title {
    font-size: 40px;
  }

  .el-form-item__label {
    font-size: 20px;
  }

  .el-radio__label {
    font-size: 18px;
  }
</style>
