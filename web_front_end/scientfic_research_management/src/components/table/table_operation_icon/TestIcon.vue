<template>
  <!-- 权限表中的操作列图标 -->
  <div>
    <ProjectButton v-model="isDisabled"></ProjectButton>
  </div>
</template>

<script>
import ProjectButton from "@/components/forms/ProjectButton";
export default {
  components: {
    ProjectButton,
  },
  methods: {
    handleClick() {
      this.$router.push("/author");
    },
  },
  data() {
    return {
      isDisabled: true,
    };
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