<template>

  <!-- 表单底部表格 -->
  <div style="padding: 10px;">
    <div style=" padding-top: 70px;" v-if="!isDisabled">
      <mu-button style="float: right; margin: 10px;" @click="openAlertDialog" color="primary">
        添加用户&nbsp;&nbsp;
        <i class="el-icon-s-custom" style="float: right; "></i>
      </mu-button>

      <!-- 添加用户表格 -->
      <div>
        <mu-container>
          <mu-dialog title="人员详细信息" width="570" :open.sync="flag.openAlert">
            <!-- 团队成员信息 -->
            <div style="padding: 5px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); text-align: center;">
              <el-form :inline="true" :model="user" class="demo-form-inline">
                <el-form-item label="学号">
                  <el-input v-model="user.id"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                  <el-input v-model="user.name"></el-input>
                </el-form-item>
                <el-form-item label="学院">
                  <el-input v-model="user.collegeName"></el-input>
                </el-form-item>
                <el-form-item label="贡献">
                  <el-input v-model="user.contribution"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <mu-button slot="actions" @click="canMakesure" flat color="primary">确认</mu-button>
            <mu-button slot="actions" @click="closeAlertDialog" flat color="primary" style="margin: 0 10px;">返回</mu-button>
          </mu-dialog>
        </mu-container>
      </div>
    </div>

    <!-- 所有用户信息表格 -->
    <div style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
      <el-table :data="project_achievement_user" style="width: 100%" max-height="250">
        <el-table-column fixed prop="name" label="姓名" width="120"></el-table-column>
        <el-table-column prop="college_name" label="单位" width="300"></el-table-column>
        <el-table-column prop="arrange" label="排名" width="120"></el-table-column>
        <el-table-column prop="contribution" label="贡献率" width="120"></el-table-column>
        <div v-if="!isDisabled">
          <el-table-column fixed="right" label="操作" width="120">
            <template slot-scope="scope">
              <el-button @click.native.prevent="deleteRow(scope.$index, project_achievement_user)" type="text" size="small">
                移除
              </el-button>
              <el-button @click.native.prevent="editRow(scope.$index, project_achievement_user)" type="text" size="small">
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
    props: ['isDisabled', 'users'],
    model: {
      prop: ['isDisabled', 'users'],
      event: 'click'
    },
    data() {
      return {
        isSubmit: true,
        user: {
          id: '',
          name: '',
          collegeName: '',
          contribution: ''
        },
        flag: {
          openAlert: false,
          isDisabled: false
        },
        project_achievement_user: [{}],
        send_user: [{
          id: 'asd',
          contribution: '23'
        }],
        reload: true
      }
    },
    created: function() {
      this.project_achievement_user = this.users;
    },
    methods: {
      deleteRow(index, rows) { //删除
        console.log('删除的id： ' + this.users[index].id);
        rows.splice(index, 1);
      },
      editRow(index, rows) { //编辑
        this.flag.openAlert = true;
        this.user = this.users[index];
        this.openAlertDialog();
      },
      openAlertDialog() { //打开组件

        Global.methods.openAlertDialog(this.flag, this.isDisabled);

      },
      closeAlertDialog() { //关闭组件
        this.flag.openAlert = false;
        console.log(this.user);

      },
      makesure() { //确定组件
        //赋值
        var userJson = {};
        userJson.id = this.user.id;
        userJson.contribution = this.user.contribution;
        console.log('type:  ' + typeof(this.users));
        this.users.push(userJson);

        console.log('project_achievement_user:       ' + this.users);
        this.reload = new Date().getTime(); //重载改组件
        this.closeAlertDialog();
      },
      canMakesure() {

        this.isSubmit = Global.methods.canMakesure(this.user);

        if (this.isSubmit) {
          this.reload = false;
          // this.reload = true;
          console.log(this.user);
          console.log("it is ok!!!");
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
