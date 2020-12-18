<template>
  <div>
    <el-row type="flex" justify="end"><el-col :span="4"><el-button @click="$router.back(-1)">返回</el-button></el-col></el-row>

    <CommonsTableTemplate
      :itemOptions="itemOptions"
      :tableData="tableData"
    ></CommonsTableTemplate>

    <!-- <el-button @click="reloadFun">刷新</el-button> -->
    <!-- <p>{{this.$route.query.TableRow.id}}</p> -->
  </div>
</template>

<script>
import CommonsTableTemplate from "@/components/table/table_template/CommonsTableTemplate";
export default {
  inject: ['reload'],
  data() {
    return {
      tableData: [],
      itemOptions: [],
      itemOptionsFileName: "/role_management_table/RoleMemberTable.json",
    };
  },
  components: {
    CommonsTableTemplate,
  },
  methods: {
    reloadFun () {
  		this.reload()
  	},
    getTableItem: function () {
      this.axios
        .get(
          `http://localhost:8080/static/table/item_option${this.itemOptionsFileName}`
        ) //必须要加上this
        .then((res) => {
          this.itemOptions = res.data;
        });
    },

    // /teams/{teamId}/members
    getTableData: function () {
      var token = sessionStorage.getItem("token");
      this.axios.defaults.headers.common["Authorization"] = token;

      // this.axios.get("/api/table_data").then((res) => {
      this.axios
        .get(
          `${this.GLOBAL.BASE_URL}/mangerSys/characters/findUserByCharacter/${this.$route.query.TableRow.id}`
        )
        .then((res) => {
          this.tableData = res.data.data;
          console.log(res.data.data);
        });
    },
  },
  created() {
    this.getTableItem();
    console.log("this.itemOptions:");
    console.log(this.itemOptions);
    this.getTableData();
  },
};
</script>

<style>
</style>