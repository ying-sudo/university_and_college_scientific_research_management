<template>
  <div>
    <el-row
      ><el-col :span="8"><ScientificButton></ScientificButton> </el-col>
      <el-col :span="4"><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import ScientificButton from "@/components/forms/buttons/ScientificButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    ScientificButton,
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