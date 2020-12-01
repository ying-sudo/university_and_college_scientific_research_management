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
      // getCollegeData(url, collegeInfo) { //获得学院数据
      //   // this.click = true;
      //   console.log('requrest :   ');
      //   console.log(this.GLOBAL.BASE_URL);
      //   this.axios.get(url).then(
      //     (response) => {
      //       console.log('dffdwfad');
      //       collegeInfo = response.data.data;
      //       console.log('college' + collegeInfo);
      //       // this.openAlertDialog();
      //     },
      //     (response) => {
      //       console.log("getCollegeData request error");
      //     }
      //   );
      // },
      // getOtherData(firstDiscipline, level, sort) { //获得第一学科，等级，分类的数据
      //   this.axios
      //     .get(this.GLOBAL.BASE_URL + "/mangerSys/sort/findAll")
      //     .then((response) => {
      //       //console.log(response.data);
      //       this.firstDiscipline = response.data.data.firstDiscipline;
      //       // //console.log(response.data.data.firstDiscipline);
      //       this.level = response.data.data.level;
      //       // //console.log(response.data.data.level);
      //       this.sort = response.data.data.sort;
      //     });
      // },
    },
  }
</script>
