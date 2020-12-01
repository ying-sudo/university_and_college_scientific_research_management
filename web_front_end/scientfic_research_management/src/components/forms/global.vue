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
      canMakesure(project) { //判断数据是否已经编写完成
        for (var key in project) {
          if (project[key] == '') {
            alert(key + '  的数据没有填写！！！');
            return false;
          }
        }
        return true;
      },
      emptyValue(project) {   //对数据进行清空
        for (var key in project) {
          project[key] = null;
        }
      },
      getValue(sour, dir) {
        for (var key in sour) {
          dir[dir.length-1][key] = sour[key];
        }
      },
      getCollegeData(that, url, collegeInfo) { //获得学院数据
        // that.click = true;
        console.log('requrest :   ' + url);
        that.axios.get(url).then(
          (response) => {
            collegeInfo = response.data.data;
            console.log(collegeInfo);
          },
          (response) => {
            console.log("getCollegeData request error");
          }
        );
      },
      getOtherData(firstDiscipline, level, sort) { //获得第一学科，等级，分类的数据
        that.axios
          .get(that.GLOBAL.BASE_URL + "/mangerSys/sort/findAll")
          .then((response) => {
            //console.log(response.data);
            that.firstDiscipline = response.data.data.firstDiscipline;
            // //console.log(response.data.data.firstDiscipline);
            that.level = response.data.data.level;
            // //console.log(response.data.data.level);
            that.sort = response.data.data.sort;
          });
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
      }
    },
  }
</script>
