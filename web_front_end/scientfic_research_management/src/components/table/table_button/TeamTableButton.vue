<template>
  <div>
    <el-row>
      <el-col :span="8"><TeamButton></TeamButton> </el-col>

      <el-col :span="8"
        ><BantchDelete :multiSelect="multiSelect"></BantchDelete
      ></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import TeamButton from "@/components/forms/TeamButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    TeamButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>

<style>
</style>