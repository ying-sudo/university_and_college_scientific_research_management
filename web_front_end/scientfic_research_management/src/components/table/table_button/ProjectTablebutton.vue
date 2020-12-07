<template>
  <div>
    <el-row
      ><el-col :span="8"><ProjectButton></ProjectButton> </el-col>
      <el-col :span="4"><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import ProjectButton from "@/components/forms/buttons/ProjectButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    ProjectButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>

<style>
</style>