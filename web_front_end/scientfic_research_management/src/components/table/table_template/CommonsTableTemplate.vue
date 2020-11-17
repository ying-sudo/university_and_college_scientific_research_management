<template>
  <div v-if="this.tableDataList !== null">
    <!--表格组件模板，负责实现一个只有表格元素，没有任何数据的组件  -->

    <!-- @data:数据列的来源 
     @width:table的宽度 
     @max-height:列的最大高度 -->
    <el-table
      :data="tableDataList"
      fit
      highlight-current-row
      style="width: 100%"
      size="mini"
    >
      <!-- @item:表中的每一列  
         @:key: 第几列
         @label:每一列的标签
         @prop:列名
         @scope.row:从tableData中获取一行的数据
         @width:每一列的宽度-->
      <el-table-column
        v-for="item in itemOptions"
        width="150"
        :key="item.id"
        :label="item.label"
        :prop="item.prop"
        align="center"
      >
        <!-- @scope.row:每一行的数据-->
        <template slot-scope="scope">
          <span>{{ scope.row[item.prop] }}</span>      
        </template>
      </el-table-column>

      <!-- 在TableTemplate中留下一列供父组件修改的列插槽，将该组件的作用域延迟到父组件编译，
      父组件对应标签内的所有内容将代替子组件的<slot>标签及它的内容 -->
      <slot name="table_template_slot"></slot>
    </el-table>
    
    <!-- @totalRows 传入总数据量
         @currentPage 当前页码
         @pageSize 单页数据量  -->
    <Pagination
      :totalRows="tableData.length"
      :currentPage="currentPage"
      :pageSize="pageSize"
      @pageChange="pageChange"
    ></Pagination>
  </div>
</template>

<script>
/**
 * @Pagination 导入底部页码组件
 */
import Pagination from "@/components/table/pagination/pagination";
export default {
  name: "CommonsTable",

  /**
   * 传入页码组件的数据
   * @currentPage 当前页码
   * @pageSize 单页数据量
   * @tableDataList 分页后的表格数据
   */
  data() {
    return { currentPage: 1, pageSize: 1, tableDataList: [] };
  },

  /**
   * @itemOptions 表头数据
   * @tableData 表格数据
   */
  props: ["itemOptions", "tableData"],

  components: {
    Pagination,
  },

  /**
   * @pageChange 获取子组件子组件Pagination修改后的currentPage和pageSize，
   *  改变当前页码和单页数据量
   * @getNewData 请求新的分页后的表格数据
   */
  methods: {
    pageChange(pageSize, currentPage) {
      this.currentPage = currentPage;
      this.pageSize = pageSize;
      this.getNewData();
    },
    getNewData() {
      this.tableDataList = this.tableData.slice(
        (this.currentPage - 1) * this.pageSize,
        this.currentPage * this.pageSize
      );
    },
  },
  created() {
    
    this.getNewData();
    this.$forceUpdate();
  },
};
</script>

<style scoped>
.el-main {
  background-color: #e9eef3;
  color: #333;
  /* text-align: center; */
  line-height: 30px !important;
}
</style>

