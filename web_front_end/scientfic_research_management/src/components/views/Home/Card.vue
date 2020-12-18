<template>
  <div style="text-align: left; font-size: 20px;" v-loading="loading">
    <el-card shadow="hover">
      <div style="float: left;">
        <el-avatar :size="80" :src="require('@/assets/images/Logo.jpg')"></el-avatar>
      </div>
      <span style="margin-left: 20px;">
        欢迎您！{{user.name}} {{user.post}}
      </span>
      <br>
      <span style="margin-left: 20px;">
        联系方式：{{user.phone}}
        <br>
        <span style="margin-left: 20px;">
          邮箱：{{user.email}}
        </span>
      </span>
    </el-card>
  </div>
</template>

<script>
  import Global from '@/components/forms/global/global.vue'

  export default {
    data() {
      return {
        user: {
          name: null,
          post: null,
          phone: null,
          sex: null,
          email: null,
        },
        loading: false,
      };
    },
    created: function() {
      this.loading = true;
      this.getUserInformation();
    },
    methods: {
      getUserInformation() {
        var id = sessionStorage.getItem('userId');
        console.log('ss:    ' + id);
        console.log(typeof(id));
        var token = sessionStorage.getItem('token');
        this.axios.defaults.headers.common["Authorization"] = token;
        this.axios.post(this.GLOBAL.BASE_URL + "/mangerSys/user/selectOne", id, {
            headers: {
              'Content-Type': "application/json"
            }
          })
          .then((response) => {
            console.log(response);
            this.loading = false;
            if (response.data.resultCode == 0) {
              // this.user.id = response.data.data.id;
              // this.user.name = response.data.data.name;
              // this.user.phone = response.data.data.phone;
              // this.user.sex = response.data.data.sex;
              // this.user.email = response.data.data.email;
              Global.methods.getValueOne(response.data.data, this.user);
            } else {
              Global.methods.message_error(this, '服务器错误，请稍后再试！');
            }
          })
          .catch((error) => {
            this.loading = false;
            Global.methods.message_error(this, '服务器错误，请稍后再试！');
          });
      }
    }
  }
</script>

<style>

  .el-card__body {
    width: 700px;
  }
</style>
