<template>

  <!-- 表单底部表格 -->
  <div style="padding: 10px;">
    <div style=" padding-top: 70px;" v-if="!isDisabled">
      <mu-button style="float: right; margin: 10px; font-size: 20px;" @click="openAlertDialog" color="primary">
        添加用户&nbsp;&nbsp;
        <i class="el-icon-s-custom" style="float: right; "></i>
      </mu-button>

      <!-- 添加用户表格 -->
      <div>
        <mu-container>
          <mu-dialog title="成员信息" width="600" :open.sync="flag.openAlert">
            <!-- 团队成员信息 -->
            <div style="padding: 5px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); text-align: center;">
              <el-form :inline="true" ref="user" :rules="rules" :model="user" class="demo-form-inline">
                <el-form-item prop="id" label="学号">
                  <el-input v-model="user.id"></el-input>
                </el-form-item>
                <el-form-item prop="name" label="姓名">
                  <el-input v-model="user.name"></el-input>
                </el-form-item>
                <el-form-item prop="collegeName" label="学院">
                  <el-input v-model="user.collegeName"></el-input>
                </el-form-item>
                <el-form-item prop="contribution" label="贡献">
                  <el-input v-model="user.contribution"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <mu-button slot="actions" @click="canMakesure('user')" flat color="primary">确认</mu-button>
            <mu-button slot="actions" @click="closeAlertDialog" flat color="primary" style="margin: 0 10px;">返回</mu-button>
          </mu-dialog>
        </mu-container>
      </div>
    </div>

    <!-- 所有用户信息表格 -->
    <div style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
      <el-table :data="project_achievement_user" style="width: 100%; font-size: 20px;" max-height="250">
        <el-table-column fixed prop="id" label="学工号" width="300"></el-table-column>
        <el-table-column fixed prop="name" label="姓名" width="300"></el-table-column>
        <el-table-column prop="collegeName" label="单位" width="500"></el-table-column>
        <el-table-column prop="contribution" label="贡献率" width="100"></el-table-column>
        <div v-if="!isDisabled">
          <el-table-column fixed="right" label="操作" width="300">
            <template slot-scope="scope">
              <el-button style="font-size: 20px;" @click.native.prevent="deleteRow(scope.$index)" type="text" size="small">
                移除
              </el-button>
              <el-button style="font-size: 20px;" @click.native.prevent="editRow(scope.$index)" type="text" size="small">
                编辑
              </el-button>
            </template>
          </el-table-column>
        </div>
      </el-table>
    </div>
  </div>

</template>

<script>
  import UserInformation from './UserInformation.vue'
  import Global from './global.vue'

  export default {
    props: [
      'users',
      "isDisabled",
    ],
    model: {
      prop: ['users'],
      event: 'click'
    },
    data() {
      return {
        isSubmit: true, //用户数据是否填写完整
        rules: this.GLOBAL.rules,
        index: null,
        user: {
          id: '123',
          name: '123',
          collegeName: 'qwe',
          contribution: '123'
        },
        flag: {
          openAlert: false,
          isDisabled: false
        },
        project_achievement_user: [{}]
      }
    },
    created: function() {
      this.project_achievement_user = this.users;
    },
    methods: {
      deleteRow(index) { //删除
        this.index = index;
        console.log('删除的id： ' + this.project_achievement_user[index].id);
        this.project_achievement_user.splice(index, 1);
      },
      editRow(index) { //编辑
        this.index = index;
        Global.methods.getValueOne(this.project_achievement_user[index], this.user);
        this.flag.openAlert = true;
      },
      openAlertDialog() { //打开组件
        Global.methods.emptyValue(this.user);
        this.flag.openAlert = true;
      },
      closeAlertDialog() { //关闭组件
        this.flag.openAlert = false;
      },
      makesure() { //确定组件
        //赋值
        // 字符串转数字
        var contribution = this.user.contribution * 1;
        this.user.contribution = contribution;
        this.deleteRow(this.index);
        // 创建一个空的json,放用户
        var empty = {};
        this.project_achievement_user.push(empty);
        Global.methods.getValue(this.user, this.project_achievement_user); //一个一个赋值进行赋值
        this.closeAlertDialog();
      },
      canMakesure(formName) {
        this.isSubmit = Global.methods.canMakesure(this, formName, this.user);
        if (this.isSubmit) {
          this.makesure();
        }
      }
    },
    components: {
      UserInformation
    }
  }
</script>

<style>
</style>
