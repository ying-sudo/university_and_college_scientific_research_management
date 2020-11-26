<template>
  <el-tooltip
    effect="light"
    content="论文详情"
    placement="bottom-end"
    :open-delay="500"
  >
    <el-button
      icon="el-icon-view"
      type="text"
      @click="openAlertProjectDialog"
    ></el-button>
  </el-tooltip>
</template>

<script>
export default {
  props: ["testData01"],
  created() {
    console.log(this.testData01);
  },
  methods: {
    openAlertProjectDialog: function () {
      console.log(this.testData01);
    },
  },
};
</script>

<style>
</style>