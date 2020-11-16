<template>
  <div class="block">
    <!--@page-sizes:选择一页有多少条数据
        @page-size:默认一页10条数据
        @total:总共的数据行数
        @layout:在页面显示的效果 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400"
    >
    </el-pagination>
    <!-- 直接跳转 -->
    <router-link to="@">
      <button>点击跳转</button>
    </router-link>
  </div>
</template>

<script>
export default {
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  },
  data() {
    //开始指向第一页
    return {
      currentPage1: 1,
      currentPage2: 1,
      currentPage3: 1,
      currentPage4: 1,
    };
  },
};
</script>

<style>
</style>