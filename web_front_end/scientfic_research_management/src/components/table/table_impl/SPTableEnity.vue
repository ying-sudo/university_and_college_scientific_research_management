<template>
  <div v-if="this.tableData !== null">
    <SearchBox :tableData="tableData" @changeTable="changeTable"></SearchBox>

    <!--@deleteInput="deleteInput"  -->
    <CommonsTableImpl :tableData="tableDataToChange"></CommonsTableImpl>
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

    //从相应json文件中读取表格数据
    getTableData: function (fileName) {
      this.axios
        .get("http://localhost:8080/static/table/table_data/" + fileName)
        .then((res) => {
          this.tableData = res.data;
        });
    },

    // deleteInput: function (Tables) {
    //   console.log("deleteInput work");
    //   this.tableDataToChange = Tables;
    // },
  },

  created: function () {
    this.getTableData("/ProjectTableData.json");
  },
  watch: {
    tableData: function (newVal, oldVal) {
      console.log("tableDataToChange is changed");
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

<style>
</style>