<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlert">
        <div class="mu-dialog-title">
          专利产品
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <!-- 关闭按钮 -->
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 650px; overflow-y: scroll; ">
          <mu-container>
            <mu-form :model="patent_achievement" :label-position="labelPosition" label-width="100">
              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="专利名称">
                <mu-text-field v-model="patent_achievement.name" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="专利编号">
                <mu-text-field v-model="patent_achievement.id" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利类型">
                <mu-select v-model="patent_achievement.patentType" :disabled="flag.isDisabled || notDisabled">
                  <mu-option v-for="option in patentType" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利范围">
                <mu-select v-model="patent_achievement.patentRange" :disabled="flag.isDisabled">
                  <mu-option v-for="option in patentRange" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="成果归属">
                <mu-select v-model="patent_achievement.collegeId" :disabled="flag.isDisabled">
                  <mu-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利状态">
                <mu-select v-model="patent_achievement.state" :disabled="flag.isDisabled">
                  <mu-option v-for="option in state" :key="option.id" :label="option.name" :value="option.id"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.applicationDate" label="申请日期" label-float
                  full-width landscape :disabled="flag.isDisabled || notDisabled" value-format="YYYY-MM-DD"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="申请编号">
                <mu-text-field v-model="patent_achievement.applicationId" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.publicDate" label="公开日期" label-float full-width
                  landscape :disabled="flag.isDisabled" value-format="YYYY-MM-DD"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="公开编号">
                <mu-text-field v-model="patent_achievement.publicId" :disabled="flag.isDisabled"></mu-text-field>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.impowerDate" label="授权日期" label-float
                  full-width landscape :disabled="flag.isDisabled" value-format="YYYY-MM-DD"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form" prop="input" label="授权编号">
                <mu-text-field v-model="patent_achievement.impowerId" :disabled="flag.isDisabled"></mu-text-field>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <UserTable v-model='users' :isDisabled="flag.isDisabled"></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px; padding-top: 20px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="patent_achievement.information" :disabled="flag.isDisabled"></mu-text-field>
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
  import Global from './global.vue';

  export default {
    props: [
      'flag',
      "collegeInfo", //学院信息
      "TableRow",
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
        patent_achievement: {
          id: '', //专利编号
          name: '', //名称
          patentType: '', //专利类型
          patentRange: '', //专利范围
          collegeId: '', //成果归属
          state: '', //专利状态
          applicationId: '', //申请编号
          applicationDate: '', //申请日期
          publicId: '', //公开编号
          publicDate: '', //公开日期
          impowerId: '', //授权编号
          impowerDate: '', //授权日期
          userId: '', //作者
          information: '' //详细信息
        },
        patentType: [
          '类型1', '类型2'
        ],
        patentRange: [
          '范围1', '范围2'
        ],
        collegeId: [],
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
        ]
      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.project = this.TableRow;
      }
      this.collegeId = this.collegeInfo;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
      makesure() {
        var proString = JSON.stringify(this.project);
        var usersString = JSON.stringify(this.users);
        console.log(proString);
        if (this.notDisabled) {
          console.log("专利表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/project/projects/" +
              proString.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("专利表单  request  over");
            });
        } else {
          console.log("专利表单申报  request begin:  ");
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/project/projects", {
              project: proString,
              users: usersString,
            })
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("专利表单  request  over");
            });
        }

        this.closeAlertDialog();
      },
      editForm() {
        this.notDisabled = this.flag.isDisabled;
        Global.methods.editForm(this.flag);
      },
      canMakesure() {

        this.isSubmit = Global.methods.canMakesure(this.project); //进行判断能否提交

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
