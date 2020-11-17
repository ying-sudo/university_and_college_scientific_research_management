<template>
  <div class="block">
    <!--@page-sizes:选择一页有多少条数据
        @page-size:默认一页10条数据, 单页数据量
        @total:总共的数据量
        @layout:在页面显示的效果 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="this.sub_currentPage"
      :page-sizes="[1, 2, 5, 10]"
      :page-size="this.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="this.totalRows"
    >
    </el-pagination>
    <!-- <p>{{ this.pageSize }}</p> -->
  </div>
</template>

<script>
export default {
  /**
   * @totalRows 接受父组件传入的数据总量
   * @pageSize 接受父组件传入的单页数据量
   * @currentPage 接受父组件传入的当前页码
   */
  props: ["totalRows", "pageSize", "currentPage"],
  data() {
    return { sub_pageSize: this.pageSize, sub_currentPage: this.currentPage };
  },

  /**
   * @handleSizeChange 当单页数据量修改为psize后，修改pageSize后，并将修改后的值返回到父组件
   * @handleCurrentChange 当当前页码修改为cpage后，修改currentPage后，并将修改后的值返回到父组件
   */
  methods: {
    handleSizeChange: function (psize) {
      this.sub_pageSize = psize;
      console.log(`每页 ${psize} 条`);
      this.$emit("pageChange", this.sub_pageSize, this.sub_currentPage);
    },
    handleCurrentChange: function (cpage) {
      this.sub_currentPage = cpage;
      console.log(`当前页: ${cpage}`);
      this.$emit("pageChange", this.sub_pageSize, this.sub_currentPage);
    },
  },
};
</script>

<style>
</style>