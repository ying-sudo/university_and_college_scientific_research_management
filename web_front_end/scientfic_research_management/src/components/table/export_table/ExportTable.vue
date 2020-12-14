<template>
  <el-button
    type="primary"
    icon="el-icon-download"
    @click="downloadExcel"
    size="medium"
    >导出到execl</el-button
  >
</template>

<script>
import FileSaver from "file-saver";
import XLSX from "xlsx";
export default {
  methods: {
    exportExcel() {
      /* generate workbook object from table */
      var xlsxParam = { raw: true }; // 导出的内容只做解析，不进行格式转换
      var wb = XLSX.utils.table_to_book(
        document.querySelector("#exportTab"),
        xlsxParam
      );

      /* get binary string as output */
      var wbout = XLSX.write(wb, {
        bookType: "xlsx",
        bookSST: true,
        type: "array",
      });
      try {
        FileSaver.saveAs(
          new Blob([wbout], { type: "application/octet-stream" }),
          "统计报表.xlsx"
        );
      } catch (e) {
        if (typeof console !== "undefined") {
          console.log(e, wbout);
        }
      }
      return wbout;
    },
    //下载excel
    downloadExcel() {
      this.$confirm("该操作将数据导出为excel文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.axios.get("/api/table_data/project").then((res) => {
            let code = res.data.code;
            // console.log("res:");
            // console.log(res.data);
            if (code === "1") {
              this.exportExcel();
              this.$message.success("文件导出成功");
            } else {
              this.$message.warning("文件导出失败,请稍后再试");
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作",
          });
        });
    },
  },
};
</script>

<style>
</style>