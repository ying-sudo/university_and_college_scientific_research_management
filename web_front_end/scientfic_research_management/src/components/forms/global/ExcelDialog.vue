<template>
  <div>
    <!-- 提示框，下载excel -->
    <!-- <el-button type="primary" @click="sureUrl">
      导出excel文件
      <i class="el-icon-download"></i>
    </el-button>

    <el-dialog title="导出到excel" :visible.sync="dialogVisible" width="25%">
      <div style="font-size: 25px; padding-bottom: 8px;">文件名</div>
      <el-input v-model="downloadName" placeholder="请输入文件名">
        <template slot="append">.xlsx</template>
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="downloadExcel">确 定</el-button>
      </span>
    </el-dialog> -->
  </div>
</template>

<script>
  // import Global from '@/components/forms/global/global.vue'

  // export default {
  //   props: [
  //     "tHeader",
  //     "filterVal",
  //     "tableData",
  //     "excelName",
  //   ],
  //   data() {
  //     return {
  //       dialogVisible: false,
  //       downloadName: null,
  //     }
  //   },
  //   methods: {
  //     sureUrl() {
  //       //确定下载地址
  //       this.downloadName = this.excelName;
  //       this.dialogVisible = true;
  //     },
  //     downloadExcel() {
  //       Global.methods.downloadExcel(this.tHeader, this.filterVal,
  //         this.downloadName, this.tableData);
  //       this.dialogVisible = false;
  //     },
  //   }
  // }
</script>

<style>
  .el-dialog__title {
    font-size: 30px;
  }

  .el-dialog__header {
    padding: 8px;
  }

  .el-dialog__body {
    padding: 8px;
  }
</style>
