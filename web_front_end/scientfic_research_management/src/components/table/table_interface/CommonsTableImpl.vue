<template>
  <!--表格实现组件，基本思路：根据当前url地址的参数:tableKey
  从一个map中取出表头数据(json文件) -->

  <div>
    <!-- 调用抽象成CommonsTable标签的公共表格组件 -->
    <CommonsTableTemplate
      v-if="this.tableMapKey !== null"
      :itemOptions="itemOptions"
      :tableData="tableData"
      :search="search"
    >
      <!-- slot中间传递层，真正实现要放到实现类中 -->
      <template slot="table_template_slot" slot-scope="{ row }">
        <slot name="table_template_slot" :row="row"></slot>
      </template>
    </CommonsTableTemplate>
  </div>
</template>

<script>
import CommonsTableTemplate from "@/components/table/table_template/CommonsTableTemplate";
import { getTableMap } from "@/components/table/table_map/TableMap.js";

export default {
  name: "CommonsTableImpl",
  props: ["tableData","search"],
  data() {
    return {
      //存储url参数以及对于表头文件名的map(key: url参数, value: 表头文件名)
      tableMap: [],

      //从map中取到的表头文件的文件名
      itemOptionsFileName: "",

      //map中的key，对于url地址中的参数
      tableMapKey: "",

      //返回到页面中的表头数据
      itemOptions: [],
    };
  },
  components: {
    CommonsTableTemplate,
  },
  methods: {
    //从相应json文件读取表格的列
    getTableItem: function (itemOptionsFileName) {
      this.axios
        .get(
          `http://localhost:8080/static/table/item_option${itemOptionsFileName}`
        ) //必须要加上this
        .then((res) => {
          this.itemOptions = res.data;
        });
    },

    // 从map中取到value(对应表头数据文件的名字)
    getFileName: function (tableMapKey) {
      return this.tableMap.get(tableMapKey);
    },
  },

  created: function () {
    this.tableMap = getTableMap();
    this.tableMapKey = "/" + this.$route.params.tableKey;
    this.itemOptionsFileName = this.getFileName(this.tableMapKey);

    this.getTableItem(this.itemOptionsFileName);
    // this.getTableData("/ProjectTableData.json");
    console.log("Impl执行了create");
  },

  /**
   * 监听url地址参数的变化，
   * 变化的时候从url中取得地址参数，然后从map中取出表头文件名
   * 然后变更data中的数据
   */
  watch: {
    $route(to, from) {
      this.tableMapKey = "/" + this.$route.params.tableKey;
      this.itemOptionsFileName = this.getFileName(this.tableMapKey);
      this.getTableItem(this.itemOptionsFileName);

      console.log("tableimpl fileName: " + this.itemOptionsFileName);
    },
  },
};
</script>

<style>
</style>