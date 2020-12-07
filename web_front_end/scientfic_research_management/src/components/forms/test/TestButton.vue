<template>
  <el-tooltip
    effect="light"
    content="test"
    placement="bottom-end"
    :open-delay="500"
  >
    <el-button
      icon="el-icon-view"
      type="text"
      @click="openAlertDialog"
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
    openAlertDialog: function () {
      console.log(this.testData01);
    },
  },
};
</script>

<style>
</style>
