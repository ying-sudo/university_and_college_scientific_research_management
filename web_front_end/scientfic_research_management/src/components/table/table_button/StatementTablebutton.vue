<template>
  <div>
    <el-row type="flex" justify="end">
      <el-col :span="4"><ExportTable></ExportTable></el-col>
    </el-row>
    <!-- <p>{{this.multiSelect}}</p> -->
  </div>
</template>

<script>
import ExportTable from '@/components/table/export_table/TestExcel';
export default {
    
  components: {
      ExportTable
  },

  props: ["multiSelect"],
};
</script>

<style scoped>
.el-col {
  padding-bottom: 20px;
}
</style>