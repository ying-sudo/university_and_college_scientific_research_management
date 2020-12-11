<template>
  <div>
    <RoleMemberTableInterface :tableData="tableData"></RoleMemberTableInterface>
  </div>
</template>

<script>
import RoleMemberTableInterface from "@/components/table/table_interface/RoleMemberTableInterface";
export default {
  components: {
    RoleMemberTableInterface,
  },
  data() {
    return {
      tableData: [],
    };
  },
  methods: {
    getTableData: function () {
      this.axios.get("/api/table_data").then((res) => {
        //   this.axios.get( `${this.GLOBAL.BASE_URL}/mangerSys/teamMember/${this.$route.query.TableRow.id}`).then((res) => {
        this.tableData = res.data.data;
        //   console.log(res.data.data);
      });
    },
  },
  created() {
    this.getTableData();
    // console.log("tableData:"+tableData);
  },
};
</script>

<style>
</style>