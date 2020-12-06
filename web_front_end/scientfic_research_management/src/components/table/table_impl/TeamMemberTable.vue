<template>
  <div>
    <CommonsTableTemplate
      :itemOptions="itemOptions"
      :tableData="tableData"
    ></CommonsTableTemplate>
    <!-- :search="search" -->
    <!-- <p>{{ this.$route.query.TableRow.id }}</p> -->
    <!-- <p>this.itemOptions:{{this.itemOptions}}</p> -->
    <!-- <p>this.tableData:{{this.tableData}}</p> -->
  </div>
</template>

<script>
import CommonsTableTemplate from "@/components/table/table_template/CommonsTableTemplate";
export default {
  data() {
    return {
      tableData: [],
      itemOptions: [],
      itemOptionsFileName: "/team_table/TeamMemberTable.json",
    };
  },
  components: {
    CommonsTableTemplate,
  },
  methods: {
    getTableItem: function () {
      this.axios
        .get(
          `http://localhost:8080/static/table/item_option${this.itemOptionsFileName}`
        ) //必须要加上this
        .then((res) => {
          this.itemOptions = res.data;
        });
    },

    getTableData: function () {
      // this.axios.get("/api/table_data").then((res) => {
      this.axios
        .post(
          `${this.GLOBAL.BASE_URL}/mangerSys/teamMember/${this.$route.query.TableRow.id}`
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