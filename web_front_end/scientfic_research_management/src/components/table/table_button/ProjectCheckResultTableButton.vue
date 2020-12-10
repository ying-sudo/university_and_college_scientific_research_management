<template>
  <div>
    <el-row>
        <el-col :span="8"><ProjectAssessButton></ProjectAssessButton> </el-col>
      <el-col :span="8"><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import ProjectAssessButton from "@/components/forms/buttons/assessmentResult/ProjectAssessButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    ProjectAssessButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>

<style>
</style>