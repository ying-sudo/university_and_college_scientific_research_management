<template>
<!-- 科研成果列表 -->
  <div>
    <!-- 调用抽象成CommonsTable标签的公共表格组件 -->
    <CommonsTable
      v-if="tableData != null"
      :itemOptions="itemOptions"
      :tableData="tableData"
    >
    </CommonsTable>
  </div>
</template>

<script>
import CommonsTable from "@/components/table/Commons/CommonsTable";
export default {

  data() {
    return {
      //返回到页面中的表格
      itemOptions: [],

      //返回到表格中的数据
      tableData: [],
    };
  },
  components: {
    CommonsTable,
  },
  mounted: function () {
    //从相应json文件读取表格的列
    this.axios
      .get("http://localhost:8080/static/table/item_option/achievement_table/ScientificResearchAchievement.json")
      .then((res) => {
        this.itemOptions = res.data;
      });

    //从相应json文件中读取表格数据
    this.axios
      .get("http://localhost:8080/static/table/table_data/project_table/ProjectTableData.json")
      .then((res) => {
        this.tableData = res.data;
      });
  },
};
</script>

<style>
</style>