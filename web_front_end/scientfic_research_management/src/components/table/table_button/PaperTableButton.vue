<template>
  <div>
    <el-row>
        <el-col :span="8"><PaperButton></PaperButton> </el-col>
      <el-col :span="8"><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import PaperButton from "@/components/forms/PaperButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    PaperButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>

<style>
</style>