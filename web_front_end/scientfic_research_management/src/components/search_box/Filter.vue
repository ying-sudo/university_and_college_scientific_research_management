<template>
  <div class="filter_selector">
    <el-select
      v-if="isRouterAlive"
      v-model="value"
      :placeholder="this.placeholder"
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
      placeholder: "请选择筛选条件",
      isRouterAlive: true,
    };
  },

  methods: {
    getFilterTag: function (newVal) {
      this.filtertag = newVal;
      // console.log("this.filtertag:"+this.filtertag);
      this.$emit("changeFilterTag", this.filtertag);
    },

    reload() {
      this.isRouterAlive = false;
      this.$nextTick(() => (this.isRouterAlive = true));
    },
  },
  created: function () {
    this.filterMap = getfilterMap();
    this.condition = this.filterMap.get(this.$route.params.tableKey);
  },
  watch: {
    $route(to, from) {
      this.condition = this.filterMap.get(this.$route.params.tableKey);
      this.reload();
    },
  },
};
</script>

<style scoped>
.filter_selector {
  width: 300px; 
}
</style>