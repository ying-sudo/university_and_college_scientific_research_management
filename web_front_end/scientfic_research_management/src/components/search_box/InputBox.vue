<template>
  <div class="input_box">
    <!-- 
      @ @input 键盘输入事件 
      @ v-model 
      @ placeholder 搜索框默认内容
     -->
    <el-input
      @input="SubChangeTable(search)"
      placeholder="输入要搜索的内容"
      v-model="search"
      type="search"
    >
      <!-- 搜索图标 -->
      <i slot="prefix" class="el-input__icon el-icon-search"></i>
    </el-input>
  </div>
</template>

<script>
export default {
  /**
   * @inheritAttrs
   */
  data() {
    return {
      search: "",
      sub_tables: this.tableData,
      subFilterTag: this.filterTag,
    };
  },
  props: ["tableData", "filterTag"],
  inheritAttrs: false,

  /**
   * 方法
   * @SubChangeTable 筛选出用户选择的表格数据，然后将筛选出来的表格数据tables传输到父组件
   */
  methods: {
    SubChangeTable: function (newVal) {
      this.search = newVal;
      // console.log(`new: ${newVal} `);
      console.log("tables:" + this.tables.length);
      // this.$emit("changeTable", this.tables);
      this.$emit("changeTable", this.tables, this.search);
    },
  },

  /**
   * @watch search 监听用户输入的值
   */
  watch: {
    search: function (newVal, oldVal) {
      console.log("search new:" + newVal);
    },

    filterTag: function (newVal, oldVal) {
      console.log("filterTag new:" + newVal);
      this.subFilterTag = newVal;
    },
  },
  computed: {
    /**
     * 实时监听表格，筛选用户选中的数据
     * @filter 过滤掉search中没选择的表格行数据
     */
    tables: function () {
      console.log("input subFilterTag:" + this.subFilterTag);

      const search = this.search;
      if (search) {
        return this.tableData.filter((dataNews) => {
          // return Object.keys(dataNews).some((key) => {
            return String(dataNews[this.subFilterTag]).toLowerCase().indexOf(search) > -1;
            // return String(dataNews[key]).toLowerCase().indexOf(search) > -1;
          // });
        });
      }
      return this.tableData;
      
    },

  },
};
</script>

<style scoped>
</style>