<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="项目考核结果" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <div style="width: 180px; height: 210px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); float: left;">
          <div style="font-size: 30px; margin-top: 20px;">
            考核结果
          </div>
          <el-divider></el-divider>
          <el-input ref="score" v-model="evaluationResult.score" :disabled="scoreDisabled"></el-input>
          <div>
            <div v-if="!scoreDisabled">
              <mu-button style="margin-top: 20px;" @click="enterScore" color="primary">
                确定&nbsp;&nbsp;
                <i right class="el-icon-check"></i>
              </mu-button>
            </div>
            <div v-else>
              <mu-button style="margin-top: 20px;" @click="enterScore" color="primary">
                修改&nbsp;&nbsp;
                <i right class="el-icon-check"></i>
              </mu-button>
            </div>
          </div>
        </div>

        <!-- 表单内容 -->
        <div style="padding: 10px; margin: 0 20px; float: left; width: 1500px;">
          <!-- <mu-container> -->
          <el-form style="float: left;" :model="project" ref="project" :label-position="labelPosition" label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="项目名称">
              <el-input v-model="project.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="项目编号">
              <el-input v-model="project.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="approvalNumber" label="批准文号">
              <el-input v-model="project.approvalNumber" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="userId" label="负责人学工号">
              <el-input v-model="project.userId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="所在单位">
              <el-select v-model="project.collegeId" :disabled="notDisabled">
                <!-- <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="一级学科">
              <el-select v-model="project.firstDiscipline" :disabled="notDisabled">
                <!-- <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目级别">
              <el-select v-model="project.level" :disabled="notDisabled">
                <!-- <el-option v-for="option in level" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="characters" label="项目性质">
              <el-radio-group v-model="project.characters">
                <el-radio label="crosswise" :disabled="notDisabled">横向</el-radio>
                <el-radio label="lengthways" :disabled="notDisabled">纵向</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目状态">
              <el-select v-model="project.state" :disabled="notDisabled">
                <!-- <el-option v-for="option in state" :key="option.id" :label="option.name" :value="option.id"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="project.discipline">
                <el-radio label="science" :disabled="notDisabled">理科类</el-radio>
                <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目分类">
              <el-select v-model="project.sort" :disabled="notDisabled">
                <!-- <el-option v-for="option in sort" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="立项日期">
              <el-date-picker v-model="project.beginDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="结项日期">
              <el-date-picker prop="endDate" v-model="project.endDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="requestFund" label="申请经费">
              <el-input v-model.float="project.requestFund" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="arrivalFund" label="到账经费">
              <el-input v-model.number="project.arrivalFund" :disabled="notDisabled"></el-input>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; " v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1500px;" prop="information"
              label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="project.information" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; width: 1820px;">
          <div>
            <mu-button @click="makeButton" color="primary">
              确定&nbsp;&nbsp;
              <i right class="el-icon-upload"></i>
            </mu-button>
          </div>
        </div>
      </el-dialog>
    </mu-container>

  </div>

</template>

<script>
  import UserTable from '@/components/forms/global/UserTable.vue'
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: [
      "flag",
      "TableRow",
    ],
    model: {
      prop: "flag",
      event: "click",
    },
    data() {
      return {
        labelPosition: "top",
        isSubmit: true,
        notDisabled: true, //成绩能否修改，true为不能
        scoreDisabled: true,
        loading: false,
        evaluationResult: {
          id: null,
          score: null,
          sort: null,
          datename: null,
        },
        rules: {
          name: [{
              required: true,
              message: '请输入成绩'
            },
            {
              type: 'number',
              message: '请输入数字'
            },
          ]
        },
        project: {
          id: null, //项目编号
          name: null, //项目名称
          userId: null, //负责人
          collegeId: null, //所属学院
          discipline: null, //学科门类
          characters: null, //项目性质
          firstDiscipline: null, //一级学科
          level: null, //项目级别
          sort: null, //项目分类
          beginDate: null, //立项日期
          endDate: null, //结项日期
          requestFund: null, //项目申请经费
          arrivalFund: null, //到账金额
          state: null, //审核状态
          approvalNumber: null, //批准文号
          information: null, //项目信息
        },
        users: [
          //参加人员
        ],
      };
    },
    created: function() {
      this.notDisabled = true;
      if (!this.evaluationResult.score) {
        this.$nextTick(() => {
          this.$refs.score.focus();
        });
        this.scoreDisabled = false;
      }
      if (!this.flag.isDisabled) {
        this.enterScore();
      }
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        //父子组件传值
        this.$emit("click", this.flag);
      },
      enterScore() {
        //回车进行成绩输入确定
        let that = this;
        document.onkeypress = function(e) {
          var keyCode = document.all ? event.keyCode : e.which;
          if (that.$route.path == "/helloworld" && keyCode == 13) {
            that.makeScore();
            return;
          }
        }
      },
      makeScore() { //成绩确定按钮
        if (this.evaluationResult.score == null) {
          Global.methods.message_warning(this, '成绩不符合规范');
          this.evaluationResult.score = null;
          return false;
        }
        this.evaluationResult.score = this.evaluationResult.score * 1.0;
        //判断成绩是否符合规范
        if (this.evaluationResult.score >= 0 && this.evaluationResult.score <= 100) {
          this.evaluationResult.id = this.project.id;
          this.evaluationResult.sort = 'project';
          this.evaluationResult.datename = null;
          Global.methods.message_success(this, '成绩输入成功');
          return true;
        } else {
          Global.methods.message_warning(this, '成绩不符合规范');
          this.evaluationResult.score = null;
          return false;
        }
      },
      makeButton() { //确定按钮
        var isMake = this.makeScore();
        if (isMake) {
          this.closeAlertDialog();
          return true;
        } else {
          return false;
        }
      },

    },
    components: {
      UserTable,
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
