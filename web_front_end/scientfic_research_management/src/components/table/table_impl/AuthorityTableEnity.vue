<template>
  <div v-if="this.tableData !== null">
    <SearchBox :tableData="tableData" @changeTable="changeTable"></SearchBox>
    <CommonsTableImpl :tableData="tableDataToChange">
      <!--TableTemplate slot标签挂载点的内容为操作列  -->
      <el-table-column
        slot="table_template_slot"
        fixed="right"
        label="操作"
        width="200"
        align="center"
      >
        <AuthorityTableIcon></AuthorityTableIcon>
      </el-table-column>
    </CommonsTableImpl>
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/table_interface/CommonsTableImpl";
import SearchBox from "@/components/search_box/SearchBox";
import AuthorityTableIcon from "@/components/table/table_operation_icon/AuthorityTableIcon";
export default {
  components: {
    CommonsTableImpl,
    SearchBox,
    AuthorityTableIcon,
  },
  methods: {
    //子组件修改父组件的tableDataToChange
    changeTable: function (Tables) {
      console.log("changeTable work");
      this.tableDataToChange = Tables;
    },

    getTableData: function () {
      this.axios.get("/api/table_data").then((res) => {
        this.tableData = res.data.data.TableData;
        console.log(res.data.data.TableData);
      });
    },
  },

  created: function () {
    this.getTableData();
  },
  watch: {
    tableData: function (newVal, oldVal) {
      //   console.log("tableDataToChange is changed");
      this.tableDataToChange = this.tableData;
    },
  },
  data() {
    return {
      //返回到表格中的数据
      tableData: [],
      tableDataToChange: [],
    };
  },
};
</script>

<style scoped>
</style>