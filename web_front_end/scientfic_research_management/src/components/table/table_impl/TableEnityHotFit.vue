<template>
  <div v-if="this.tableData !== null">
    <SearchBox :tableData="tableData" @changeTable="changeTable"></SearchBox>

    <CommonsTableImpl :tableData="tableDataToChange">
      <!--TableTemplate slot标签挂载点的内容为操作列  -->
      <el-table-column
        slot="table_template_slot"
        fixed="right"
        label="操作"
        width="300"
        align="center"
      >
        <component :is="apps"></component>
      </el-table-column>
    </CommonsTableImpl>
    <p>this.$route.params{{ this.$route.params }}</p>
    <!-- <p>{{apps}}</p> -->
    <!-- <p>this.getTableDataMap{{this.getTableDataMap}}</p> -->
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/table_interface/CommonsTableImpl";
import SearchBox from "@/components/search_box/SearchBox";
import { getTableIconMap } from "@/components/table/table_map/OperationIconMap.js";
import { getTableDataMap } from "@/components/table/table_map/TableDataMap.js";

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

    //从后端接口获取表格数据
    getInterface: function (key) {
      this.back_end_interface = this.TableDataMap.get(key);
      console.log("this.back_end_interface:" + this.back_end_interface);
    },
    getTableData: function (interface1) {
      // this.axios.get("/api/table_data").then((res) => {
      this.axios.get(interface1).then((res) => {
        this.tableData = res.data.data.TableData;
        console.log(res.data.data.TableData);
      });
    },

    //动态注册操作列按钮
    getIconMapValue: function (key) {
      console.log("this.components key :" + key);
      this.components_name = this.icontableMap.get(key);
      // console.log("this.components_name:" + this.components_name);
    },
    registercomponents: function (component_name) {
      console.log("this.components_name(in):" + component_name);

      this.apps = () =>
        import(
          "@/components/table/table_operation_icon/" + component_name + ".vue"
        );
    },
  },

  created: function () {
    // this.TableDataMap = getTableDataMap();
    // getInterface(this.$route.params.tableKey);
    // this.getTableData(this.back_end_interface);

    this.icontableMap = getTableIconMap();
    this.getIconMapValue(this.$route.params.tableKey);
    this.registercomponents(this.components_name);
  },

  watch: {
    tableData: function (newVal, oldVal) {
      //   console.log("tableDataToChange is changed");
      this.tableDataToChange = this.tableData;
    },

    $route(to, from) {
      // getInterface(this.$route.params.tableKey);
      // this.getTableData(this.back_end_interface);

      this.getIconMapValue(this.$route.params.tableKey);
      this.registercomponents(this.components_name);
    },
  },

  data() {
    return {
      //返回到表格中的数据
      tableData: [],
      tableDataToChange: [],

      //第一次加载页面会出现操作列为空的情况
      icontableMap: [],
      components_name: "",
      apps: {},

      TableDataMap: [],
      back_end_interface: "",
    };
  },
};
</script>

<style scoped>
</style>