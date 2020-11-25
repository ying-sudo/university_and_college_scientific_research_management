<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlertPatent">
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
                <mu-text-field v-model="patent_achievement.name" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="专利编号">
                <mu-text-field v-model="patent_achievement.id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利类型">
                <mu-select v-model="patent_achievement.patent_type" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in patent_type" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利范围">
                <mu-select v-model="patent_achievement.patent_range" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in patent_type" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="成果归属">
                <mu-select v-model="patent_achievement.college_id" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in patent_type" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="专利状态">
                <mu-select v-model="patent_achievement.state" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in patent_type" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.application_date" label="申请日期" label-float
                  full-width landscape :disabled="flag.is_disabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="申请编号">
                <mu-text-field v-model="patent_achievement.application_id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.public_date" label="公开日期" label-float
                  full-width landscape :disabled="flag.is_disabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="公开编号">
                <mu-text-field v-model="patent_achievement.public_id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-col span="12" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="patent_achievement.impower_date" label="授权日期" label-float
                  full-width landscape :disabled="flag.is_disabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form" prop="input" label="授权编号">
                <mu-text-field v-model="patent_achievement.impower_id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <UserTable v-model='flag.is_disabled'></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px; padding-top: 20px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="patent_achievement.information" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

            </mu-form>
          </mu-container>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center;">
          <div v-if="!flag.is_disabled">
            <mu-button @click="makesure" color="primary">
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
        patent_achievement: {
          id: 'sss', //专利编号
          name: '', //名称
          patent_type: '', //专利类型
          patent_range: '', //专利范围
          college_id: '', //成果归属
          state: '', //专利状态
          application_id: '', //申请编号
          application_date: '', //申请日期
          public_id: '', //公开编号
          public_date: '', //公开日期
          impower_id: '', //授权编号
          impower_date: '', //授权日期
          user_id: '', //作者
          information: '' //详细信息
        },
        patent_type: [
          '类型1', '类型2'
        ],
        patent_range: [
          '范围1', '范围2'
        ],
        college_id: [
          '学院1', '学院2'
        ],
        state: [
          '状态1', '状态2'
        ]
      };
    },
    methods: {
      closeAlertDialog() {
        this.flag.openAlertPatent = false;
        this.$emit('click', this.flag);
      },
      makesure() {
        this.closeAlertDialog();
        window.location.reload(); //重载，刷新页面
      },
      editForm() {
        this.flag.is_disabled = false;
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
