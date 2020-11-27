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
              <mu-form :model="paper_achievement" :label-position="labelPosition" label-width="100">

                <mu-form-item prop="input" class="mu-demo-min-form float_left" label="论文题目">
                  <mu-text-field v-model="paper_achievement.name" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item prop="input" class="mu-demo-min-form float_left" label="论文编号">
                  <mu-text-field v-model="paper_achievement.id" :disabled="flag.isDisabled || notDisabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="发表期刊">
                  <mu-text-field v-model="paper_achievement.magazine" :disabled="flag.isDisabled"></mu-text-field>
                </mu-form-item>

                <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                  <mu-date-input prop="input" v-model="paper_achievement.beginDate" label="发表时间" label-float full-width
                    landscape :disabled="flag.isDisabled || notDisabled" value-format="YYYY-MM-DD"></mu-date-input>
                </mu-col>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="论文类型">
                  <mu-text-field v-model="paper_achievement.paperType" :disabled="flag.isDisabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="input" label="收录号">
                  <mu-text-field v-model="paper_achievement.recordId" :disabled="flag.isDisabled"></mu-text-field>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                  <mu-radio v-model="paper_achievement.discipline" value="science" label="理工类" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                  <mu-radio v-model="paper_achievement.discipline" value="social" label="社科类" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                  <mu-select v-model="paper_achievement.firstDiscipline" :disabled="flag.isDisabled">
                    <mu-option v-for="option,index in firstDiscipline" :key="option" :label="option" :value="option"></mu-option>
                  </mu-select>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="项目来源">
                  <mu-radio v-model="paper_achievement.paperSource" value="crosswise" label="横向" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                  <mu-radio v-model="paper_achievement.paperSource" value="lengthways" label="纵向" :disabled="flag.isDisabled || notDisabled"></mu-radio>
                </mu-form-item>

                <mu-form-item class="mu-demo-min-form" prop="select" label="成果归属">
                  <mu-select v-model="paper_achievement.collegeId" :disabled="flag.isDisabled">
                    <mu-option v-for="option,index in collegeId.name" :key="collegeId.id[index]" :label="option" :value="collegeId.id[index]"></mu-option>
                  </mu-select>
                </mu-form-item>

                <!-- 表单底部表格 -->
                <UserTable v-model='flag.isDisabled'></UserTable>

                <!-- 表单备注 -->
                <mu-form-item style="padding-top: 20px; margin: 10px;" prop="textarea" label="详细信息">
                  <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                    :rows="3" :rows-max="6" v-model="paper_achievement.information" :disabled="flag.isDisabled"></mu-text-field>
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
                <mu-flex class="select-control-row" :key="magazineSort.id[i-1]" v-for="i in magazineSort.id.length">
                  <mu-checkbox :value="magazineSort.id[i-1]" v-model="achievement_magazine.magazineId" :label='magazineSort.name[i-1]'
                    :disabled="flag.isDisabled"></mu-checkbox>
                </mu-flex>
              </div>
            </div>
          </div>
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
        notDisabled: false, //部分不能更改的标志
        isSubmit: true, //是否可以提交，需要把值全部填完才能进行提交
        paper_achievement: { //申报的内容
          id: '', //论文编号
          name: '', //论文题目
          magazine: '', //期刊
          beginDate: '', //发表日期
          paperType: '', //论文类型
          recordId: '', //收录号
          discipline: '', //学科门类
          firstDiscipline: '', //一级学科
          collegeId: '', //成果归属
          paperSource: '', //项目来源
          userId: '', //作者
          information: '' //详细信息
        },
        firstDiscipline: [ //一级学科内容
          '文科', '理科', '计算机科学', '物理', '生物'
        ],
        collegeId: {
          id: [
            1, 2, 3, 4
          ],
          name: [ //成果归属
            '计算机科学', '物电', '生物', '化学'
          ]
        },
        achievement_magazine: { //收录编号表
          achievementId: 'aaaa',
          magazineId: [
            '001', '003', '004'
          ]
        },
        magazineSort: { //编号读取
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
        var proJson = JSON.stringify(this.paper_achievement);
        proJson = JSON.parse(proJson);
        console.log('论文表单  begin:  ');
        this.axios.post(this.GLOBAL.BASE_URL + "/mangerSys/", proJson).then(
          (response) => {
            console.log('论文表单发送返回的请求值' + response.data.resultCode);
            console.log('论文表单  request  over');
          });
        this.closeAlertDialog();
      },
      editForm() {
        this.notDisabled = this.flag.isDisabled;
        this.flag.isDisabled = false;
      }
    },
    components: {
      UserTable
    },
    canMakesure() {
      for (var key in this.paper_achievement) {
        if (this.paper_achievement[key] == '') {
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
  };
</script>

<style>
  .mu-demo-form {
    width: 100%;
    max-width: 700px;
  }

  .mu-demo-min-form {
    width: 100%;
    max-width: 350px;
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
