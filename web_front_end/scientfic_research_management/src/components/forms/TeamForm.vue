<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="团队表单" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>


        <!-- 表单内容 -->
        <div style="float: left; padding: 10px; width: 1520px; margin: 0 140px;">
          <el-form :model="team" ref="team" :rules="rules" :label-position="labelPosition" label-width="1000">
            <el-form-item class="mu-demo-min-form" prop="name" label="团队名称">
              <el-input v-model="team.name" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="id" label="团队编号">
              <el-input v-model="team.id" :disabled="flag.isDisabled || notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="researchDiection" label="研究方向">
              <el-input v-model="team.researchDiection" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="discipline" label="学科门类">
              <el-radio-group v-model="team.discipline">
                <el-radio label="science" :disabled="flag.isDisabled || notDisabled">理工类</el-radio>
                <el-radio label="social" :disabled="flag.isDisabled || notDisabled">社科类</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="foundingTime" label="建设时间">
              <el-date-picker v-model="team.foundingTime" type="date" placeholder="选择日期" :disabled="flag.isDisabled || notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="firstDiscipline" label="一级学科">
              <el-select v-model="team.firstDiscipline" :disabled="flag.isDisabled || notDisabled">
                <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="phone" label="办公电话">
              <el-input v-model="team.phone" :disabled="flag.isDisabled"></el-input>
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
                    <el-form-item v-if="!flag.isDisabled">
                      <el-button type="primary" @click="findUser">查询</el-button>
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
                v-model="team.information" :disabled="flag.isDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="float: left; text-align: center; width: 100%; margin-bottom: 15px;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('team')" color="primary">
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
  import Global from './global.vue';

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
        notDisabled: false,
        isSubmit: false,
        rules: this.GLOBAL.rules,
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
        firstDiscipline: [], //一级学科内容
        level: [], //项目级别
        sort: [], //项目分类
        state: [{
            id: 1,
            name: "进行"
          },
          {
            id: 2,
            name: "结束"
          },
          {
            id: 3,
            name: "延期"
          }
        ],
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
        users: [{
            id: '1',
            name: '1',
            phone: '2q3',
            collegeId: '3q2',
            sex: 'male',
            birthDate: '4qwqwerqwrqrwerqwrqwerqwrqwerqwrqwrer2',
            post: '1sa2',
            email: '123a4'
          },
          {
            id: '2',
            name: '2',
            phone: '23qwe',
            collegeId: '32',
            sex: 'male',
            birthDate: '4qwe2',
            post: '1qwe2',
            email: '12qweqwerqwerqwrqwrqwrqwrqwer34'
          },
          {
            id: '3',
            name: '3',
            phone: '23rq',
            collegeId: '32',
            sex: 'female',
            birthDate: '42',
            post: '1qwerqwererqerqwrqwerqwr2',
            email: '123qwer4'
          },
        ]

      };
    },
    created: function() {
      if (this.flag.isDisabled) {
        this.team = this.TableRow;
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
        this.loading = true;
        //改成string格式
        var proString = JSON.stringify(this.team);
        proString = JSON.parse(proString);
        // 用户成员
        var sendUser = Global.methods.getUser(this.users, this.team);
        var usersString = JSON.stringify(sendUser);
        // 进行数据和后端交互
        if (this.notDisabled) {
          console.log("项目表单修改  request begin:  ");
          this.axios
            .put(
              this.GLOBAL.BASE_URL +
              "/mangerSys/team/teams/" +
              this.project.id,
              proString
            )
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("项目表单  request  over");
              this.loading = false;
              if (response.data.resultCode == 0) {
                Global.methods.message_success(this, '申报成功');
                this.closeAlertDialog();
              } else {
                Global.methods.message_warning(this, '请检查信息是否填写完整正确');
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        } else {
          console.log("项目表单申报  request begin:  ");
          this.axios
            .put(this.GLOBAL.BASE_URL + "/mangerSys/team", proString)
            .then((response) => {
              console.log(response.data.resultCode);
              console.log("项目表单  request  over");
              this.loading = false;
              if (response.data.resultCode == 0) {
                Global.methods.message_success(this, '申报成功');
                this.closeAlertDialog();
              } else {
                Global.methods.message_warning(this, '请检查信息是否填写完整正确');
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        }
      },
      editForm() {
        Global.methods.editForm(this.flag);
      },
      canMakesure(formName) {
        //判断能否提交，必须全部填写
        this.isSubmit = Global.methods.canMakesure(this, formName, this.team);
        if (this.isSubmit) {
          this.makesure();
        }
      },
      findUser() {
        this.axios.post(this.GLOBAL.BASE_URL + "/mangerSys/user/selectOne", {data:this.user.id}, {headers: {'Content-Type' : "application/json"}})
        .then((response) => {
          console.log(this.user.id);
          console.log('test');
          console.log(response.data);
          if (response.data.resultCode == 0) {
            Global.methods.getValueOne(response.data.data, this.user);
            this.team.userId = this.user.id;
          } else {
            Global.methods.message_error(this, '服务器错误，请稍后再试！');
          }

          console.log('用户请求 over  ');

        })
        .catch((error) => {
          Global.methods.message_error(this, '服务器错误，请稍后再试！');
        });
      },
    },
    components: {
      UserTable,
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
