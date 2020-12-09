<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="科研申报" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="scientific_achievement.id" :sort="'scientific_achievement'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 1550px; float: left; margin: 0 30px;">
          <el-form :model="scientific_achievement" ref="scientific_achievement" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="科研名称">
              <el-input v-model="scientific_achievement.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="科研编号">
              <el-input v-model="scientific_achievement.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="scientific_achievement.collegeId" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="发布时间">
              <el-date-picker v-model="scientific_achievement.beginDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="userId" label="作者">
              <el-input v-model="scientific_achievement.userId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="isTranslate" label="是否翻译">
              <el-radio-group v-model="scientific_achievement.isTranslate">
                <el-radio label="true" :disabled="notDisabled">是</el-radio>
                <el-radio label="false" :disabled="notDisabled">否</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="translateLanguage" label="翻译语种">
              <el-select v-model="scientific_achievement.translateLanguage" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="scientific_achievement.firstDiscipline" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="scientific_achievement.discipline">
                <el-radio label="science" :disabled="notDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workType" label="研究类别">
              <el-select v-model="scientific_achievement.workType" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="workSource" label="项目来源">
              <el-select v-model="scientific_achievement.workSource" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; width: 1480px;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="margin: 10px; float: left; width: 1480px;" prop="information" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="scientific_achievement.information" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <div style="text-align: center; float: left; text-align: center; width: 1820px; margin-top: 20px;">
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
        notDisabled: true,
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
        users: [
          //参加人员
        ],
      };
    },
    created: function() {
      this.scientific_achievement = this.TableRow;
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
