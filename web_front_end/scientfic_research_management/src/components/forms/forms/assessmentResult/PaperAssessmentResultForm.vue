<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="论文成果考核" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="paper_achievement.id" :sort="'paper_achievement'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="padding: 10px; margin: 0 30px; float: left; width: 1560px;">
          <!-- 左侧框 -->
          <div style="width: 1200px; float: left;">
            <el-form :model="paper_achievement" ref="paper_achievement" :label-position="labelPosition"
              label-width="1000">

              <el-form-item prop="name" class="mu-demo-min-form" label="论文题目">
                <el-input v-model="paper_achievement.name" :disabled="notDisabled"></el-input>
              </el-form-item>

              <el-form-item prop="id" class="mu-demo-min-form" label="论文编号">
                <el-input v-model="paper_achievement.id" :disabled="notDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="magazine" label="发表期刊">
                <el-input v-model="paper_achievement.magazine" :disabled="notDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="beginDate" label="发表时间">
                <el-date-picker v-model="paper_achievement.beginDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                  value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="paperType" label="论文类型">
                <el-input v-model="paper_achievement.paperType" :disabled="notDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="recordId" label="收录号">
                <el-input v-model="paper_achievement.recordId" :disabled="notDisabled"></el-input>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
                <el-radio-group v-model="paper_achievement.discipline">
                  <el-radio label="science" :disabled="notDisabled">理科类</el-radio>
                  <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
                <el-select v-model="paper_achievement.firstDiscipline" :disabled="notDisabled">
                </el-select>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="paperSource" label="项目来源">
                <el-radio-group v-model="paper_achievement.paperSource">
                  <el-radio label="crosswise" :disabled="notDisabled">横向</el-radio>
                  <el-radio label="lengthways" :disabled="notDisabled">纵向</el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item class="mu-demo-min-form" prop="collegeId" label="成果归属">
                <el-select v-model="paper_achievement.collegeId" :disabled="notDisabled">
                </el-select>
              </el-form-item>

              <!-- 表单底部表格 -->
              <UserTable style="float: left; width: 1200px;" v-model='users' :isDisabled="notDisabled"></UserTable>

              <!-- 表单备注 -->
              <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1200px;" prop="information"
                label="详细信息">
                <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea"
                  :rows="5" v-model="paper_achievement.information" :disabled="notDisabled"></el-input>
              </el-form-item>

            </el-form>
          </div>

          <!-- 右侧选择框 -->
         <div style="float: left; margin-left: 30px; width: 300px; height: 678px; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); border-radius: 4px;">
            <div class="select-control-group">
              <div style="font-size: 20px; padding: 2px; text-align: center; ">
                <b>收录情况</b>
              </div>
              <div style="overflow-y: scroll; height: 650px;">
                <mu-flex class="select-control-row" :key="magazineSort[i-1].id" v-for="i in magazineSort.length">
                  <mu-checkbox style="margin: 5px;" :value="magazineSort[i-1].id" v-model="magazineId" :label='magazineSort[i-1].name'
                    :disabled="notDisabled"></mu-checkbox>
                </mu-flex>
              </div>
            </div>
          </div>

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
        notDisabled: true, //部分不能更改的标志
        isSubmit: true, //是否可以提交，需要把值全部填完才能进行提交
        loading: false,
        paper_achievement: { //申报的内容
          id: null, //论文编号
          name: null, //论文题目
          magazine: null, //期刊
          beginDate: null, //发表日期
          paperType: null, //论文类型
          recordId: null, //收录号
          discipline: null, //学科门类
          firstDiscipline: null, //一级学科
          collegeId: '0001', //成果归属
          paperSource: null, //项目来源
          userId: '1234', //作者
          information: null //详细信息

        },
        users: [],
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
      // this.paper_achievement = this.TableRow;
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
