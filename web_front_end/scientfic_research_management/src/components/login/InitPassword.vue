<template>

  <!-- 登录界面 -->
  <div style="height: 916px; background-color: #ffff00; padding: 2px;">
    <!-- 四川师范大学图标 -->
    <div style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); background-color: #76d1b6; width: 100%;">
      <img src="../../assets/images/LoginLogo.png" style="margin: 15px 100px;" alt="">
    </div>

    <!-- 重置密码界面进度条 -->
    <div class="demo-step-container">

      <!-- 图标 和 文字 和 返回登录界面按钮-->
      <div style="padding: 10px; height: 120px; margin: 0 auto; width: 800px;">
        <div style="float: left;">
          <mu-row justify-content="center">
            <mu-avatar :size="100">
              <img src="../../assets/images/Logo.jpg">
            </mu-avatar>
          </mu-row>
        </div>

        <div style="margin-left: 20px; margin-top: 55px; font-size: 25px; float: left;">
          <b>高校管理系统重置密码</b>
        </div>

        <!-- 返回登录界面按钮位置 -->
        <div style="float: right; margin-top: 60px; font-size: 15px;">
          <a href="" @click="login()"><u>返回登录</u></a>
        </div>
      </div>



      <!-- 重置密码进度条 -->
      <mu-stepper :active-step="activeStep" style="width: 800px; margin: 10px auto;">
        <mu-step>
          <mu-step-label>
            <div style="font-size: 17px;">
              身份验证
            </div>
          </mu-step-label>
        </mu-step>

        <mu-step>
          <mu-step-label>
            <div style="font-size: 17px;">
              设置新密码
            </div>
          </mu-step-label>
        </mu-step>

        <mu-step>
          <mu-step-label>
            <div style="font-size: 17px;">
              完成
            </div>
          </mu-step-label>
        </mu-step>
      </mu-stepper>

      <div class="demo-step-content">
        <template>
          <!-- 第一步 填写账号 -->
          <div v-if="activeStep === 0" style="margin: 15px;">
            <i class="el-icon-user" style="font-size: 35px; padding: 5px;"></i>
            <mu-text-field v-model="username" label="用户名" label-float help-text="用户名为学工号"></mu-text-field><br />


            <i class="el-icon-user" style="font-size: 35px; padding: 5px;"></i>
            <mu-text-field v-model="userID" label="身份证号" label-float help-text="请输入你的身份证号"></mu-text-field><br />

            <!-- 图形验证码 -->
            <div style="text-align: center;">
              <el-popover ref="verifyFlag" placement="top" width="400" trigger="click">
                <!-- 验证码 -->
                <div>
                  <Verify @success="verify_success" @error="verify_error" :type="5" font-size="20px"></Verify>
                </div>
                <!-- 验证按钮 -->
                <el-button slot="reference" class="ButtonStyle" v-if="!verify_flag">点击验证</el-button>
                <el-button slot="reference" class="ButtonStyle" v-if="verify_flag" disabled style="color: #0B97C4; font-size: 15px;"><i
                    class="el-icon-success" style="margin-right: 5px;"></i>验证成功</el-button>
              </el-popover>
            </div>

          </div>
          <!-- 第二步 设置新密码 -->
          <div v-if="activeStep === 1" style="margin: 15px;">
            <i class="el-icon-lock" style="font-size: 35px; padding: 5px;"></i>
            <mu-text-field v-model="password" label="密码" :action-icon="visibility ? 'visibility_off' : 'visibility'"
              :action-click="() => (visibility = !visibility)" :type="visibility ? 'text' : 'password'" label-float
              help-text="请输入你要修改的密码"></mu-text-field><br />
            <i class="el-icon-lock" style="font-size: 35px; padding: 5px;"></i>
            <mu-text-field v-model="isPWD" label="确认密码" :action-icon="visibility ? 'visibility_off' : 'visibility'"
              :action-click="() => (visibility = !visibility)" :type="visibility ? 'text' : 'password'" label-float
              help-text="请再次输入你要修改的密码"></mu-text-field><br />

              <!-- 错误警告 -->
              <div style="width: 400px; margin: 0 auto;">
                <mu-alert color="red" @delete="alarm = false" delete v-if="alarm" transition="mu-scale-transition" style=" height: 30px;">
                  <mu-icon left value="warning"></mu-icon> {{error_text}}
                </mu-alert>
              </div>

          </div>

          <!-- 第三步 完成 -->
          <div v-if="activeStep === 2" style="color: #00D6B2; font-size: 20px; margin: 15px;">
            重置密码完成，点击完成进入登录页面
          </div>

          <!-- 下一步按钮 -->
          <div>
            <mu-button flat class="demo-step-button" :disabled="activeStep !== 1" @click="handlePrev"> 上一步 </mu-button>
            <mu-button class="demo-step-button" color="primary" @click="handleNext"> {{activeStep === 2 ? '完成' : activeStep === 1 ? '确认' : '下一步'}}</mu-button>
          </div>
        </template>
      </div>
    </div>

  </div>

</template>

<script>
  import Verify from '@/addModules/vue2-verify'

  export default {
    data() {
      return {
        username: '',
        userID: '',
        password: '',
        isPWD: '',
        error_text: '',
        alarm: false,
        passwordError: false,
        verify_flag: true,
        activeStep: 0, //步骤
        visibility: false
      }
    },
    computed: {
      finished() {
        return this.activeStep > 3;
      }
    },
    methods: {
      initSure() { //完成重置按钮事件
        const loading = this.$loading();
        setTimeout(() => {
          loading.close();
          this.login();
        }, 500);
      },
      login() { //登录页面
        this.$router.push('./login')
      },
      verify_success() { //验证码
        this.verify_flag = true;
        this.$refs.verifyFlag.showPopper = false;
      },
      verify_error() {
        this.verify_flag = false;
      },
      handlePrev() {
        this.activeStep--;
      },
      login_failing(error_text) {
        this.error_text = error_text;
        this.alarm = true;
        this.verify_flag = false;
        this.reload = new Date().getTime();
      },
      handleNext() { //下一步 步骤条
        if (this.activeStep === 0) { //验证码确认和学号确认
          if (this.verify_flag) {
            console.log('username:   ' + this.username);
            console.log('userID:     ' + this.userID);
            this.activeStep++;
          } else {
            alert('请先通过验证');
          }
        } else if (this.activeStep === 1) { //密码输入
          var firstPWD = this.password;
          var flagPWD = this.isPWD;
          if (firstPWD != '' && flagPWD != '') {
            if (firstPWD === flagPWD) {
              console.log('相等');
              this.passwordError = false;
              
              //这里进行向后端传输，进行判断，是否有错误
              
              
              this.activeStep++;
            } else {
              this.login_failing('不相等');
              console.log('不相等');
              this.passwordError = true;
            }
          } else {
            this.login_failing('密码不能为空');
            console.log('不能为空');
            this.passwordError = true;
          }
        } else if (this.activeStep === 2) { //最后一步，进入登录页面
          this.initSure();
        }
      }
    },
    components: {
      Verify
    }
  };
</script>

<style>
  @import 'http://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.css';

  .ButtonStyle {
    border-radius: 8px;
    width: 180px;
  }

  /* 进度条图标大小控制 */
  .mu-step-label-circle {
    width: 35px;
    height: 35px;
    line-height: 35px;
    font-size: 20px;
  }

  .mu-step-label-icon-container {
    width: 35px;
  }
</style>
