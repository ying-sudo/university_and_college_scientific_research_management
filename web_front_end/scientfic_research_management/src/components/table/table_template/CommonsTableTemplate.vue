<template>
  <div>
    <!--表格组件模板，负责实现一个只有表格元素，没有任何数据的组件  -->

    <!-- @data:数据列的来源 
     @width:table的宽度 
     @max-height:列的最大高度 -->
    <el-table
      :data="tableDataList"
      ref="multipleTable"
      @selection-change="handleSelectionChange"
      fit
      highlight-current-row
      style="width: 100%"
      v-if="tableData !== null"
      size="middle"
    >
      <el-table-column type="selection" width="55"> </el-table-column>

      <!-- @item:表中的每一列  
         @:key: 当前第几列
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
          <span v-html="changeColor(scope.row[item.prop])">{{
            scope.row[item.prop]
          }}</span>
          <!-- <p>{{scope.$index}}</p>  -->
          <!-- v-html="showDate(scope.row[item.prop])" -->
               
        </template>
      </el-table-column>
      <!-- 在TableTemplate中留下一列供父组件修改的列插槽，将该组件的作用域延迟到父组件编译，
      父组件对应标签内的所有内容将代替子组件的<slot>标签及它的内容 -->
      <el-table-column
        fixed="right"
        label="操作"
        width="300"
        align="center"
        v-if="this.$route.params.tableKey === 'projectlists'"
      >
        <!-- <p>{{scope.$index}}</p> -->
        <template slot-scope="scope">
          <slot name="table_template_slot" :row="scope.row"></slot>
        </template>
      </el-table-column>
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
import Pagination from "@/components/pagination/pagination";
import { getDelIdMap } from "@/components/table/table_map/delIdMap.js";

export default {
  name: "CommonsTable",

  /**
   * 传入页码组件的数据
   * @currentPage 当前页码
   * @pageSize 单页数据量
   * @tableDataList 分页后的表格数据
   */
  data() {
    return {
      currentPage: 1,
      pageSize: 5,
      tableDataList: [],
      ShowPage: false,

      multipleSelection: [],
      delIds: [], //批量删除的ID
      DelIdMap:[],
      _delId:"",
    };
  },

  /**
   * @itemOptions 表头数据
   * @tableData 表格数据
   */
  props: ["itemOptions", "tableData", "search"],

  components: {
    Pagination,
  },

  created(){
    this.DelIdMap=getDelIdMap();
    console.log(this.DelIdMap);
  },

  /**
   * @pageChange 获取子组件子组件Pagination修改后的currentPage和pageSize，
   *  改变当前页码和单页数据量
   * @getNewData 请求新的分页后的表格数据
   * @changeColor 筛选字变色
   */
  methods: {
    pageChange(pageSize, currentPage) {
      // console.log("pageChange work");
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

    changeColor(val) {
      val = val + ""; //不加上这条会显示不出来数据
      if (val.indexOf(this.search) !== -1 && this.search !== "") {
        return val.replace(
          this.search,
          '<font color="#409EFF">' + this.search + "</font>"
        );
      } else {
        return val;
      }
    },

    handleSelectionChange(val) {
      
      this._delId=this.DelIdMap.get(this.$route.params.tableKey);
      console.log("this._delId:"+this._delId);
      // console.log("this.delId:"+this.delId);

      this.multipleSelection = val;
      this.delIds = val.map((item) => item[this._delId]).join(); //获取的是 1,2,3 这种格式
      console.log(this.delIds);

      this.$emit("deleteSelected", this.delIds);
    },
  },

  /**
   * @newVal 就是接受的tableData
   * newVal存在的话执行getNewData函数
   */
  watch: {
    tableData: function (newVal, oldVal) {
      this.tableData = newVal;
      newVal && this.getNewData();
    },
  },

  mounted() {
    console.log("Template执行了mounted");
    this.getNewData();
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

