<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog title="著作申报" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 100%;">
          <el-form :model="work_achievement" ref="work_achievement" :rules="rules" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="著作题目">
              <el-input v-model="work_achievement.name" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="著作编号">
              <el-input v-model="work_achievement.id" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publisher" label="出版单位">
              <el-input v-model="work_achievement.publisher" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publishLevel" label="出版社级别">
              <el-select v-model="work_achievement.publishLevel" :disabled="flag.isDisabled">
                <el-option v-for="option in publishLevel" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workType" label="著作类别">
              <el-select v-model="work_achievement.workType" :disabled="flag.isDisabled">
                <el-option v-for="option in workType" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publishLocation" label="出版地">
              <el-select v-model="work_achievement.publishLocation" :disabled="flag.isDisabled">
                <el-option v-for="option in publishLocation" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isbnId" label="ISBN号">
              <el-input v-model="work_achievement.isbnId" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isTranslate" label="是否翻译">
              <el-radio-group v-model="work_achievement.isTranslate">
                <el-radio label="true" :disabled="flag.isDisabled">是</el-radio>
                <el-radio label="false" :disabled="flag.isDisabled">否</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="translateLanguage" label="翻译语种">
              <el-select v-model="work_achievement.translateLanguage" :disabled="flag.isDisabled || work_achievement.isTranslate!='true'">
                <el-option v-for="option in translateLanguage" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="work_achievement.discipline">
                <el-radio label="science" :disabled="flag.isDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="flag.isDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="建设时间">
              <el-date-picker v-model="work_achievement.beginDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isDisabled" label="研究类别">
              <el-radio-group v-model="work_achievement.characters">
                <el-radio label="basics" :disabled="flag.isDisabled">基础研究</el-radio>
                <el-radio label="apply" :disabled="flag.isDisabled">应用研究</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="work_achievement.firstDiscipline" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="work_achievement.collegeId" :disabled="flag.isDisabled">
                <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workSource" label="项目来源">
              <el-select v-model="work_achievement.workSource" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in workSource" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; width: 100%;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="margin: 10px; float: left; width: 100%;" prop="information" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="work_achievement.information" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; text-align: center; width: 100%; margin-top: 20px;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('work_achievement')" color="primary">
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
  import UserTable from './UserTable.vue'
  import Global from './global.vue';

  export default {
    props: [
      'flag',
      "collegeInfo", //学院信息
      "firstDisciplineProp", //第一学科
      "levelProp", //项目级别
      "sortProp", //项目分类
      "TableRow"
    ],
    model: {
      prop: 'flag',
      event: 'click'
    },
    data() {
      return {
        labelPosition: 'top',
        notDisabled: false,
        isSubmit: true,
        rules: this.GLOBAL.rules,
        work_achievement: {
          id: null, //著作编号
          name: null, //著作题目
          publisher: null, //出版单位
          publishLevel: null, //出版社级别
          workType: null, //著作类别
          publishLocation: null, //出版地
          isbnId: null, //ISBN号
          isTranslate: null, //是否翻译
          translateLanguage: null, //翻译语种
          discipline: null, //学科门类
          beginDate: null, //出版时间
          characters: null, //研究类别
          firstDiscipline: null, //一级学科
          collegeId: null, //成果归属
          workSource: null, //项目来源
          userId: null, //作者
          information: null //详细信息
        },
        publishLevel: [
          '级别1', '级别2'
        ],
        workType: [
          '类别1', '类别2'
        ],
        publishLocation: [
          '出版地1', '出版地2'
        ],
        translateLanguage: [
          '翻译语种1', '翻译语种2'
        ],
        firstDiscipline: [
          '一级学科1', '一级学科2'
        ],
        users: [
          //参加人员
          {
            id: '2011000416',
            name: 'asdf',
            collegeName: '12342we',
            contribution: 23
          }
        ],
        collegeId: [],
        firstDiscipline: [], //一级学科内容
        level: [], //项目级别
        sort: [], //项目分类
        workSource: [
          '项目来源1', '项目来源2'
        ]
      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.project = this.TableRow;
      }
      this.notDisabled = this.flag.isDisabled;
      this.collegeId = this.collegeInfo;
      this.firstDiscipline = this.firstDisciplineProp;
      this.level = this.levelProp;
      this.sort = this.sortProp;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
      makesure() {
        //改成string格式
        var proString = JSON.stringify(this.work_achievement);
        // 用户成员
        var sendUser = Global.methods.getUser(this.users, this.work_achievement);
        var usersString = JSON.stringify(sendUser);
        // 进行数据和后端交互
        if (this.notDisabled) {
          console.log("项目表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/work/works/" +
              this.work_achievement.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("项目表单  request  over");
            });
        } else {
          console.log("项目表单申报  request begin:  ");
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/work/works", {
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
        this.flag.isDisabled = false;
      },
      canMakesure(formName) {
        //判断能否提交，必须全部填写
        this.isSubmit = Global.methods.judgeDate(this.work_achievement.beginDate, this.work_achievement.endDate);
        if (this.isSubmit) {
          this.isSubmit = Global.methods.canMakesure(this, formName, this.work_achievement);
        }
        if (this.isSubmit) {
          this.makesure();
        }
      },
    },
    components: {
      UserTable,
    }
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

  .el-dialog__headerbtn {
    width: 30px;
    height: 30px;
  }

</style>
