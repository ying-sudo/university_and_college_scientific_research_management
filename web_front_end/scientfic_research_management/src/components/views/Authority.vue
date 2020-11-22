<template>
  <div>
    
  </div>
</template>

<script>

export default {
  data() {
    return {
      checkAll: false,
      checkedItem: [
        "首页",
        "项目",
        "成果",
        "团队",
        "考核结果",
        "统计报表",
        "项目评审",
        "考核",
      ],
      items: itemOptions,
      isIndeterminate: true,
      onLoad: false,
    };
  },
  methods: {
    handleCheckAllChange(val) {
      this.checkedItem = val ? itemOptions : [];
      this.isIndeterminate = false;
      console.log(this.checkedItem);
    },
    handleCheckedItemChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.items.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.items.length;
      console.log(this.checkedItem);
    },
    handleSubmit() {
      // 向服务端提交请求
      this.onLoad = true;

      // 还要根据router中的url修改
      this.$router.push("/home");
    },

    handleGoBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped>
#outer-container {
  text-align: left;
  margin-top: 15px;
}
</style>