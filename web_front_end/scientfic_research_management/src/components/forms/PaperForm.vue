<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="1250px" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlertPaper">
        <div class="mu-dialog-title">
          论文成果
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <!-- 关闭按钮 -->
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="padding: 10px;">

          <!-- 左侧框 -->
          <div style="float: left; overflow-y: scroll; width: 800px; height: 650px;">
            <mu-container>
              <mu-form :model="paper_achievement" class="mu-demo-form" :label-position="labelPosition" label-width="100">
                <mu-form-item prop="input" label="论文题目">
                  <mu-text-field v-model="paper_achievement.name" :disabled="flag.is_disabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="发表期刊">
                  <mu-text-field v-model="paper_achievement.magazine" :disabled="flag.is_disabled"></mu-text-field>
                </mu-form-item>

                <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                  <mu-date-input prop="input" v-model="paper_achievement.begin_date" label="发表时间" label-float
                    full-width landscape :disabled="flag.is_disabled"></mu-date-input>
                </mu-col>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="论文类型">
                  <mu-text-field v-model="paper_achievement.paper_type" :disabled="flag.is_disabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="收录号">
                  <mu-text-field v-model="paper_achievement.record_id" :disabled="flag.is_disabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                  <mu-radio v-model="paper_achievement.discipline" value="science" label="理工类" :disabled="flag.is_disabled"></mu-radio>
                  <mu-radio v-model="paper_achievement.discipline" value="social" label="社科类" :disabled="flag.is_disabled"></mu-radio>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                  <mu-select v-model="paper_achievement.first_discipline" filterable :disabled="flag.is_disabled">
                    <mu-option v-for="option,index in first_discipline" :key="option" :label="option" :value="option"></mu-option>
                  </mu-select>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="项目来源">
                  <mu-radio v-model="paper_achievement.paper_source" value="crosswise" label="横向" :disabled="flag.is_disabled"></mu-radio>
                  <mu-radio v-model="paper_achievement.paper_source" value="lengthways" label="纵向" :disabled="flag.is_disabled"></mu-radio>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form" prop="select" label="成果归属">
                  <mu-select v-model="paper_achievement.college_id" filterable :disabled="flag.is_disabled">
                    <mu-option v-for="option,index in college_id" :key="option" :label="option" :value="option"></mu-option>
                  </mu-select>
                </mu-form-item>

                <!-- 表单底部表格 -->
                <UserTable v-model='flag.is_disabled'></UserTable>

                <!-- 表单备注 -->
                <mu-form-item style="padding-top: 20px; margin: 10px;" prop="textarea" label="详细信息">
                  <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                    :rows="3" :rows-max="6" v-model="paper_achievement.information" :disabled="flag.is_disabled"></mu-text-field>
                </mu-form-item>

              </mu-form>
            </mu-container>
          </div>

          <!-- 右侧选择框 -->
          <div style="float: right; width: 300px; height: 650px; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); border-radius: 4px;">
            <div class="select-control-group">
              <div style="font-size: 20px; padding: 2px; text-align: center; ">
                <b>收录情况</b>
              </div>
              <div style="overflow-y: scroll; height: 600px;">
                <mu-flex class="select-control-row" :key="magazine_sort.id[i-1]" v-for="i in magazine_sort.id.length">
                  <mu-checkbox :value="magazine_sort.id[i-1]" v-model="achievement_magazine.magazine_id" :label='magazine_sort.name[i-1]'
                    :disabled="flag.is_disabled"></mu-checkbox>
                </mu-flex>
              </div>
            </div>
          </div>
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
        paper_achievement: { //申报的内容
          id: 'aaaa', //论文编号
          name: 'ssss', //论文题目
          magazine: '期刊', //期刊
          begin_date: undefined, //发表日期
          paper_type: '类型', //论文类型
          record_id: '收录好', //收录号
          discipline: 'science', //学科门类
          first_discipline: '文科', //一级学科
          college_id: 'sssss', //成果归属
          paper_source: 'lengthways', //项目来源
          user_id: 'sswwwe', //作者
          information: '详细信息' //详细信息
        },
        first_discipline: [ //一级学科内容
          '文科', '理科', '计算机科学', '物理', '生物'
        ],
        college_id: [ //成果归属
          '计算机科学', '物电', '生物', '化学'
        ],
        achievement_magazine: { //收录编号表
          achievement_id: 'aaaa',
          magazine_id: [
            '001', '003', '004'
          ]
        },
        magazine_sort: { //编号读取
          id: [
            '001', '002', '003', '004', '005'
          ],
          name: [
            '1', '2', '3', '4', '5'
          ]
        }
      };
    },
    methods: {
      closeAlertDialog() {
        this.flag.openAlertPaper = false;
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
    max-width: 600px;
  }

  .mu-demo-min-form {
    width: 100%;
    max-width: 300px;
    padding-right: 40px;
    padding-left: 10px;
  }

  .float_left {
    float: left;
  }

  .select-control-row {
    padding: 8px 0;
  }

  .select-control-group {
    margin: 16px 0;
  }
</style>
