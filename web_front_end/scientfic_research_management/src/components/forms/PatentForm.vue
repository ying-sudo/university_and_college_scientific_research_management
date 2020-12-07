<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="专利产品" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 1520px; float: left; margin: 0 150px;">
          <el-form :model="patent_achievement" ref="patent_achievement" :rules="rules" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="专利名称">
              <el-input v-model="patent_achievement.name" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="专利编号">
              <el-input v-model="patent_achievement.id" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="patentType" label="专利类型">
              <el-select v-model="patent_achievement.patentType" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in patentType" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="patentRange" label="专利范围">
              <el-select v-model="patent_achievement.patentRange" :disabled="flag.isDisabled">
                <el-option v-for="option in patentRange" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="patent_achievement.collegeId" :disabled="flag.isDisabled">
                <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="state" label="专利状态">
              <el-select v-model="patent_achievement.state" :disabled="flag.isDisabled">
                <el-option v-for="option in state" :key="option.id" :label="option.name" :value="option.id"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="applicationDate" label="申请日期">
              <el-date-picker v-model="patent_achievement.applicationDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="applicationId" label="申请编号">
              <el-input v-model="patent_achievement.applicationId" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publicDate" label="公开日期">
              <el-date-picker v-model="patent_achievement.publicDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publicId" label="公开编号">
              <el-input v-model="patent_achievement.publicId" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="impowerDate" label="授权日期">
              <el-date-picker v-model="patent_achievement.impowerDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="impowerId" label="授权编号">
              <el-input v-model="patent_achievement.impowerId" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1500px;" prop="information"
              label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="3"
                v-model="patent_achievement.information" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; width: 1820px;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('patent_achievement')" color="primary">
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
        rules: this.GLOBAL.rules,
        loading: false,
        users: [],
        patent_achievement: {
          id: null, //专利编号
          name: null, //名称
          patentType: null, //专利类型
          patentRange: null, //专利范围
          collegeId: null, //成果归属
          state: null, //专利状态
          applicationId: null, //申请编号
          applicationDate: null, //申请日期
          publicId: null, //公开编号
          publicDate: null, //公开日期
          impowerId: null, //授权编号
          impowerDate: null, //授权日期
          userId: '1234', //作者
          information: null //详细信息
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
        this.patent_achievement = this.TableRow;
      }
      this.notDisabled = this.flag.isDisabled;
      this.collegeId = this.collegeInfo;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
      makesure() {
        this.loading = true;
        //改成string格式
        var proString = JSON.stringify(this.patent_achievement);
        proString = JSON.parse(proString);
        // 用户成员
        var sendUser = Global.methods.getUser(this.users, this.patent_achievement);
        var usersString = JSON.stringify(sendUser);
        // 进行数据和后端交互
        if (this.notDisabled) {
          console.log("专利表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/patent/patents/" +
              this.patent_achievement.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("专利表单  request  over");
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
          console.log("专利表单申报  request begin:  ");
          this.axios
            .put(this.GLOBAL.BASE_URL + "/mangerSys/patentAchievement", proString)
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("专利表单  request  over");
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
        Global.methods.editForm(this.flag);
      },
      canMakesure(formName) {
        //判断能否提交，必须全部填写
        this.isSubmit = Global.methods.judgeDate(this.patent_achievement.applicationDate, this.patent_achievement.publicDate);
        if (this.isSubmit) {
          this.isSubmit = Global.methods.judgeDate(this.patent_achievement.publicDate, this.patent_achievement.impowerDate);
          if (this.isSubmit) {
            this.isSubmit = Global.methods.canMakesure(this, formName, this.patent_achievement);
            if (this.isSubmit) {
              this.makesure();
            }
          }
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
</style>
