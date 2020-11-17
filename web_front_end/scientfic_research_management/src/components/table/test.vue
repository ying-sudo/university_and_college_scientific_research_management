<template>
  <div>
    <el-table :data="tableDataList" border style="width: 100%">
      <el-table-column fixed prop="date" label="日期" width="150">
      </el-table-column>
      <el-table-column prop="name" label="姓名" width="120"> </el-table-column>
      <el-table-column prop="province" label="省份" width="120">
      </el-table-column>
      <el-table-column prop="city" label="市区" width="120"> </el-table-column>
      <el-table-column prop="address" label="地址" width="300">
      </el-table-column>
      <el-table-column prop="zip" label="邮编" width="120"> </el-table-column>
      <slot name="huan">替换失败</slot>
    </el-table>
    <!-- <slot name="function">function替换失败</slot> -->
    <Pagination
      :totalRows="tableData.length"
      :currentPage="currentPage"
      :pageSize="pageSize"
      @pageChange="pageChange"
    ></Pagination>
    <!-- <p>{{ this.pageSize }}</p> -->
  </div>
</template>

<script>
import Pagination from "./pagination/pagination.vue";
export default {
  components: {
    Pagination,
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
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
  },

  data() {
    return {
      currentPage: 1,
      pageSize: 1,
      tableDataList: [],
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          province: "上海",
          city: "普陀区",
          address: "上海市普陀区金沙江路 1518 弄",
          zip: 200333,
        },
        {
          date: "2016-05-02",
          name: "王小",
          province: "上海",
          city: "普陀区",
          address: "上海市普陀区金沙江路 1518 弄",
          zip: 200333,
        },
        {
          date: "2016-05-02",
          name: "王虎",
          province: "上海",
          city: "普陀区",
          address: "上海市普陀区金沙江路 1518 弄",
          zip: 200333,
        },
      ],
    };
  },
};
</script>