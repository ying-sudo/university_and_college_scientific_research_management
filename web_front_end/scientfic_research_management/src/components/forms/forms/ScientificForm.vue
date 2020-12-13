<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="科研申报" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 1520px; margin: 0 140px;">
          <el-form :model="scientific_achievement" ref="scientific_achievement" :rules="rules" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="科研名称">
              <el-input v-model="scientific_achievement.name" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="科研编号">
              <el-input v-model="scientific_achievement.id" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="scientific_achievement.collegeId" :disabled="flag.isDisabled">
                <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="发布时间">
              <el-date-picker v-model="scientific_achievement.beginDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="userId" label="作者">
              <el-input v-model="scientific_achievement.userId" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isTranslate" label="是否翻译">
              <el-radio-group v-model="scientific_achievement.isTranslate">
                <el-radio label="true" :disabled="flag.isDisabled">是</el-radio>
                <el-radio label="false" :disabled="flag.isDisabled">否</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="translateLanguage" label="翻译语种">
              <el-select v-model="scientific_achievement.translateLanguage" :disabled="flag.isDisabled || scientific_achievement.isTranslate!='true'">
                <el-option v-for="option in translateLanguage" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="scientific_achievement.firstDiscipline" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="scientific_achievement.discipline">
                <el-radio label="science" :disabled="flag.isDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="flag.isDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workType" label="研究类别">
              <el-select v-model="scientific_achievement.workType" :disabled="flag.isDisabled">
                <el-option v-for="option in workType" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workSource" label="项目来源">
              <el-select v-model="scientific_achievement.workSource" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in workSource" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; width: 1480px;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="margin: 10px; float: left; width: 1480px;" prop="information" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="scientific_achievement.information" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; text-align: center; width: 1820px; margin-top: 20px;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('scientific_achievement')" color="primary">
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
      'flag',
      "collegeInfo", //学院信息
      "firstDisciplineProp", //第一学科
      "levelProp", //科研级别
      "sortProp", //科研分类
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
        loading: false,
        scientific_achievement: {
          id: null, //科研编号
          name: null, //科研题目
          collegeId: '0001', //成果归属
          scientificId: null,
          userId: '1234', //作者
          isTranslate: 'false', //是否翻译
          translateLanguage: null, //翻译语种
          beginDate: null,
          firstDiscipline: null, //一级学科
          discipline: null, //学科门类
          characters: null, //研究类别
          workSource: null, //科研来源
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
        ],
        collegeId: [],
        firstDiscipline: [], //一级学科内容
        level: [], //科研级别
        sort: [], //科研分类
        workSource: [
          '项目来源1', '项目来源2'
        ]
      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.scientific_achievement = this.TableRow;
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
        this.loading = true;
        //改成string格式
        var proString = this.scientific_achievement;
        // 用户成员
        var sendUser = Global.methods.getUser(this.users, this.scientific_achievement);
        var usersString = JSON.stringify(sendUser);
        
        var token = localStorage.getItem('token');
        this.axios.defaults.headers.common["Authorization"] = token;
        // 进行数据和后端交互
        if (this.notDisabled) {
          console.log("科研表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/achievements/scientific",
              proString
            )
            .then((response) => {
              console.log(response.data);
              console.log("科研表单  request  over");
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
        } else {
          console.log("科研表单申报  request begin:  ");
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/achievements/scientific", proString)
            .then((response) => {
              console.log(response);
              console.log("科研表单  request  over");
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
        this.flag.isDisabled = false;
      },
      canMakesure(formName) {
        //判断能否提交，必须全部填写
        if (this.isSubmit) {
          this.isSubmit = Global.methods.canMakesure(this, formName, this.scientific_achievement);
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
