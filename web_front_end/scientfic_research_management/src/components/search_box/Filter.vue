<template>
  <div class="filter_selector">
    <el-select v-model="value" placeholder="请选择筛选条件">
      <el-option
        v-for="item in condition"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
        <span style="float: left">{{ item.label }}</span>
        <span style="float: right; color: #8492a6; font-size: 13px">{{
          item.value
        }}</span>
      </el-option>
    </el-select>
  </div>
</template>

<script>
export default {
  data() {
    return {
      condition: [
        {
          value: "Beijing",
          label: "北京",
        },
        
      ],
      value: "",
    };
  },
};
</script>

<style scoped>
/* .filter_selector {
  width: 300px; 
} */
</style>