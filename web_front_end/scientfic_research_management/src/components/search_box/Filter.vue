<template>
  <div class="filter_selector">
    <el-select
      v-model="value"
      placeholder="请选择筛选条件"
      @change="getFilterTag"
    >
      <el-option
        v-for="item in condition"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
        <span style="float: left">{{ item.label }}</span>
      </el-option>
    </el-select>
  </div>
</template>

<script>
import { getfilterMap } from "@/components/search_box/TableFilter.js";

export default {
  data() {
    return {
      condition: [],
      filterMap: [],
      value: "",

      filterTag: "",
    };
  },

  methods: {
    getFilterTag: function (newVal) {
      this.filtertag = newVal;
      // console.log(this.filtertag);
      this.$emit("changeFilterTag", this.filtertag);
    },
  },
  created: function () {
    this.filterMap = getfilterMap();
    this.condition = this.filterMap.get(this.$route.params.tableKey);
  },
  watch: {
    $route(to, from) {
      this.condition = this.filterMap.get(this.$route.params.tableKey);
    },
  },
};
</script>

<style scoped>
/* .filter_selector {
  width: 300px; 
} */
</style>