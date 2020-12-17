  <template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="项目考核" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :scoreInfo="scoreInfo"></ScoreTable>

        <!-- 表单内容 -->
        <div style="padding: 10px; margin: 0 20px; float: left; width: 1500px;">
          <!-- <mu-container> -->
          <el-form style="float: left;" :model="project" ref="project" :label-position="labelPosition" label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="项目名称">
              <el-input v-model="project.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="项目编号">
              <el-input v-model="project.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="approvalNumber" label="批准文号">
              <el-input v-model="project.approvalNumber" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="userId" label="负责人学工号">
              <el-input v-model="project.userId" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="所在单位">
              <el-select v-model="project.collegeId" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="一级学科">
              <el-select v-model="project.firstDiscipline" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目级别">
              <el-select v-model="project.level" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="characters" label="项目性质">
              <el-radio-group v-model="project.characters">
                <el-radio label="crosswise" :disabled="notDisabled">横向</el-radio>
                <el-radio label="lengthways" :disabled="notDisabled">纵向</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目状态">
              <el-select v-model="project.state" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="project.discipline">
                <el-radio label="science" :disabled="notDisabled">理科类</el-radio>
                <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="项目分类">
              <el-select v-model="project.sort" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="beginDate" label="立项日期">
              <el-date-picker v-model="project.beginDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" label="结项日期">
              <el-date-picker prop="endDate" v-model="project.endDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="requestFund" label="申请经费">
              <el-input v-model.float="project.requestFund" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="arrivalFund" label="到账经费">
              <el-input v-model.number="project.arrivalFund" :disabled="notDisabled"></el-input>
            </el-form-item>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; " v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="padding-top: 20px; margin-top: 10px; float: left; width: 1500px;" prop="information"
              label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="project.information" :disabled="notDisabled"></el-input>
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
      "flag",
      "TableRow",
    ],
    model: {
      prop: "flag",
      event: "click",
    },
    data() {
      return {
        labelPosition: "top",
        loading: false,
        notDisabled: true,
        project: {
          id: null, //项目编号
          name: null, //项目名称
          userId: null, //负责人
          collegeId: null, //所属学院
          discipline: null, //学科门类
          characters: null, //项目性质
          firstDiscipline: null, //一级学科
          level: null, //项目级别
          sort: null, //项目分类
          beginDate: null, //立项日期
          endDate: null, //结项日期
          requestFund: null, //项目申请经费
          arrivalFund: null, //到账金额
          state: null, //审核状态
          approvalNumber: null, //批准文号
          information: null, //项目信息
          score: null,
        },
        users: [
          //参加人员
        ],
        scoreInfo: {
          id: null,
          score: null,
          sort: 'project',
        },
      };
    },
    created: function() {
      this.project = this.TableRow;
      this.scoreInfo.id = this.project.id;
      this.scoreInfo.score = this.project.score;
      this.notDisabled = true;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        //父子组件传值
        this.$emit("click", this.flag);
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
