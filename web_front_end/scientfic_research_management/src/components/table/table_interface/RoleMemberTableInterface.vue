<template>
  <div>
    <CommonsTableTemplate :itemOptions="itemOptions" :tableData="tableData"></CommonsTableTemplate>
    <!-- <p>{{this.RoleMemberMap.get(this.$route.params.roleid)}}</p> -->
    <!-- <p>{{this.$route.params.roleid}}</p> -->
    <!-- .get(this.$route.params.roleid) -->
    <!-- <p>{{this.tableData}}</p> -->
  </div>
</template>

<script>
import CommonsTableTemplate from "@/components/table/table_template/CommonsTableTemplate";
import { getRoleMemberIconMap } from "@/components/table/table_map/RoleMemberTableMap.js";
export default {
  data() {
    return {
      itemOption: "",
      RoleMemberMap: [],
      itemOptions: [],
    //   tableData:[],
    };
  },
  components: {
    CommonsTableTemplate,
  },
  props:["tableData"],
  methods: {
    getTableItem: function (itemOption) {
        // console.log("itemOption:"+itemOption);
      this.axios
        .get(
          `http://localhost:8080/static/table/item_option/role_management_table/${itemOption}`
        )
        .then((res) => {
          this.itemOptions = res.data;
        });
    },

  },
  created: function () {
    this.RoleMemberMap = getRoleMemberIconMap();
    this.itemOption = this.RoleMemberMap.get(this.$route.params.roleid);
    this.getTableItem(this.itemOption);
    console.log("this.tableData interface:"+this.tableData);
  },

};
</script>

<style>
</style>