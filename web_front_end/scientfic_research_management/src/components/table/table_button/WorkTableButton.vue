<template>
  <div>
    <el-row>
        <el-col :span="8"><WorkButton></WorkButton> </el-col>
      <el-col :span="8"><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import WorkButton from "@/components/forms/buttons/WorkButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    WorkButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>

<style scoped>
.el-col {
  padding: 10px;
  padding-bottom: 20px;
}
</style>