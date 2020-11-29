<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlert">
        <div class="mu-dialog-title">
          项目申报
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 700px; overflow-y: scroll; padding: 10px;">
          <mu-container>
            <mu-form :model="project" :label-position="labelPosition" label-width="100">
  <!--            <mu-form-item class="mu-demo-min-form float_left" prop="input" label="项目名称">
                <mu-text-field v-model="project.name" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>
 -->
              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="项目编号">
                <mu-text-field v-model="project.id" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="批准文号">
                <mu-text-field v-model="project.approvalNumber" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="负责人学工号">
                <mu-text-field v-model="project.userId" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="所在单位">
                <mu-select v-model="project.collegeId" :disabled="flag.isDisabled">
                  <mu-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                <mu-select v-model="project.firstDiscipline" :disabled="flag.isDisabled">
                  <mu-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="项目级别">
                <mu-select v-model="project.level" :disabled="flag.isDisabled">
                  <mu-option v-for="option in level" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="项目性质">
                <mu-radio v-model="project.characters" value="crosswise" label="横向" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                <mu-radio v-model="project.characters" value="lengthways" label="纵向" :disabled="flag.isDisabled || notDisabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="select" label="项目状态">
                <mu-select v-model="project.state" :disabled="flag.isDisabled">
                  <mu-option v-for="{option,index} in state.name" :key="state.id[index]" :label="option" :value="state.id[index]"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="project.discipline" value="science" label="理科类" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                <mu-radio v-model="project.discipline" value="social" label="社科类" :disabled="flag.isDisabled || notDisabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="项目分类">
                <mu-select v-model="project.sort" :disabled="flag.isDisabled">
                  <mu-option v-for="option in sort" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="project.beginDate" label="立项日期" label-float full-width landscape
                  :disabled="flag.isDisabled || notDisabled" value-format="YYYY-MM-DD"></mu-date-input>
              </mu-col>

              <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="project.endDate" label="结项日期" label-float full-width landscape
                  :disabled="flag.isDisabled" value-format="YYYY-MM-DD"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="申请经费">
                <mu-text-field v-model="project.requestFund" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="到账经费">
                <mu-text-field v-model="project.arrivalFund" :disabled="flag.isDisabled"></mu-text-field>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <UserTable v-model='flag.isDisabled, users'></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="padding-top: 20px; margin: 10px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="project.textarea" :disabled="flag.isDisabled"></mu-text-field>
              </mu-form-item>

            </mu-form>
          </mu-container>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure" color="primary">
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
      </mu-dialog>
    </mu-container>
  </div>

</template>


<script>
  import UserTable from "./UserTable.vue";
  import Global from './global.vue'

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
        labelPosition: "top",
        isSubmit: true,
        notDisabled: false,
        project: {
          id: "", //项目编号
          name: "", //项目名称
          userId: "", //负责人
          collegeId: "", //所属学院
          discipline: "", //学科门类
          characters: "", //项目性质
          firstDiscipline: "", //一级学科
          level: "", //项目级别
          sort: "", //项目分类
          beginDate: "", //立项日期
          endDate: "", //结项日期
          requestFund: "", //项目申请经费
          arrivalFund: "", //到账金额
          state: "", //审核状态
          approvalNumber: "", //批准文号
          information: "", //项目信息
        },
        collegeId: [], //学院信息
        users: [
          //参加人员
          {
            id: '2011000416',
            contribution: 23
          }
        ],
        firstDiscipline: [], //一级学科内容
        level: [], //项目级别
        sort: [], //项目分类
        state: {
          id: [1, 2, 3],
          name: ["进行", "结束", "延期"],
        },
      };
    },
    created: function() {
      console.log('test: !!!!!!!!!!!!!');
      this.project = this.TableRow;
      console.log('ssssssssL：    ' + this.project)
      this.collegeId = this.collegeInfo;
      console.log('collegeid:   ' + this.collegeId.name);
      this.firstDiscipline = this.firstDisciplineProp;
      // console.log('firstDiscipline:   ' + this.firstDiscipline);
      this.level = this.levelProp;
      // console.log('level:    ' + this.level);
      this.sort = this.sortProp;
      // console.log('sort:     ' + this.sort);
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);

        this.$emit("click", this.flag);
      },
      makesure() {

        // this.project.userId = localStorage.getItem("userid");
        // this.project.userId = "2011000416";
        var proString = JSON.stringify(this.project);

        var usersString = JSON.stringify(this.users);

        console.log(proString);

        // this.notDisabled = true;
        if (this.notDisabled) {
          console.log("项目表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/project/projects/" +
              proString.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("项目表单  request  over");
            });
        } else {
          console.log("项目表单申报  request begin:  ");
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/project/projects", {
              project: proString,
              users: usersString,
            })
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("项目表单  request  over");
            });
        }

        this.closeAlertDialog();
      },
      editForm() {
        this.notDisabled = this.flag.isDisabled;
        Global.methods.editForm(this.flag);
      },
      canMakesure() {
        //判断能否提交，必须全部填写

        this.isSubmit = Global.methods.canMakesure(this.project);
        console.log(this.isSubmit);
        if (this.isSubmit) {
          console.log("it is ok!!!");
          this.makesure();
        }
      },
    },
    components: {
      UserTable,
    },
  };
</script>


<style>
  .mu-demo-form {
    width: 100%;
    max-width: 800px;
  }

  .mu-demo-min-form {
    width: 100%;
    max-width: 340px;
    padding-right: 40px;
    padding-left: 10px;
  }

  .float_left {
    float: left;
  }
</style>
