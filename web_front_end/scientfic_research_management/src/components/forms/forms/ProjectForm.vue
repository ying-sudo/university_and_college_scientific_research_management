<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="项目表单" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 表单内容 -->
        <div style="padding: 10px; margin: 0 150px; float: left; width: 1500px;">
          <!-- <mu-container> -->
          <el-form style="float: left;" :model="project" ref="project" :rules="rules" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="项目名称">
              <el-input v-model="project.name" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="项目编号">
              <el-input v-model="project.id" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="approvalNumber" label="批准文号">
              <el-input v-model="project.approvalNumber" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="userId" label="负责人学工号">
              <el-input v-model="project.userId" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="所在单位">
              <el-select v-model="project.collegeId" :disabled="flag.isDisabled">
                <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="project.firstDiscipline" :disabled="flag.isDisabled">
                <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="level" label="项目级别">
              <el-select v-model="project.level" :disabled="flag.isDisabled">
                <el-option v-for="option in level" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="characters" label="项目性质">
              <el-radio-group v-model="project.characters">
                <el-radio label="crosswise" :disabled="flag.isDisabled || notDisabled">横向</el-radio>
                <el-radio label="lengthways" :disabled="flag.isDisabled || notDisabled">纵向</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="state" label="项目状态">
              <el-select v-model="project.state" :disabled="flag.isDisabled">
                <el-option v-for="option in state" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="project.discipline">
                <el-radio label="science" :disabled="flag.isDisabled || notDisabled">理科类</el-radio>
                <el-radio label="social" :disabled="flag.isDisabled || notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="sort" label="项目分类">
              <el-select v-model="project.sort" :disabled="flag.isDisabled">
                <el-option v-for="option in sort" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="立项日期">
              <el-date-picker v-model="project.beginDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="结项日期">
              <el-date-picker prop="endDate" v-model="project.endDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="requestFund" label="申请经费">
              <el-input v-model.float="project.requestFund" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="arrivalFund" label="到账经费">
              <el-input v-model.number="project.arrivalFund" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; " v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1500px;" prop="information"
              label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="project.information" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>


        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; width: 1820px;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('project')" color="primary">
              确定&nbsp;&nbsp;
              <i right class="el-icon-upload"></i>
            </mu-button>
          </div>
          <div v-else>
            <mu-button @click="editForm" color="primary">
              编辑&nbsp;&nbsp;
              <i right class="el-icon-edit-outline"></i>
            </mu-button>
            <mu-button @click="closeAlertDialog" color="primary">
              返回
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
      "collegeInfo", //学院信息
      "firstDisciplineProp", //第一学科
      "levelProp", //项目级别
      "sortProp", //项目分类
      "TableRow",
    ],
    model: {
      prop: "flag",
      event: "click",
    },
    data() {
      return {

        // collegeInfo: null,

        labelPosition: "top",
        isSubmit: true,
        notDisabled: false,
        rules: this.GLOBAL.rules,
        loading: false,
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
        collegeId: [], //学院信息
        users: [
          //参加人员
        ],
        firstDiscipline: [], //一级学科内容
        level: [], //项目级别
        sort: [], //项目分类
        state: [{
            id: 1,
            name: "进行"
          },
          {
            id: 2,
            name: "结束"
          },
          {
            id: 3,
            name: "延期"
          }
        ],
      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.project = this.TableRow;
      }
      this.notDisabled = this.flag.isDisabled;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        //父子组件传值
        this.$emit("click", this.flag);
      },
      makesure() {
        this.loading = true;
        //改成string格式
        // var proString = JSON.stringify(this.project);
        var proString = this.project;

        // 用户成员
        var sendUser = Global.methods.getUser(this.users, this.project);
        var usersString = JSON.stringify(sendUser);
        // 进行数据和后端交互

        var token = localStorage.getItem('token');
        this.axios.defaults.headers.common["Authorization"] = token;
        if (this.notDisabled) {
          this.axios
            .put(
              this.GLOBAL.BASE_URL + "/mangerSys/projects",
              proString
            )
            .then((response) => {
              this.loading = false;
              if (response.data.resultCode == 0) {
                Global.methods.message_success(this, '修改成功');
                this.closeAlertDialog();
              } else {
                Global.methods.message_warning(this, '请检查信息是否填写完整正确');
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        } else {
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/projects", proString)
            .then((response) => {
              this.loading = false;
              if (response.data.resultCode == 0) {
                Global.methods.message_success(this, '申报成功');
                this.closeAlertDialog();
              } else {
                Global.methods.message_warning(this, '请检查信息是否填写完整正确');
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        }
      },
      editForm() {
        // this.notDisabled = this.flag.isDisabled;
        Global.methods.editForm(this.flag);
      },
      canMakesure(formName) {
        //判断能否提交，必须全部填写
        this.isSubmit = Global.methods.judgeDate(this.project.beginDate, this.project.endDate);
        //this.issubmit为true，才能进行判断是否填写完整
        console.log('asdf    ' + this.isSubmit);
        if (this.isSubmit) {
          this.isSubmit = Global.methods.canMakesure(this, formName, this.project);
          console.log('asdfads    ' + this.isSubmit);
        }
        if (this.isSubmit) {
          this.makesure();
        }
      },
      // getAllData() {
      //   this.collegeInfo = Global.methods.getCollegeData(this);
      //   console.log(this.collegeInfo);
      // }
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
