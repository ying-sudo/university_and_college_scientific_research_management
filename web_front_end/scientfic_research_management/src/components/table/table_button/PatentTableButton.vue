<template>
  <div>
    <el-row type="flex" justify="end">
        <el-col :span="8"><PatentButton></PatentButton> </el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import PatentButton from "@/components/forms/buttons/PatentButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";

export default {
  components: {
    PatentButton,
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