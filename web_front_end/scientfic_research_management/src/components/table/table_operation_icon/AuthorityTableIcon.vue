<template>
  <!-- 权限表中的操作列图标 -->
  <div>
    <!-- 视图维护 -->
    <el-tooltip
      effect="light"
      content="视图维护"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-view"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>

    <!-- 权限维护 -->
    <el-tooltip
      effect="light"
      content="权限维护"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-lock"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>

    <!-- 成员维护 -->
    <el-tooltip
      effect="light"
      content="成员维护"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-s-custom"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>

    <!-- 编辑分组 -->
    <el-tooltip
      effect="light"
      content="编辑分组"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-edit-outline"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>

    <!-- 复制分组 -->
    <el-tooltip
      effect="light"
      content="复制分组"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-document-copy"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>

    <!-- 删除分组 -->
    <el-tooltip
      effect="light"
      content="删除分组"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-delete"
        type="text"
        @click="handleClick()"
      ></el-button>
    </el-tooltip>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick() {
      this.$router.push("/author");
    },
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