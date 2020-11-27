<template>

  <!-- 团队成员 -->
  <div style="padding: 2px;">
    <div style="font-size: 20px;"><b>团队负责人</b></div>
    <br>
    <div style="padding: 5px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">

      <div>
        <div v-if="!flag.isDisabled" style="padding: 5px; margin-top: 5px; text-align: center;">
          <el-form :inline="true" :model="users" class="demo-form-inline">
            <el-form-item label="负责人学工号">
              <el-input v-model="users.id"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="users.name"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="findusers">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <!--        <div v-else>
          <mu-form-item class="mu-demo-min-form float_left" prop="input" label="负责人学工号">
            <mu-text-field v-model="users.id" disabled></mu-text-field>
          </mu-form-item>

          <mu-form-item class="mu-demo-min-form float_left" prop="input" label="姓名">
            <mu-text-field v-model="users.name" disabled></mu-text-field>
          </mu-form-item>
        </div> -->
      </div>

    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        flag: {
          disabled: false
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
        ],
      };
    },

    methods: {
      findusers() {
        for (var i in this.users) {
          if (this.users.id === this.users[i].id) {
            if (this.users.name === this.users[i].name) {
              //找到用户，赋值
              // this.team.usersId = this.users.id;
              console.log(this.users[i]);
              for (var item in this.users[i]) {
                this.users[item] = this.users[i][item];
              }
              return;
            }
          }
        }
        alert("错误！！该用户不存在！！");
      }
    }
  }
</script>

<style>
</style>
