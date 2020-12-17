<template>
  <div id="login" style="height: 916px; background-color: #ffffff; padding: 20px">
    <!-- 四川师范大学图标 -->
    <div style="
        float: left;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
        background-color: #E5E9F2;
        width: 100%;
      ">
      <img src="../../assets/images/LoginLogo.png" style="width: 296px; float: left; margin: 15px 100px" alt="" />
    </div>

    <!-- 登录界面 -->
    <div v-loading="loading" style="
        background-color: white;
        margin: 0px auto;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
        width: 450px;
        height: 650px;
        border-radius: 15px;
        float: right;
        margin: 80px;
      ">
      <div style="border-radius: 15px">
        <!-- 图标 -->
        <div style="padding: 10px">
          <mu-row justify-content="center">
            <mu-avatar :size="100">
              <img src="../../assets/images/Logo.jpg" />
            </mu-avatar>
          </mu-row>
        </div>

        <!-- 文字 -->
        <div style="text-align: center; color: #00d6b2; font-size: 25px">
          <b>高校管理系统登录</b>
          <el-divider></el-divider>
        </div>
      </div>

      <!-- 输入框 -->
      <div style="text-align: center">
        <mu-container>
          <i class="el-icon-user" style="font-size: 35px; padding: 5px"></i>
          <mu-text-field v-model="user.username" label="用户名" label-float help-text="用户名为学工号"></mu-text-field><br />
          <i class="el-icon-lock" style="font-size: 35px; padding: 5px"></i>
          <mu-text-field v-model="user.password" label="密码" :action-icon="visibility ? 'visibility_off' : 'visibility'"
            :action-click="() => (visibility = !visibility)" :type="visibility ? 'text' : 'password'" label-float
            help-text="密码"></mu-text-field><br />
        </mu-container>
      </div>

      <!-- 错误警告 -->
<!--      <div style="width: 400px; margin: 0 auto; height: 42px;">
        <mu-alert color="red" @delete="alarm = false" delete v-if="alarm" transition="mu-scale-transition" style="height: 30px">
          <mu-icon left value="warning"></mu-icon> {{ error_text }}
        </mu-alert>
      </div> -->

      <!-- 图形验证码 -->
      <div style="margin: 20px; text-align: center">
        <el-popover ref="verifyFlag" placement="top" width="400" trigger="click">
          <!-- 验证码 -->
          <div>
            <Verify :key="reload" @success="verify_success" @error="verify_error" :type="5" font-size="20px"></Verify>
          </div>
          <!-- 验证按钮 -->
          <el-button slot="reference" class="ButtonStyle" v-if="!verify_flag">点击验证</el-button>
          <el-button slot="reference" class="ButtonStyle" v-if="verify_flag" style="color: #0b97c4; font-size: 15px"><i
              class="el-icon-success" style="margin-right: 5px"></i>验证成功</el-button>
        </el-popover>
      </div>

      <!-- 按钮 -->
      <div style="text-align: center; padding: 10px">
        <mu-button color="teal" @click="login()" class="ButtonStyle">登录</mu-button>
        <div style="padding: 10px"></div>
        <mu-button color="red" @click="init()" class="ButtonStyle">忘记密码</mu-button>
      </div>
    </div>
  </div>
</template>

<script>
  import Verify from '@/addModules/vue2-verify'
  import Global from '@/components/forms/global/global.vue'

  export default {
    components: {
      Verify,
    },
    data() {
      return {
        user: {
          username: null,
          password: null,
        },
        username: "",
        password: "",
        verify_flag: false,
        visibility: false,
        alarm: false,
        error_text: "",
        reload: "",
        loading: false,
      };
    },
    methods: {
      submit() {
        this.login();
      },
      login() {
        this.alarm = false; //close 警告框
        var canLogin = false; //判断是否能够login
        var error_text = ''; //错误文字提示
        if (this.user.username !== '' && this.user.password !== '') {
          //输入了用户名密码
          canLogin = true;
        } else if (this.user.username !== '') {
          //没有输入密码
          canLogin = false;
          error_text = '请输入密码！！';
          Global.methods.message_error(this, error_text);
        } else {
          //没有输入用户名
          canLogin = false;
          error_text = '请输入用户名！！';
          Global.methods.message_error(this, error_text);
        }
        // canLogin = true;
        if (canLogin) {
          //输入了用户名和密码，进行验证码确认
          if (this.verify_flag) {
            //开始登录的后端请求

            //进行表单格式
            // let formData = new FormData();
            // for (var key in this.user) {
            //   formData.append(key, this.user[key]);
            // };

            this.loading = true; //打开加载组件
            // var college = Global.methods.getCollegeData(this);
            // console.log(college);
            // console.log('college end:   ');
            //请求表单选择数据
            // this.getCollegeData();
            // this.getOtherData();
            // console.log(this.user);
            //判断用户名，密码是否错误
            this.axios({
                method: "post",
                url: this.GLOBAL.BASE_URL + "/mangerSys/login",
                data: this.user
              }).then(
                (response) => {
                  // var homeJson = JSON.stringify(response.data.data[0].authority);
                  // var homeJson = JSON.parse(homeJson);
                  var resultCode = -2; //返回值，进行登录判断
                  resultCode = response.data.resultCode;
                  console.log(response.data.resultMsg);

                  //关闭组件
                  this.loading = false;
                  if (resultCode == 0) {
                    //成功
                    // 存储  userid
                    sessionStorage.setItem("userId", this.user.username);
                    //存放token
                    sessionStorage.setItem("token", response.data.resultMsg);
                    // 检索
                    this.login_success();
                  } else if (resultCode == -1) {
                    //失败
                    this.login_failing("用户名或密码错误");
                    Global.methods.message_error(this, error_text);
                  } else {
                    //后端返回值不是0，-1 其他原因
                    this.login_failing("服务器错误，请稍后再试");
                    Global.methods.message_error(this, error_text);
                  }
                })
              .catch((error) => {
                //请求错误，关闭加载
                this.loading = false;
                // this.login_failing("出现了不可避免的错误，请稍后再试");
                Global.methods.message_error(this, "出现了不可避免的错误，请稍后再试");
              });
          } else {
            // this.login_failing("请通过验证");
            Global.methods.message_error(this, "请先通过验证");
          }
        }
      },
      //注册
      init() {
        this.$router.push('./initPWD');
      },
      //验证码
      verify_success() {
        this.verify_flag = true;
        this.$refs.verifyFlag.showPopper = false;
      },
      verify_error() {
        this.verify_flag = false;
      },
      //登录
      login_success() {
        this.$router.push('./home');
      },
      login_failing(error_text) {
        this.error_text = error_text;
        this.alarm = true;
      },
      //获取表单选择数据
      // getCollegeData() {
      //   this.axios.get(this.GLOBAL.BASE_URL + "/mangerSys/college/findAll").then(
      //     (response) => {
      //       this.GLOBAL.collegeInfo = response.data.data;
      //     });
      // },
      // getOtherData() {
      //   this.axios
      //     .get(this.GLOBAL.BASE_URL + "/mangerSys/sort/findAll")
      //     .then((response) => {
      //       this.GLOBAL.firstDiscipline = response.data.data.firstDiscipline;
      //       this.GLOBAL.level = response.data.data.level;
      //       this.GLOBAL.sort = response.data.data.sort;
      //     });
      // },
    },
    created() {
      //回车登录
      let that = this;
      document.onkeypress = function(e) {
        var keyCode = document.all ? event.keyCode : e.which;
        //判断是否是在登录页面
        if (that.$route.path == "/login" && keyCode == 13) {
          that.login();
          return;
        }
      };
    },
  };
</script>

<style>
  @import "http://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.css";

  .ButtonStyle {
    border-radius: 8px;
    width: 180px;
  }
</style>
