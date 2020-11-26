<template>
  <div v-if="this.tableData !== null">
    <SearchBox :tableData="tableData" @changeTable="changeTable">
      <div slot="able_to_add">
        <component :is="new_buttons" :testData01="testData01"></component>
      </div>
    </SearchBox>

    <CommonsTableImpl :tableData="tableDataToChange">
      <!--TableTemplate slot标签挂载点的内容为操作列  -->
      <template slot="table_template_slot" slot-scope="{ row }">
        <component :is="apps" :TableRow="row"></component>
        <!-- <p>{{ row }}</p> -->
        <!-- <p>{{Object.keys(row).length}}</p> -->
      </template>
    </CommonsTableImpl>
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/table_interface/CommonsTableImpl";
import SearchBox from "@/components/search_box/SearchBox";
import { getTableIconMap } from "@/components/table/table_map/OperationIconMap.js";
import { getTableDataMap } from "@/components/table/table_map/TableDataMap.js";
import { getButtonMap } from "@/components/table/table_map/NewButtonsMap.js";

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

    //从后端/mock获取接口表格数据
    getInterface: function (key) {
      this.backEndInterface = this.InterfaceMap.get(key);
      console.log("this.backEndInterface:" + this.backEndInterface);
    },
    getTableData: function (newVal) {
      this.axios.get("/api/table_data").then((res) => {
        let userId = localStorage.getItem("id");
        // this.axios.get(`http://172.20.10.4:9999/${newVal}/${userId}`).then((res) => {
        console.log(res.data.data);
        this.tableData = res.data.data.TableData;
        // this.tableData = res.data.data;
        // console.log(res.data.data.TableData);
      });
    },

    //动态注册操作列按钮
    getIconMapValue: function (key) {
      console.log("key:" + key);
      this.components_name = this.icontableMap.get(key);
      console.log("this.components_name:" + this.components_name);
    },
    registercomponents: function (component_name) {
      this.apps = () =>
        import(
          "@/components/table/table_operation_icon/" + component_name + ".vue"
        );
    },

    //
    getButtonName: function (key) {
      this.buttons_name = this.ButtonsMap.get(key);
      console.log("this.buttons_name:" + this.buttons_name);
    },
    addButtons: function (buttons_name) {
      this.new_buttons = () =>
        import("@/components/forms/" + buttons_name + ".vue");
    },
  },

  created: function () {
    //从后端/mock获取接口表格数据
    this.InterfaceMap = getTableDataMap();
    this.getInterface(this.$route.params.tableKey);
    // console.log("this.InterfaceMap:"+this.InterfaceMap);
    this.getTableData(this.backEndInterface);

    //
    this.ButtonsMap = getButtonMap();
    // console.log("this.ButtonsMap"+this.ButtonsMap);
    this.getButtonName(this.$route.params.tableKey);
    this.addButtons(this.buttons_name);

    //动态注册操作列按钮
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
      this.getIconMapValue(this.$route.params.tableKey);
      this.registercomponents(this.components_name);

      this.getButtonName(this.$route.params.tableKey);
      this.addButtons(this.buttons_name);
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

      // backEndInterface:"mangerSys/project/projects",
      InterfaceMap: [],
      backEndInterface: "",

      //
      ButtonsMap: [],
      buttons_name: "",
      new_buttons: {},

      testData01: "ok??",
    };
  },
};
</script>

<style scoped>
</style>