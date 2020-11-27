<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlertWork">
        <div class="mu-dialog-title">
          著作申报
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 700px; overflow-y: scroll; padding: 10px;">
          <mu-container>
            <mu-form :model="work_achievement" :label-position="labelPosition" label-width="100">
              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="著作题目">
                <mu-text-field v-model="work_achievement.name" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="著作编号">
                <mu-text-field v-model="work_achievement.id" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="出版单位">
                <mu-text-field v-model="work_achievement.publisher" :disabled="flag.isDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版社级别">
                <mu-select v-model="work_achievement.publishLevel" :disabled="flag.isDisabled">
                  <mu-option v-for="option,index in publishLevel" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="著作类别">
                <mu-select v-model="work_achievement.workType" :disabled="flag.isDisabled">
                  <mu-option v-for="option,index in workType" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版地">
                <mu-select v-model="work_achievement.publishLocation" :disabled="flag.isDisabled">
                  <mu-option v-for="option,index in publishLocation" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="ISBN号">
                <mu-text-field v-model="work_achievement.isbnId" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="是否翻译">
                <mu-radio v-model="work_achievement.isTranslate" value="true" label="是" :disabled="flag.isDisabled"></mu-radio>
                <mu-radio v-model="work_achievement.isTranslate" value="false" label="否" :disabled="flag.isDisabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="翻译语种">
                <mu-select v-model="work_achievement.translateLanguage" :disabled="flag.isDisabled">
                  <mu-option v-for="option,index in translateLanguage" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="work_achievement.discipline" value="science" label="理工类" :disabled="flag.isDisabled"></mu-radio>
                <mu-radio v-model="work_achievement.discipline" value="social" label="社科类" :disabled="flag.isDisabled"></mu-radio>
              </mu-form-item>


              <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="work_achievement.beginDate" label="建设时间" label-float full-width
                  landscape :disabled="flag.isDisabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="研究类别">
                <mu-radio v-model="work_achievement.characters" value="basics" label="基础研究" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                <mu-radio v-model="work_achievement.characters" value="apply" label="应用研究" :disabled="flag.isDisabled || notDisabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                <mu-select v-model="work_achievement.firstDiscipline" :disabled="flag.isDisabled || notDisabled">
                  <mu-option v-for="option,index in firstDiscipline" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="成果归属">
                <mu-select v-model="work_achievement.collegeId" :disabled="flag.isDisabled">
                  <mu-option v-for="option,index in collegeId" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form" prop="select" label="项目来源">
                <mu-select v-model="work_achievement.workSource" :disabled="flag.isDisabled || notDisabled">
                  <mu-option v-for="option,index in workSource" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <UserTable v-model="flag.isDisabled"></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="work_achievement.information" :disabled="flag.isDisabled"></mu-text-field>
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
  import UserTable from './UserTable.vue'

  export default {
    props: ['flag'],
    model: {
      prop: 'flag',
      event: 'click'
    },
    data() {
      return {
        labelPosition: 'top',
        notDisabled: false,
        isSubmit: true,
        work_achievement: {
          id: '', //著作编号
          name: '', //著作题目
          publisher: '', //出版单位
          publishLevel: '', //出版社级别
          workType: '', //著作类别
          publishLocation: '', //出版地
          isbnId: '', //ISBN号
          isTranslate: '', //是否翻译
          translateLanguage: '', //翻译语种
          discipline: '', //学科门类
          beginDate: '', //出版时间
          characters: '', //研究类别
          firstDiscipline: '', //一级学科
          collegeId: '', //成果归属
          workSource: '', //项目来源
          userId: '', //作者
          information: '' //详细信息
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
        collegeId: [
          '成果归属1', '成果归属2'
        ],
        workSource: [
          '项目来源1', '项目来源2'
        ]
      };
    },
    methods: {
      closeAlertDialog() {
        this.flag.openAlertWork = false;
        this.$emit('click', this.flag);
      },
      makesure() {

        console.log('专利表单data：   ' + JSON.stringify(this.work_achievement)); //form转json
        // this.project.userId = localStorage.getItem("userid");
        // this.project.userId = "2011000416";
        var proJson = JSON.stringify(this.work_achievement);
        proJson = JSON.parse(proJson);
        // 将金额从string转为double  状态转换

        console.log(proJson);
        console.log("专利表单  request begin:  ");
        this.axios
          .post(this.GLOBAL.BASE_URL + "/mangerSys/project/projects", proJson)
          .then((response) => {
            console.log(response.data.resultCode);
            console.log("专利表单  request  over");
          });
        this.closeAlertDialog();

      },
      editForm() {
        this.notDisabled = this.flag.isDisabled;
        this.flag.isDisabled = false;
      },
      canMakesure() {
        for (var key in this.work_achievement) {
          if (this.work_achievement[key] == '') {
            this.isSubmit = false;
            alert(key + '  的数据没有填写！！！');
            break;
          }
        }
        if (this.isSubmit) {
          console.log('it is ok!!!');
          this.makesure();
        }
      }
    },
    components: {
      UserTable
    }
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
