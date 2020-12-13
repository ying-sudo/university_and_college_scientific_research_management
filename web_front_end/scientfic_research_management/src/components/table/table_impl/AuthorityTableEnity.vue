<template>
  <div v-if="this.tableData !== null">
    <SearchBox :tableData="tableData" @changeTable="changeTable">
      <!-- <div slot="able_to_add">
        <component :is="new_buttons" :multiSelect="multiSelect"></component>
      </div> -->
    </SearchBox>

    <component :is="new_buttons" :multiSelect="multiSelect"></component>

    <CommonsTableImpl
      :tableData="tableDataToChange"
      :search="search"
      @deleteSelected="deleteSelected"
    >
      <!--TableTemplate slot标签挂载点的内容为操作列  -->
      <template slot="table_template_slot" slot-scope="{ row }">
        <component :is="apps" :TableRow="row"></component>
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
  data() {
    return {
      //返回到表格中的数据
      tableData: [],
      tableDataToChange: [],

      //第一次加载页面会出现操作列为空的情况
      icontableMap: [],
      components_name: "",
      apps: {},

      //
      InterfaceMap: [],
      backEndInterface: "",

      //
      ButtonsMap: [],
      buttons_name: "",
      new_buttons: {},

      search: "",
      multiSelect: [],
    };
  },
  components: {
    CommonsTableImpl,
    SearchBox,
  },
  methods: {
    //子组件修改父组件的tableDataToChange
    changeTable: function (Tables, search1) {
      // console.log("changeTable work");
      this.tableDataToChange = Tables;
      this.search = search1;
      console.log("search:" + this.search);
    },

    deleteSelected: function (newVal) {
      this.multiSelect = newVal;
      console.log("father select:" + this.multiSelect);
    },

    //从后端/mock获取接口表格数据
    getInterface: function (key) {
      this.backEndInterface = this.InterfaceMap.get(key);   
      console.log("this.backEndInterface:" + this.backEndInterface);
    },
    getTableData: function (newVal) {
      this.axios.get("/api/table_data").then((res) => {
      let userId = localStorage.getItem("userid");
      console.log(userId);
      //  this.axios.defaults.headers.common["Authorization"] = token;
      // this.axios.get(`${this.GLOBAL.BASE_URL}/${newVal}/${userId}`).then((res) => {
          this.tableData = res.data.data;
          console.log("res.data.data:");
          console.log(res.data);
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
        import("@/components/table/table_button/" + buttons_name + ".vue");
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

      console.log("Table Enity watch work");
      // this.InterfaceMap = getTableDataMap();
      this.getInterface(this.$route.params.tableKey);
      // console.log("watch    this.backEndInterface:"+this.backEndInterface);
      this.getTableData(this.backEndInterface);
    },
  },
};
</script>

<style scoped>
</style>
