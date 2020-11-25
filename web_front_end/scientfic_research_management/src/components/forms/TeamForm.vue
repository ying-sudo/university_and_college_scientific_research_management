<template>

  <div>
    <mu-container>
      <!-- 表单头部 -->
      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="flag.openAlertTeam">
        <div class="mu-dialog-title">
          团队
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 700px; overflow-y: scroll; padding: 10px;">
          <mu-container>
            <mu-form :model="team" :label-position="labelPosition" label-width="100">
              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="团队名称">
                <mu-text-field v-model="team.name" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="团队编号">
                <mu-text-field v-model="team.id" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="研究方向">
                <mu-text-field v-model="team.research_diection" :disabled="flag.is_disabled"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="team.discipline" value="science" label="理工类" :disabled="flag.is_disabled"></mu-radio>
                <mu-radio v-model="team.discipline" value="social" label="社科类" :disabled="flag.is_disabled"></mu-radio>
              </mu-form-item>

              <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
                <mu-date-input prop="input" v-model="team.founding_time" label="建设时间" label-float full-width landscape
                  :disabled="flag.is_disabled"></mu-date-input>
              </mu-col>

              <mu-form-item class="mu-demo-min-form" prop="select" label="一级学科">
                <mu-select  v-model="team.first_discipline" :disabled="flag.is_disabled">
                  <mu-option v-for="option,index in first_discipline" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="办公电话">
                <mu-text-field v-model="team.phone" disabled></mu-text-field>
              </mu-form-item>

              <!-- 团队负责人 -->
              <div style="padding: 2px;">
                <div style="font-size: 20px;"><b>团队负责人</b></div>
                <br>
                <div style="padding: 5px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">

                  <div>
                    <div v-if="!flag.is_disabled" style="padding: 5px; margin-top: 5px; text-align: center;">
                      <el-form :inline="true" :model="user" class="demo-form-inline">
                        <el-form-item label="负责人学工号">
                          <el-input v-model="user.id"></el-input>
                        </el-form-item>
                        <el-form-item label="姓名">
                          <el-input v-model="user.name"></el-input>
                        </el-form-item>
                        <el-form-item>
                          <el-button type="primary" @click="findUser">查询</el-button>
                        </el-form-item>
                      </el-form>
                    </div>
                    <div v-else>
                      <mu-form-item class="mu-demo-min-form float_left" prop="input" label="负责人学工号">
                        <mu-text-field v-model="user.id" disabled></mu-text-field>
                      </mu-form-item>

                      <mu-form-item class="mu-demo-min-form float_left" prop="input" label="姓名">
                        <mu-text-field v-model="user.name" disabled></mu-text-field>
                      </mu-form-item>
                    </div>
                  </div>

                  <mu-form-item class="mu-demo-min-form float_left" prop="input" label="所在单位">
                    <mu-text-field v-model="user.college_id" disabled></mu-text-field>
                  </mu-form-item>

                  <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="性别">
                    <mu-radio v-model="user.sex" value="male" label="男" disabled></mu-radio>
                    <mu-radio v-model="user.sex" value="female" label="女" disabled></mu-radio>
                  </mu-form-item>

                  <mu-form-item class="mu-demo-min-form float_left" prop="input" label="出生年月">
                    <mu-text-field v-model="user.birth_date" disabled></mu-text-field>
                  </mu-form-item>

                  <mu-form-item class="mu-demo-min-form float_left" prop="input" label="职称">
                    <mu-text-field v-model="user.post" disabled></mu-text-field>
                  </mu-form-item>

                  <mu-form-item class="mu-demo-min-form float_left" prop="input" label="联系电话">
                    <mu-text-field v-model="user.phone" disabled></mu-text-field>
                  </mu-form-item>

                  <mu-form-item class="mu-demo-min-form" prop="input" label="电子邮箱">
                    <mu-text-field v-model="user.email" disabled></mu-text-field>
                  </mu-form-item>
                </div>
              </div>

              <!-- 表单底部表格 -->
              <UserTable v-model="flag.is_disabled"></UserTable>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="team.information" :disabled="flag.is_disabled"></mu-text-field>
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
        team: {
          id: '', //编号
          name: '', //名字
          research_diection: '', //研究方向
          discipline: '', //学科门类
          first_discipline: '', //一级学科
          founding_time: '', //成立时间
          phone: '', //办公电话
          information: '', //团队信息
          user_id: '', //负责人
        },
        first_discipline: [
          '一级学科1', '一级学科2'
        ],
        user: {
          id: '',
          name: '',
          phone: '',
          college_id: '',
          sex: 'male',
          birth_date: '',
          post: '',
          email: ''
        },
        users: [{
            id: '1',
            name: '1',
            phone: '2q3',
            college_id: '3q2',
            sex: 'male',
            birth_date: '4qwqwerqwrqrwerqwrqwerqwrqwerqwrqwrer2',
            post: '1sa2',
            email: '123a4'
          },
          {
            id: '2',
            name: '2',
            phone: '23qwe',
            college_id: '32',
            sex: 'male',
            birth_date: '4qwe2',
            post: '1qwe2',
            email: '12qweqwerqwerqwrqwrqwrqwrqwer34'
          },
          {
            id: '3',
            name: '3',
            phone: '23rq',
            college_id: '32',
            sex: 'female',
            birth_date: '42',
            post: '1qwerqwererqerqwrqwerqwr2',
            email: '123qwer4'
          },
        ]

      };
    },
    methods: {
      closeAlertDialog() {
        this.flag.openAlertTeam = false;
        this.$emit('click', this.flag);
      },
      makesure() {
        this.closeAlertDialog();
        window.location.reload(); //重载，刷新页面
      },
      editForm() {
        this.flag.is_disabled = false;
      },
      findUser() {
        for (var i in this.users) {
          if (this.user.id === this.users[i].id) {
            if (this.user.name === this.users[i].name) {
              //找到用户，赋值
              for (var item in this.users[i]) {
                this.user[item]  = this.users[i][item];
              }
              return;
            }
          }
        }
        alert("错误！！该用户不存在！！");
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
