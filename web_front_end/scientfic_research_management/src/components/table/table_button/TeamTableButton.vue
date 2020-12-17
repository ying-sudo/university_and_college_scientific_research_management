<template>
  <div>
    <el-row type="flex" justify="end">
      <el-col :span="8"><TeamButton></TeamButton> </el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import TeamButton from "@/components/forms/buttons/TeamButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    TeamButton,
    BantchDelete,
  },

  props: ["multiSelect"],
};
</script>
<style scoped>
.el-col {
  padding-bottom: 20px;
}
</style>