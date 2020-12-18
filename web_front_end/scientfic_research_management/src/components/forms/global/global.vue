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
      getValue(sour, dir) { //二维，最后一个添加
        for (var key in sour) {
          dir[dir.length - 1][key] = sour[key];
        }
      },

      getUser(users, project, category) {
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
          sendUser[i].category = category;
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
          this.message_error(that, msg);
        } else if (value == -2) {
          this.message_error(that, msg);
        } else if (value == -3) {
          this.message_error(that, msg);
        } else {
          this.message_error(that, '出现未知错误！请稍后重试。');
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


      getSelectAllData(that, collegeInfo, otherAll) {
        var token = sessionStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;
        that.axios
          .get(this.GLOBAL.BASE_URL + "/mangerSys/colleges")
          .then( (response) => {

            that.axios
              .get(this.GLOBAL.BASE_URL + "/mangerSys/sorts")
              .then( (response) => {

              })


          })

      },
      getCollegeData(that, collegeInfo) {
        //从后端获取表单需要的所有学院的信息，并返回
        that.axios.get(that.GLOBAL.BASE_URL + "/mangerSys/colleges").then(
          (response) => {
            for (var i = 0; i < response.data.data.length; i++) {
              var empty = {};
              collegeInfo.push(empty);
              this.getValueOne(response.data.data[i], collegeInfo[i]);
            }
            return;
          });
      },
      getOtherData(that, sort) {
        var token = sessionStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;
        //从后端获取表单需要的所有其他选择的信息，并返回
        that.axios.get(that.GLOBAL.BASE_URL + "/mangerSys/sorts").then(
          (response) => {
            console.log(response);
            for (var key in response.data.data) {
              for (var i = 0; i < response.data.data[key].length; i++) {
                sort[key].push(response.data.data[key][i]);
              }
            }

            return;
          })
      },
      
      getFormData(that, i, n, formData) {
        
        if (i.length >= n) {
          return;
        }
        
        var token = sessionStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;
        
        this.axios
          .get(this.GLOBAL.BASE_URL + "/mangerSys/sorts/" + i[n])
          .then( (response) => {
            console.log(i[n] + '  aa  ');
            console.log(response);
            this.getFormData(that, i, ++n, formData);
          })
      },

      //使用不定参数，把所有的值传过来，判断是否为空
      isEmpty() {
        var len = arguments.length;

        for (var i = 0; i < len; i++) {
          if (arguments[i].length == 0) {
            return false;
          }
        }

        return true;
      },

      //下载
      //下载excel文件
      // downloadExcel(tHeader, filterVal, excelName, tableData) {
      //   this.export2Excel(tHeader, filterVal, excelName, tableData);
      // },
      // export2Excel(tHeader, filterVal, excelName, tableData) {
      //   require.ensure([], () => {
      //     const {
      //       export_json_to_excel
      //     } = require('@/lib/excel/Export2Excel.js');
      //     const list = tableData; //把data里的tableData存到list
      //     const data = this.formatJson(filterVal, list);
      //     export_json_to_excel(tHeader, data, excelName); //导出Excel 文件名
      //   })
      // },
      // formatJson(filterVal, jsonData) {
      //   return jsonData.map(v => filterVal.map(j => v[j]))
      // },

      sendUsers(that, sendUser) {

        this.axios.post(this.GLOBAL.BASE_URL + '/mangerSys/sorts/insertUsers', sendUser)
          .then((response) => {
            console.log(response);
          })


        var token = sessionStorage.getItem('token');
        that.axios.defaults.headers.common["Authorization"] = token;
        that.axios
          .post(this.GLOBAL.BASE_URL + "/mangerSys/sorts/insertUsers", sendUser)
          .then((response) => {
            console.log(response);
            if (response.data.resultCode == 0) {} else {}
          })
          .catch((error) => {
            Global.methods.message_error(that, '网络或服务器错误，请稍后重试');
          });
      },

      //获取数组的最大（0），最小（1)和平均值（2），
      getMaxMinAvgByArray(arr) {
        var res = [];
        var sum = 0;
        res[0] = arr[0];
        res[1] = arr[0];

        for (var i = 0; i < arr.length; i++) {
          if (res[0] <= arr[i]) {
            res[0] = arr[i];
          }
          if (res[1] >= arr[i]) {
            res[1] = arr[i];
          }
          sum += arr[i];
        }

        res[2] = sum / arr.length;

        return res;

      }


    },
  }
</script>
