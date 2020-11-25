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
                <mu-text-field v-model="work_achievement.name" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>
              
              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="著作编号">
                <mu-text-field v-model="work_achievement.id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="出版单位">
                <mu-text-field v-model="work_achievement.publisher" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版社级别">
                <mu-select  v-model="work_achievement.publish_level" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in publish_level" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="著作类别">
                <mu-select  v-model="work_achievement.work_type" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in work_type" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版地">
                <mu-select  v-model="work_achievement.publish_location" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in publish_location" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="ISBN号">
                <mu-text-field v-model="work_achievement.isbn_id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="是否翻译">
                <mu-radio v-model="work_achievement.is_translate" value="true" label="是" :disabled="flag.is_disabled"></mu-radio>
                <mu-radio v-model="work_achievement.is_translate" value="false" label="否" :disabled="flag.is_disabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="翻译语种">
                <mu-select  v-model="work_achievement.translate_language" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in translate_language" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="work_achievement.discipline" value="science" label="理工类" :disabled="flag.is_disabled"></mu-radio>
                <mu-radio v-model="work_achievement.discipline" value="social" label="社科类" :disabled="flag.is_disabled"></mu-radio>
              </mu-form-item>


              <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="work_achievement.begin_date" label="建设时间" label-float full-width landscape
                  :disabled="flag.is_disabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="研究类别">
                <mu-radio v-model="work_achievement.characters" value="basics" label="基础研究" :disabled="flag.is_disabled"></mu-radio>
                <mu-radio v-model="work_achievement.characters" value="apply" label="应用研究" :disabled="flag.is_disabled"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                <mu-select  v-model="work_achievement.first_discipline" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in first_discipline" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="成果归属">
                <mu-select  v-model="work_achievement.college_id" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in college_id" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form" prop="select" label="项目来源">
                <mu-select  v-model="work_achievement.work_source" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in work_source" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <UserTable v-model="flag.is_disabled"></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="work_achievement.information" :disabled="flag.is_disabled"></mu-text-field>
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
        work_achievement: {
          id: '', //著作编号
          name: '', //著作题目
          publisher: '',  //出版单位
          publish_level: '',  //出版社级别
          work_type: '', //著作类别
          publish_location: '', //出版地
          isbn_id: '', //ISBN号
          is_translate: '', //是否翻译
          translate_language: '', //翻译语种
          discipline: '', //学科门类
          begin_date: '', //出版时间
          characters: '', //研究类别
          first_discipline: '', //一级学科
          college_id: '', //成果归属
          work_source: '', //项目来源
          user_id: '', //作者
          information: '' //详细信息
        },
        publish_level: [
          '级别1', '级别2'
        ],
        work_type: [
          '类别1', '类别2'
        ],
        publish_location: [
          '出版地1', '出版地2'
        ],
        translate_language: [
          '翻译语种1', '翻译语种2'
        ],
        first_discipline: [
          '一级学科1', '一级学科2'
        ],
        college_id: [
          '成果归属1', '成果归属2'
        ],
        work_source: [
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
