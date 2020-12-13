<script>
  export default {
    methods: {

      openAlertDialog(flag, isDisabled) { //打开组件
        if (isDisabled) {
          flag.isDisabled = isDisabled;
        }
        flag.openAlert = true;
      },
      closeAlertDialog(flag) { //关闭组件
        flag.openAlert = false;
      },
      editForm(flag) {
        flag.isDisabled = false;
      },

      canMakesure(that, formName, project) {
        //判断数据是否已经编写完成
        var isSubmit = null;
        that.$refs[formName].validate((valid) => {
          if (valid) {
            console.log('project submit');
            isSubmit = true;
            return true;
          } else {
            console.log('projtct error submit!!');
            isSubmit = false;
            return false;
          }
        });
        console.log('is:    ' + isSubmit);
        return isSubmit;
      },
      canMakesureUser(user) {
        for (var key in user) {
          if (user[key] == null) {
            return false;
          }
        }
        return true;
      },

      judgeDate(begin, end) {
        //判断end日期要大于begin日期
        var judge = true;
        if (end) {
          console.log('begin:  ' + new Date(begin).getTime());
          console.log('end:  ' + new Date(end).getTime());
          judge = new Date(end).getTime() > new Date(begin).getTime();
          if (!judge) {
            alert('结束日期要大于开始日期!!');
          }
        }
        return judge;
      },

      emptyValue(project) {
        //对数据进行清空
        for (var key in project) {
          project[key] = null;
        }
      },
      // judgeValue(key, data) {
      //   if (data != '') {
      //     var reg = /^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
      //     var r = reg.test(data);

      //     if (r) {
      //       console.log('success:   ' + data);
      //     } else {
      //       console.log('error:   ' + data);
      //     }
      //   }
      // },


      //sour，原来的值 sour赋值给dir
      //dir 目标值
      getValueOne(sour, dir) { //一维
        for (var key in sour) {
          dir[key] = sour[key];
        }
      },
      getValue(sour, dir) { //二维
        for (var key in sour) {
          dir[dir.length - 1][key] = sour[key];
        }
      },

      getUser(users, project) {
        // 用户
        var i = 0;
        var sendUser = [];
        var userId;
        var id;
        while (users[i]) {
          userId = users[i].id;
          id = project.id;
          sendUser.push(users[i]);
          //用赋值的方式对用户的id和项目id进行赋值
          sendUser[i].userId = userId;
          sendUser[i].id = id;
          //删除用户输入的名字和学院
          delete sendUser[i].name;
          delete sendUser[i].collegeName;
          i++;
        }

        return sendUser;
      },
      getAllData() {
        var len = arguments.length;
        for (var i = 0; i < len; i++) {
          if (!arguments[i]) {
            console.log('false');
            return false;
          }
        }
        console.log('true');
        return true;
      },

      // 消息提示
      message_control(value, that, msg) {
        //消息提示控制，使用value来判断为什么消息类型
        if (value == 0) {
          this.message_success(that, msg);
        } else if (value == -1) {
          this.message_warning(that, msg);
        } else {
          this.message_error(that, msg);
        }
      },
      message_success(that, msg) {
        //成功消息
        that.$message({
          showClose: true,
          message: msg,
          type: 'success'
        });
      },
      message_warning(that, msg) {
        //警告消息
        that.$message({
          showClose: true,
          message: msg,
          type: 'warning'
        });
      },
      message_error(that, msg) {
        //错误消息
        that.$message({
          showClose: true,
          message: msg,
          type: 'error'
        });
      },

      getCollegeData(that, collegeInfo) {
        //从后端获取表单需要的所有学院的信息，并返回
        var token = localStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;
        that.axios.get(that.GLOBAL.BASE_URL + "/mangerSys/colleges").then(
          (response) => {
            that.GLOBAL.collegeInfo = response.data.data;
            console.log('college begin:   ');

console.log(response.data.data)
            for (var i=0; i<response.data.data.length; i++) {
              console.log(response.data.data[i].id);
              var empty = {};
              collegeInfo.push(empty);

              // for (var key in response.data.data[i]) {
              //   console.log(response.data.data[i][key]);
              // }

              this.getValueOne(response.data.data[i], collegeInfo[i]);
            }
            console.log(collegeInfo);
            return;
          });
      },
      getOtherData(that, sort) {
        var token = localStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;

        //从后端获取表单需要的所有其他选择的信息，并返回
        that.axios.get(that.GLOBAL.BASE_URL + "/mangerSys/sorts").then(
          (response) => {
            console.log(response.data);
            return response.data;
          })
      }
    },
  }
</script>
