<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="团队考核" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="team.id" :sort="'team'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="float: left; padding: 10px; width: 1550px; margin: 0 20px;">
          <el-form :model="team" ref="team" :label-position="labelPosition" label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="团队名称">
              <el-input v-model="team.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="团队编号">
              <el-input v-model="team.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="researchDiection" label="研究方向">
              <el-input v-model="team.researchDiection" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="team.discipline">
                <el-radio label="science" :disabled="notDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="foundingTime" label="建设时间">
              <el-date-picker v-model="team.foundingTime" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="team.firstDiscipline" :disabled="notDisabled">
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="phone" label="办公电话">
              <el-input v-model="team.phone" :disabled="notDisabled"></el-input>
            </el-form-item>

            <!-- 团队负责人 -->
            <div style="padding: 2px; float: left; width: 1500px;">
              <div style="font-size: 28px;"><b>团队负责人</b></div>
              <br>
              <div style="width: 1470px; float: left; padding: 5px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
                <el-form :inline="true" :model="team" class="demo-form-inline">
                  <div style="margin: 5px; text-align:">
                    <el-form-item prop="" label="负责人学工号:">
                      <el-input v-model="user.id"></el-input>
                    </el-form-item>
                    <el-form-item prop="" label="姓名:">
                      <el-input v-model="user.name"></el-input>
                    </el-form-item>
                  </div>

                  <div style="float: left; width: 1470px;">
                    <el-form-item class="mu-demo-min-form" prop="collegeId" label="所在单位">
                      <el-input v-model="user.collegeId" disabled></el-input>
                    </el-form-item>

                    <el-form-item class="mu-demo-min-form" prop="user_sex" label="负责人性别">
                      <el-radio-group v-model="user.sex">
                        <el-radio label="male" disabled>男性</el-radio>
                        <el-radio label="female" disabled>女性</el-radio>
                      </el-radio-group>
                    </el-form-item>

                    <el-form-item class="mu-demo-min-form" prop="user_birthDate" label="出生年月">
                      <el-input v-model="user.birthDate" disabled></el-input>
                    </el-form-item>

                    <el-form-item class="mu-demo-min-form" prop="user_post" label="负责人职称">
                      <el-input v-model="user.post" disabled></el-input>
                    </el-form-item>

                    <el-form-item class="mu-demo-min-form" prop="user_phone" label="联系电话">
                      <el-input v-model="user.phone" disabled></el-input>
                    </el-form-item>

                    <el-form-item class="mu-demo-min-form" prop="user_email" label="电子邮箱">
                      <el-input v-model="user.email" disabled></el-input>
                    </el-form-item>
                  </div>
                </el-form>
              </div>
            </div>

            <!-- 表单底部表格 -->
            <UserTable style="float: left; width: 1470px;" v-model='users' :isDisabled="notDisabled"></UserTable>

            <!-- 表单备注 -->
            <el-form-item style="float: left; width: 1470px;" prop="information" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="team.information" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="float: left; text-align: center; width: 100%; margin-bottom: 15px;">
          <div>
            <mu-button @click="closeAlertDialog" color="primary">
              返回&nbsp;&nbsp;
              <i right class="el-icon-upload"></i>
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
        loading: false,
        team: {
          id: '', //编号
          name: '', //名字
          researchDiection: '', //研究方向
          discipline: '', //学科门类
          firstDiscipline: '', //一级学科
          foundingTime: '', //成立时间
          phone: '', //办公电话
          information: '', //团队信息
          userId: '', //负责人
        },
        user: {
          id: '',
          name: '',
          phone: '',
          collegeId: '',
          sex: '',
          birthDate: '',
          post: '',
          email: ''
        },
        users: []

      };
    },
    created: function() {
      this.team = this.TableRow;
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
    font-size: 20px;
  }
</style>
