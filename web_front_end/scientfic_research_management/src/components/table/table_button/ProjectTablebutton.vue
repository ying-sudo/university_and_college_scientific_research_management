<template>
  <div>
    <el-row type="flex" justify="end">
      <el-col :span="5" ><ProjectButton></ProjectButton> </el-col>
      <!-- <el-col :span="4" ><BantchDelete :multiSelect="multiSelect"></BantchDelete></el-col> -->
      <!-- <el-col :span="4"><ExportTable></ExportTable></el-col> -->
    </el-row>
  </div>
</template>

<script>
import ProjectButton from "@/components/forms/buttons/ProjectButton";
import BantchDelete from "@/components/table/batch_delete/BantchDelete";
// import ExportTable from '@/components/table/export_table/ExportTable';
import ExportTable from '@/components/table/export_table/TestExcel';


export default {
  components: {
    ProjectButton,
    BantchDelete,
    ExportTable,
  },

  props: ["multiSelect"],
};
</script>

<style scoped>
.el-col {
  padding-bottom: 20px;
}
</style>