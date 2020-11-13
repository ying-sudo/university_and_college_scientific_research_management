<template>
  <!-- 表格组件实体，用以传入表格行列数据 -->
  <div>
    <CommonsTableImpl
      :itemOptionsFileName="itemOptionsFileName"
    ></CommonsTableImpl>
    <p>{{table_map.size}}</p>
  </div>
</template>

<script>
import CommonsTableImpl from "@/components/table/commons_table/CommonsTableImpl";
import {getTableMap} from "@/components/table/table_map/TableMap.js";
export default {
  name: "CommonsTableCop",
  data() {
    return {
      table_map:[],
      //页面表格的数据来源
      itemOptionsFileName: "/check_table/TeamCheckTable.json",
    };
  },

  mounted(){
    this.table_map=getTableMap();
  },
  components: {
    CommonsTableImpl,
  },
};
</script>

<style>
</style>