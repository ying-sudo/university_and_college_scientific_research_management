// 该组件已经被抛弃
<template>
  <!-- 表格组件实体，用以传入表格行列数据 -->
  <div>
    <CommonsTableImpl
      v-if="this.itemOptionsFileName !== null"
      :itemOptionsFileName="itemOptionsFileName"
    ></CommonsTableImpl>
    <p>{{ table_map.get("/funds") }}</p>
    <!-- <p>{{ itemOptionsFileName }}</p> -->
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/commons_table/CommonsTableImpl";
import { getTableMap } from "@/components/table/table_map/TableMap.js";
export default {
  name: "CommonsTableCop",
  data() {
    return {
      table_map: [],
      //页面表格的数据来源
      // itemOptionsFileName: "/check_table/TeamCheckTable.json",

      itemOptionsFileName: "",
    };
  },

  //URL与json的对应关系
  // mounted() {
  //   this.table_map = getTableMap();
  //   this.itemOptionsFileName= table_map.get("/project");
  // },
  created() {
    this.table_map = getTableMap();
    this.itemOptionsFileName = this.table_map.get(
      "/" + this.$route.params.tableKey
    );
    // this.itemOptionsFileName = "/" + this.$route.params.id;
  },
  components: {
    CommonsTableImpl,
  },
  watch: {
    $route(to, from) {
      // this.loading = true;
      alert(this.$route.params.tableKey);
      this.itemOptionsFileName = this.table_map.get(
        "/" + this.$route.params.tableKey
      );
      // console.log(this.itemOptionsFileName);
    },
  },
};
</script>

<style>
</style>