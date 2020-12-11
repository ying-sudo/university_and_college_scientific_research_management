<template>
  <!-- 个人考核 -->

  <div>

    <mu-container>
      <!-- 表单头部 -->
      <el-dialog v-loading="loading" title="个人考核详情" class="el-dialog__title" style="font-size: 10px;" fullscreen
        :esc-press-close="false" :overlay-close="false" :visible.sync="flag.openAlert" :modal-append-to-body='false'>

        <!-- 成绩框 -->
        <ScoreTable :flag="flag" :id="user.id" :sort="'user'"></ScoreTable>

        <!-- 表单内容 -->
        <div style="float: left; padding: 10px; width: 1550px; margin: 0 20px;">
          <el-form :model="user" ref="user" :label-position="labelPosition" label-width="1000">

            <el-form-item class="mu-demo-min-form" prop="id" label="学工号">
              <el-input v-model="user.id" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="name" label="姓名">
              <el-input v-model="user.name" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="sex" label="性别">
              <el-radio-group v-model="user.sex">
                <el-radio label="male" :disabled="notDisabled">男性</el-radio>
                <el-radio label="female" :disabled="notDisabled">女性</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="phone" label="电话">
              <el-input v-model="user.phone" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="email" label="电子邮箱">
              <el-input v-model="user.email" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="collegeId" label="学院">
              <el-select v-model="user.collegeId" :disabled="notDisabled">
                <!-- <el-option v-for="option in firstDiscipline" :key="option" :label="option" :value="option"></el-option> -->
              </el-select>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="post" label="职位">
              <el-input v-model="user.post" :disabled="notDisabled"></el-input>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="birthDate" label="出生日期">
              <el-date-picker v-model="user.birthDate" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <el-form-item class="mu-demo-min-form" prop="register" label="注册日期">
              <el-date-picker v-model="user.register" type="date" placeholder="选择日期" :disabled="notDisabled"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>

            <!-- 项目数据表格 -->
            <div>
              个人参加的项目和成果
              计算出每个的分数的总和
            </div>

            <!-- 表单备注 -->
            <el-form-item style="float: left; width: 1470px;" prop="note" label="详细信息">
              <el-input style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" type="textarea" :rows="5"
                v-model="user.note" :disabled="notDisabled"></el-input>
            </el-form-item>

          </el-form>
        </div>

        <!-- 确定按钮 -->
        <div style="float: left; text-align: center; width: 100%; margin-bottom: 15px;">
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
        /*学工号 id
    姓名 name
    性别 sex
    电话 phone
    电子邮箱 email
    学院 collegeId
    职位 post
    出生日期 birthDate
    注册日期 register*/
        user: {
          id: null,
          name: null,
          sex: null,
          phone: null,
          email: null,
          collegeId: null,
          collegeName: null,
          post: null,
          birthDate: null,
          register: null
        },
        projects: [
          {

          }
        ]
      };
    },
    created: function() {
      // this.user = this.TableRow;
      this.notDisabled = true;
    },
    methods: {
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        this.$emit('click', this.flag);
      },
    },
    components: {
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
