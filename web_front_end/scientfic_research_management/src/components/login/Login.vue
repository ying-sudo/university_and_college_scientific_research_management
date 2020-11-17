<template>

  <div id="login" style="height: 100%; background-color: #00D6B2; padding: 20px;">
    <!-- 图标 -->
    <div style="height: 100px; background-color: #00D6B2; margin-top: 100px;">
      <img src="../../assets/images/LoginLogo.png" style="width: 296px; margin-left: 300px;" alt="">
    </div>

    <!-- 登录界面 -->
    <div style="background-color: white; margin:0px auto; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); width: 450px; height: 600px; border-radius: 30px">

      <!-- 图标 -->
      <div style="padding: 10px;">
        <mu-row justify-content="center">
          <mu-avatar :size="100">
            <img src="../../assets/images/Logo.jpg">
          </mu-avatar>
        </mu-row>
      </div>

      <!-- 文字 -->
      <div style="text-align: center; color: #00D6B2; font-size: 25px;">
        <b>高校管理系统登录</b>
      </div>

      <!-- 输入框 -->
      <div style="text-align: center;">
        <mu-container>
          <i class="el-icon-user" style="font-size: 35px; padding: 5px;"></i>
          <mu-text-field v-model="value13" label="用户名" label-float help-text="用户名为学工号"></mu-text-field><br />
          <i class="el-icon-lock" style="font-size: 35px; padding: 5px;"></i>
          <mu-text-field v-model="value14" label="密码" label-float error-text="请输入密码"></mu-text-field><br />
        </mu-container>
      </div>

      <!-- 图形验证码 -->
      <div style="margin: 20px; text-align: center;">
        <el-popover placement="top" width="400" trigger="click">
          <!-- 验证码 -->
          <div>
            <Verify @success="alert('success')" @error="alert('error')" :type="5" font-size="20px"></Verify>
          </div>
          <!-- 验证按钮 -->
          <el-button slot="reference" class="ButtonStyle">点击验证</el-button>
        </el-popover>
      </div>

      <!-- 按钮 -->
      <div style="text-align: center; padding: 10px;">
        <mu-button color="teal" @click="fullscreen()" class="ButtonStyle">登录</mu-button>
        <div style="padding: 10px;"></div>
        <mu-button color="secondary" @click="init()" class="ButtonStyle">忘记密码</mu-button>
      </div>
    </div>
  </div>
</template>

<script>
  import Verify from 'vue2-verify'

  export default {
    // name: "Login",
    components: {
      Verify
    },
    data() {
      return {
        value13: '',
        value14: '',
        visible: false
      }
    },
    methods: {
      fullscreen() {
        const loading = this.$loading();
        setTimeout(() => {
          loading.close();
        }, 1000);
        this.$router.replace('/home');
      },
      alert(text) {
        console.log(text);
      },
      init() {
        this.$router.push('/initPWD')
      }
    }
  };
</script>

<style>
  .ButtonStyle {
    border-radius: 30px;
    width: 180px;
  }
</style>
