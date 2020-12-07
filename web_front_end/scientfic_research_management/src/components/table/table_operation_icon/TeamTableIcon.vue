<template>
  <div>
    <el-tooltip
      effect="light"
      content="团队成员"
      placement="bottom-end"
      :open-delay="500"
    >
      <el-button
        icon="el-icon-view"
        type="text"
        @click="toMember()"
      ></el-button>
    </el-tooltip>
    <!-- <p>{{this.TableRow}}</p> -->
  </div>
</template>

<script>
export default {
  props: ["TableRow"],
  methods: {
    toMember: function () {
      this.$router.push({
        path: "/teams/member",
        query: { TableRow: this.TableRow },
      });
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