<template>

  <div id="login" style="height: 916px; background-color: #00D6B2; padding: 20px;">

    <!-- 四川师范大学图标 -->
    <div style="float: left; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); background-color: #76d1b6; width: 100%;">
      <img src="../../assets/images/LoginLogo.png" style="width: 296px; float: left; margin: 15px 100px;" alt="">
    </div>

    <!-- 图片 -->
    <div style="background-color: #000000; float: left; width: 300px; height: 300px;  margin-top: 100px; margin-left: 500px;">

    </div>

    <!-- 登录界面 -->
    <div style="background-color: white; margin:0px auto; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
                width: 450px; height: 650px; border-radius: 15px; float: right; margin: 80px;">

      <div style="background-color: #f1f100; border-radius: 15px;">
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
          <el-divider></el-divider>
        </div>
      </div>

      <!-- 输入框 -->
      <div style="text-align: center;">
        <mu-container>
          <i class="el-icon-user" style="font-size: 35px; padding: 5px;"></i>
          <mu-text-field v-model="username" label="用户名" label-float help-text="用户名为学工号" :rules="usernameRules"></mu-text-field><br />
          <i class="el-icon-lock" style="font-size: 35px; padding: 5px;"></i>
          <mu-text-field v-model="password" label="密码" :action-icon="visibility ? 'visibility_off' : 'visibility'"
            :action-click="() => (visibility = !visibility)" :type="visibility ? 'text' : 'password'" label-float
            help-text="请输入密码"></mu-text-field><br />
        </mu-container>
      </div>

      <!-- 错误警告 -->
      <div style="width: 400px; margin: 0 auto;">
        <mu-alert color="red" @delete="alarm = false" delete v-if="alarm" transition="mu-scale-transition" style=" height: 30px;">
          <mu-icon left value="warning"></mu-icon> {{error_text}}
        </mu-alert>
      </div>

      <!-- 图形验证码 -->
      <div style="margin: 20px; text-align: center;">
        <el-popover ref="verifyFlag" placement="top" width="400" trigger="click">
          <!-- 验证码 -->
          <div>
            <Verify :key="reload" @success="verify_success" @error="verify_error" :type="5" font-size="20px"></Verify>
          </div>
          <!-- 验证按钮 -->
          <el-button slot="reference" class="ButtonStyle" v-if="!verify_flag">点击验证</el-button>
          <el-button slot="reference" class="ButtonStyle" v-if="verify_flag" style="color: #0B97C4; font-size: 15px;"><i
              class="el-icon-success" style="margin-right: 5px;"></i>验证成功</el-button>
        </el-popover>
      </div>

      <!-- 按钮 -->
      <div style="text-align: center; padding: 10px;">
        <mu-button color="teal" @click="login()" class="ButtonStyle">登录</mu-button>
        <div style="padding: 10px;"></div>
        <mu-button color="secondary" @click="init()" class="ButtonStyle">忘记密码</mu-button>
      </div>
    </div>
  </div>
</template>

<script>
  import Verify from '@/addModules/vue2-verify'

  export default {
    components: {
      Verify
    },
    data() {
      return {
        username: '',
        password: '',
        verify_flag: true,
        visibility: false,
        alarm: false,
        error_text: '',
        reload: '',
        usernameRules: {
          validate: (val) => !!val,
          message: '请输入学工号'
        },
        passwordRules: {
          validate: (val) => !!val,
          message: '请填写密码'
        }
      }
    },
    methods: {
      login() {
        if (this.verify_flag) {
          // this.axios.post('http://192.168.1.106:9999/mangerSys/login',{
          //     this.username, this.password
          //   },function(data){
          //     console.log(data);
          //   }
          // );
          this.axios({
            method: 'post',
            url: 'http://192.168.1.106:9999/mangerSys/user/login',
            data: {
              id: this.username,
              password: this.password
            }
          }).then((res) =>  {
            // 存储
            localStorage.setItem("id", res.data.id);
            // 检索
            console.log(localStorage.getItem("id"));
          });
          
          this.axios.post("http://192.168.1.106:9999/mangerSys/user/login", {'id': }).then(
            (response) => {
              this.headerLists = response.data.data.headerLists;
              console.log(response);
            },
            (response) => {
              console.log("header error");
            }
          );
          

          var resultCode = -1; //返回值，进行登录判断
          if (this.username === 'dqf') {
            if (this.password === '123') {
              resultCode = 0;
            }
          }
          if (resultCode == 0) { //成功
            this.login_success();
          } else if (resultCode == -1) { //失败
            this.login_failing('用户名或密码错误');
          } else {
            this.login_failing('出现了不可避免的错误，请稍后再试');
          }
        } else {
          this.login_failing('请通过验证');
        }
      },
      login_success() {
        const loading = this.$loading();
        setTimeout(() => {
          loading.close();
          this.$router.push('./home');
        }, 500);
      },
      login_failing(error_text) {
        this.error_text = error_text;
        this.alarm = true;
        this.verify_flag = false;
        this.reload = new Date().getTime();
      },
      init() {
        this.$router.push('/initPWD');
      },
      verify_success() {
        this.verify_flag = true;
        this.$refs.verifyFlag.showPopper = false;
      },
      verify_error() {
        this.verify_flag = false;
      }
    }
  };
</script>

<style>
  @import 'http://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.css';

  .ButtonStyle {
    border-radius: 8px;
    width: 180px;
  }
</style>
