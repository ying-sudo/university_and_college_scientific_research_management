<template>
  <!--表格组件抽象接口，进一步抽象表格组件模板，只暴露一个用以传入表格行列数据的接口  -->
  <div>
    <!-- 调用抽象成CommonsTable标签的公共表格组件 -->
    <CommonsTableTemplate
      v-if="itemOptionsFileName != null"
      :itemOptions="itemOptions"
      :tableData="tableData"
    >
    </CommonsTableTemplate>
    <!-- <p>{{itemOptionsFileName}}</p> -->
  </div>
  
</template>

<script>
import CommonsTableTemplate from "@/components/table/commons_table/CommonsTableTemplate";
export default {
  name:'CommonsTableImpl',
  //  
  data() {
    return {
      //返回到页面中的表格
      itemOptions: [],

      //返回到表格中的数据
      tableData: [],
    };
  },
  components: {
    CommonsTableTemplate,
  },
  props: ['itemOptionsFileName'],

  mounted: function () {
    //从相应json文件读取表格的列
    this.axios
      .get(
        `http://localhost:8080/static/table/item_option${this.itemOptionsFileName}`
      ) //必须要加上this
      .then((res) => {
        this.itemOptions = res.data;
      });

    //从相应json文件中读取表格数据
    this.axios
      .get(
        "http://localhost:8080/static/table/table_data//ProjectTableData.json"
      )
      .then((res) => {
        this.tableData = res.data;
      });
  },
};
</script>

<style>
</style>

<template>
  <!--表格实现组件，基本思路：根据当前url地址的参数:tableKey
  从一个map中取出表头数据(json文件) -->
  <div>
    <!-- 调用抽象成CommonsTable标签的公共表格组件 -->
    <CommonsTableTemplate
      v-if="this.tableMapKey !== null"
      :itemOptions="itemOptions"
      :tableData="tableData"
    >
    </CommonsTableTemplate>
    <!-- <p>{{itemOptionsFileName}}</p> -->
  </div>