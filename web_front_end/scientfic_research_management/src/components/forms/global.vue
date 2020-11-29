<script>
  export default {
    methods: {
      openAlertDialog(flag, isDisabled) { //打开组件
        if (isDisabled) {
          flag.isDisabled = isDisabled;
        }
        flag.openAlert = true;
        console.log('asdfdsfasdfasd');
      },
      closeAlertDialog(flag) {
        flag.openAlert = false;
      },
      editForm(flag) {
        flag.isDisabled = false;
      },
      canMakesure(project) {
        for (var key in project) {
          if (project[key] == '') {
            alert(key + '  的数据没有填写！！！');
            return false;
          }
        }
        return true;
      }
    }
  }
</script>
