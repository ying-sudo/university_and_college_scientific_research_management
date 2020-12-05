<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog title="论文成果" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert">

        <!-- 表单内容 -->
        <div style="padding: 10px;">

          <!-- 左侧框 -->
          <div style="overflow-y: scroll; width: 80%; float: left; height: 810px;">
            <el-form :model="paper_achievement" ref="paper_achievement" :rules="rules" :label-position="labelPosition"
              label-width="1000">

              <el-form-item prop="name" class="mu-demo-min-form" label="论文题目">
                <el-input v-model="paper_achievement.name" :disabled="flag.isDisabled || notDisabled"></el-input>
              </el-form-item>

              <el-form-item prop="id" class="mu-demo-min-form" label="论文编号">
                <el-input v-model="paper_achievement.id" :disabled="flag.isDisabled || notDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="magazine" label="发表期刊">
                <el-input v-model="paper_achievement.magazine" :disabled="flag.isDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="beginDate" label="发表时间">
                <el-date-picker v-model="paper_achievement.beginDate" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="paperType" label="论文类型">
                <el-input v-model="paper_achievement.paperType" :disabled="flag.isDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="recordId" label="收录号">
                <el-input v-model="paper_achievement.recordId" :disabled="flag.isDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
                <el-radio-group v-model="paper_achievement.discipline">
                  <el-radio label="science" :disabled="flag.isDisabled || notDisabled">理科类</el-radio>
                  <el-radio label="social" :disabled="flag.isDisabled || notDisabled">社科类</el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
                <el-select v-model="paper_achievement.firstDiscipline" :disabled="flag.isDisabled">
                  <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option>
                </el-select>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="paperSource" label="项目来源">
                <el-radio-group v-model="paper_achievement.paperSource">
                  <el-radio label="crosswise" :disabled="flag.isDisabled || notDisabled">横向</el-radio>
                  <el-radio label="lengthways" :disabled="flag.isDisabled || notDisabled">纵向</el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
                <el-select v-model="paper_achievement.collegeId" :disabled="flag.isDisabled">
                  <el-option v-for="option in collegeId" :key="option.id" :label="option.name" :value="collegeId.id"></el-option>
                </el-select>
              </el-form-item>

              <!-- 表单底部表格 -->
              <UserTable style="float: left; width: 100%;" v-model='users' :isDisabled="!notDisabled"></UserTable>

              <!-- 表单备注 -->
              <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 98%;" prop="information" label="详细信息">
                <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea"
                  :rows="5" v-model="paper_achievement.information" :disabled="flag.isDisabled"></el-input>
              </el-form-item>

            </el-form>
          </div>

          <!-- 右侧选择框 -->
          <div style="float: right; width: 20%; height: 810px; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); border-radius: 4px;">
            <div class="select-control-group">
              <div style="font-size: 20px; padding: 2px; text-align: center; ">
                <b>收录情况</b>
              </div>
              <div style="overflow-y: scroll; height: 760px;">
                <mu-flex class="select-control-row" :key="magazineSort[i-1].id" v-for="i in magazineSort.length">
                  <mu-checkbox style="margin: 5px;" :value="magazineSort[i-1].id" v-model="magazineId" :label='magazineSort[i-1].name'
                    :disabled="flag.isDisabled"></mu-checkbox>
                </mu-flex>
              </div>
            </div>
          </div>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('paper_achievement')" color="primary">
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
  import Global from './global.vue'

  export default {
    props: [
      'flag',
      "collegeInfo", //学院信息
      "firstDisciplineProp", //第一学科
      "levelProp", //项目级别
      "sortProp", //项目分类
      "TableRow",
    ],
    model: {
      prop: 'flag',
      event: 'click'
    },
    data() {
      return {
        labelPosition: 'top',
        notDisabled: false, //部分不能更改的标志
        isSubmit: true, //是否可以提交，需要把值全部填完才能进行提交
        rules: this.GLOBAL.rules,
        paper_achievement: { //申报的内容
          id: null, //论文编号
          name: null, //论文题目
          magazine: null, //期刊
          beginDate: null, //发表日期
          paperType: null, //论文类型
          recordId: null, //收录号
          discipline: null, //学科门类
          firstDiscipline: null, //一级学科
          collegeId: null, //成果归属
          paperSource: null, //项目来源
          userId: null, //作者
          information: null //详细信息
        },
        users: [],
        firstDiscipline: [],
        collegeId: [],
        magazine: [{
            magazineId: '001',
            magazineName: 'aaaa',
          },
          {
            magazineId: '002',
            magazineName: 'bbbb',
          }
        ],
        magazineId: [
          '001', '003', '004'
        ],
        magazineSort: [{
            id: '001',
            name: '1'
          },
          {
            id: '002',
            name: '2'
          },
          {
            id: '003',
            name: '3'
          },
          {
            id: '004',
            name: '4'
          },
          {
            id: '005',
            name: '5'
          }
        ],
      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.project = this.TableRow;
      }
      this.notDisabled = this.flag.isDisabled;
      this.collegeId = this.collegeInfo;
      this.firstDiscipline = this.firstDisciplineProp;
      this.level = this.levelProp;
      this.sort = this.sortProp;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
      makesure() {
        var proString = JSON.stringify(this.paper_achievement);

        var sendUser = Global.methods.getUser(this.users, this.paper_achievement);
        var usersString = JSON.stringify(sendUser);
        // 进行数据和后端交互
        if (this.notDisabled) {
          console.log("论文表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/paper/papers/" +
              this.paper_achievement.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("论文表单  request  over");
            });
        } else {
          console.log("论文表单申报  request begin:  ");
          this.axios
            .post(this.GLOBAL.BASE_URL + "/mangerSys/paper/papers", {
              project: proString,
              users: usersString,
            })
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("论文表单  request  over");
            });
        }

        this.closeAlertDialog();
      },
      editForm() {
        Global.methods.editForm(this.flag);
      },
      canMakesure(formName) {
        this.isSubmit = Global.methods.canMakesure(this, formName, this.paper_achievement);
        if (this.isSubmit) {
          this.makesure();
        }
      },
    },
    components: {
      UserTable,
    },
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
