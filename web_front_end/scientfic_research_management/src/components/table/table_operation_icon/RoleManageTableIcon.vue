<template>
  <div>
    <el-tooltip
      effect="light"
      content="查看角色成员"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-s-custom"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>
  </div>
</template>

<script>

export default {
    methods:{
        handleClick:function(){

        }
    },
};
</script>

<style scoped>
.el-button {
  width: 10px;
  color: #545c64;
  height: 40px;
  padding: 0;
  font-size: 18px;
}
</style>