<template>
  <div>
    <p>11111</p>
    <tableTest>
      <el-table-column slot="huan" fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small"
            >查看</el-button
          >
          <el-button type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">编辑1</el-button>
        </template>
      </el-table-column>
      <!-- <div slot="function"><pagination ></pagination></div> -->
    </tableTest>
  </div>
</template>

<script>
import tableTest from "./test";
// import pagination from "./pagination/pagination"
export default {
  components: {
    tableTest,
    // pagination
  },
};
</script>

<style>
</style>