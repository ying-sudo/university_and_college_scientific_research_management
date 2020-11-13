<template>
  <!--表格组件模板，负责实现一个只有表格元素，没有任何数据的组件  -->

  <!-- @data:数据列的来源 
     @width:table的宽度 
     @max-height:列的最大高度 -->
  <el-table
    :data="tableData"
    fit
    highlight-current-row
    style="width: 90%"
    max-height="100"
  > 
    <!-- @item:表中的每一列  
         @:key: 第几列
         @label:每一列的标签
         @prop:列名
         @scope.row:从tableData中获取一行的数据
         @width:每一列的宽度-->
    <el-table-column
      v-for="item in itemOptions"
      width=150
      :key="item.id"
      :label="item.label"
      :prop="item.prop"
      align="center"
    >
      <!-- @scope.row:每一行的数据
     -->
      <template slot-scope="scope">
                  <span>{{ scope.row[item.prop] }}</span>        
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name:'CommonsTable',
  data() {
    return {
      
    };
  },
  props:['itemOptions','tableData'],
  
};
</script>
<style>
</style>

