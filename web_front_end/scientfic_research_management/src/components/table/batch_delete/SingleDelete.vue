<template>
  <div>
 <el-tooltip
      effect="light"
      content="删除该条日志"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-delete"
        type="text"
        @click="delSelected"
      ></el-button>
    </el-tooltip>
  </div>
</template>

<script>
import { getDeleteMap } from "@/components/table/table_map/DeleteInterfaceMap.js";

export default {

  data() {
    return {
      DeleteMap: [],
      DeleteInter: "",
      reNewURL: this.$route.params.tableKey,
      refresh:"refresh",
    };
  },
  props: ["TableRow"],

  methods: {
    delSelected() {

      this.$confirm("此操作将永久批量删除选择数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.axios
            .delete(`${this.GLOBAL.BASE_URL}/${this.DeleteInter}`, {
              data: this.TableRow,
            })

            //   this.axios.delete("/api/pageList/batchDelete", { data: this.TableRow })
            .then((res) => {
              // console.log("res.data.code:" + res.data.code);
              //   if (res.data.code === "0") {
              if (res.data.resultCode === 0) {
                this.$message.success("删除成功！");
                // this.reload();
                // console.log("refrush");
                this.$emit("refreshTable", this.refresh);
                console.log(this.refresh);
                
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

      //页面刷新功能
      this.route.go(0);
    },
  },

  created() {
    this.DeleteMap = getDeleteMap();
    this.DeleteInter = this.DeleteMap.get(this.$route.params.tableKey);
    console.log("this.DeleteInter:" + this.DeleteInter);
  },
};
</script>

<style>
</style>