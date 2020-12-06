<template>
  <div>
    <el-row>
      <el-col 
        ><el-button type="primary" icon="el-icon-delete" @click="delSelected" size="medium"
          >批量删除</el-button
        ></el-col
      >
    </el-row>
  </div>
</template>

<script>
import { getDeleteMap } from "@/components/table/table_map/DeleteInterfaceMap.js";

export default {
  data() {
    return {
        DeleteMap:[],
        DeleteInter:""
    };
  },
  props: ["multiSelect"],

  methods: {
    delSelected() {
      if (this.multiSelect.length <= 0) {
        this.$message({
          type: "warning",
          message: "请至少勾选一条数据",
          showClose: true,
        });
        return;
      }
      // console.log("this.multiSelect:" + this.multiSelect);

      this.$confirm("此操作将永久批量删除选择数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.axios.delete(
            `${this.GLOBAL.BASE_URL}/${this.DeleteInter}`,
            { data: this.multiSelect }
          )

        //   this.axios.delete("/api/pageList/batchDelete", { data: this.multiSelect })
        .then((res) => {
              // console.log("res.data.code:" + res.data.code);
              console.log("res.data.code:");
              console.log(res.data);
            //   if (res.data.code === "0") {
              if (res.data.resultCode === 0) {
                this.$message.success("批量删除成功！");
                // this.getList();
              } else {
                console.log("fail");
              }
            })
            .catch((err) => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });

      // this.reload(); //页面刷新功能
    },
  },

  created() {
      this.DeleteMap=getDeleteMap();
      this.DeleteInter=this.DeleteMap.get(this.$route.params.tableKey)
      console.log("this.DeleteInter:"+this.DeleteInter);
  },
};
</script>

<style>

</style>