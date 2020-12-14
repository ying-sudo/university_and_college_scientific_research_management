<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="专利产品" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="patent_achievement.id" :sort="'patent_achievement'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="padding: 10px; width: 1550px; float: left; margin: 0 20px;">
          <el-form :model="patent_achievement" ref="patent_achievement" :label-position="labelPosition"
            label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="专利名称">
              <el-input v-model="patent_achievement.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="专利编号">
              <el-input v-model="patent_achievement.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="patentType" label="专利类型">
              <el-select v-model="patent_achievement.patentType" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="patentRange" label="专利范围">
              <el-select v-model="patent_achievement.patentRange" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
              <el-select v-model="patent_achievement.collegeId" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="state" label="专利状态">
              <el-select v-model="patent_achievement.state" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="applicationDate" label="申请日期">
              <el-date-picker v-model="patent_achievement.applicationDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="applicationId" label="申请编号">
              <el-input v-model="patent_achievement.applicationId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publicDate" label="公开日期">
              <el-date-picker v-model="patent_achievement.publicDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="publicId" label="公开编号">
              <el-input v-model="patent_achievement.publicId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="impowerDate" label="授权日期">
              <el-date-picker v-model="patent_achievement.impowerDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="impowerId" label="授权编号">
              <el-input v-model="patent_achievement.impowerId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1500px;" prop="information"
              label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="3"
                v-model="patent_achievement.information" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center; float: left; width: 1820px;">
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
        loading: false,
        notDisabled: true,
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
          information: null, //详细信息
          score: null,
        },
        scoreInfo: {
          id: null,
          score: null,
          sort: 'patent',
        },
      };
    },
    created: function() {
      this.patent_achievement = this.TableRow;
      this.scoreInfo.id = this.patent_achievement.id;
      this.scoreInfo.score = this.patent_achievement.score;
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
</style>
