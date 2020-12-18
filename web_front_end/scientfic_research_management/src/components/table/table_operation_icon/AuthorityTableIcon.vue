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
    <!-- <p>{{this.TableRow}}</p> -->
  </div>
</template>

<script>
export default {
  props: ["TableRow"],
  data() {
    return {
      role_authority: [],
    };
  },
  methods: {
    handleClick() {
      var token = sessionStorage.getItem("token");
      this.axios.defaults.headers.common["Authorization"] = token;

      this.axios
        .get(
          `${this.GLOBAL.BASE_URL}/mangerSys/characters/findAllRights/${this.TableRow.id}`
        )
        .then((res) => {
          this.role_authority = res.data.data;
          // console.log("role_authority:");
          // console.log(res.data.data);
        });

      if (this.role_authority.length != 0) {
        this.$router.push({
          path: "/author",
          query: { role_authority: this.role_authority },
        });
      }
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