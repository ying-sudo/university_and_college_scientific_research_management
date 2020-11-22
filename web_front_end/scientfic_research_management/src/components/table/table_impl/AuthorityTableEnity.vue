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
        <template slot-scope="scope">
          <div>
            <el-button
              icon="el-icon-view"
              type="text"
              @click="handleClick()"
            ></el-button>
            <el-button
              icon="el-icon-share"
              type="text"
              @click="handleClick(scope.row)"
            ></el-button>
            <el-button
              icon="el-icon-delete"
              type="text"
              @click="handleClick(scope.row)"
            ></el-button>
          </div>
        </template>
      </el-table-column>
    </CommonsTableImpl>
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/table_interface/CommonsTableImpl";
import SearchBox from "@/components/search_box/SearchBox";
export default {
  components: {
    CommonsTableImpl,
    SearchBox,
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

    handleClick() {
      this.$router.push("/author");
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
.el-button {
  /* width: 40px; */
  color: #545c64;
  height: 40px;
  padding: 0;
  font-size: 18px;
}
</style>