<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="著作申报" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="work_achievement.id" :sort="'work_achievement'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 1550px; margin: 0 20px; float: left;">
          <el-form :model="work_achievement" ref="work_achievement" :rules="rules" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="著作题目">
              <el-input v-model="work_achievement.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="著作编号">
              <el-input v-model="work_achievement.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publisher" label="出版单位">
              <el-input v-model="work_achievement.publisher" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publishLevel" label="出版社级别">
              <el-select v-model="work_achievement.publishLevel" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workType" label="著作类别">
              <el-select v-model="work_achievement.workType" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publishLocation" label="出版地">
              <el-select v-model="work_achievement.publishLocation" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isbnId" label="ISBN号">
              <el-input v-model="work_achievement.isbnId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isTranslate" label="是否翻译">
              <el-radio-group v-model="work_achievement.isTranslate">
                <el-radio label="true" :disabled="notDisabled">是</el-radio>
                <el-radio label="false" :disabled="notDisabled">否</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="translateLanguage" label="翻译语种">
              <el-select v-model="work_achievement.translateLanguage" :disabled="notDisabled || work_achievement.isTranslate!='true'">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="work_achievement.discipline">
                <el-radio label="science" :disabled="notDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="建设时间">
              <el-date-picker v-model="work_achievement.beginDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isDisabled" label="研究类别">
              <el-radio-group v-model="work_achievement.characters">
                <el-radio label="basics" :disabled="notDisabled">基础研究</el-radio>
                <el-radio label="apply" :disabled="notDisabled">应用研究</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="work_achievement.firstDiscipline" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="work_achievement.collegeId" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workSource" label="项目来源">
              <el-select v-model="work_achievement.workSource" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; width: 1480px;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="margin: 10px; float: left; width: 1480px;" prop="information" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="work_achievement.information" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; text-align: center; width: 1820px; margin-top: 20px;">
          <div>
            <mu-button @click="canMakesure('work_achievement')" color="primary">
              返回&nbsp;&nbsp;
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
  import ScoreTable from '@/components/forms/global/ScoreTable.vue'

  export default {
    props: [
      'flag',
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
        loading: false,
        work_achievement: {
          id: null, //著作编号
          name: null, //著作题目
          publisher: null, //出版单位
          publishLevel: null, //出版社级别
          workType: null, //著作类别
          publishLocation: null, //出版地
          isbnId: null, //ISBN号
          isTranslate: 'false', //是否翻译
          translateLanguage: null, //翻译语种
          discipline: null, //学科门类
          beginDate: null, //出版时间
          characters: null, //研究类别
          firstDiscipline: null, //一级学科
          collegeId: '0001', //成果归属
          workSource: null, //项目来源
          userId: '1234', //作者
          information: null //详细信息
        },
        users: [
          //参加人员
        ],
      };
    },
    created: function() {
      this.work_achievement = this.TableRow;
      this.notDisabled = true;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
    },
    components: {
      UserTable,
      ScoreTable,

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
