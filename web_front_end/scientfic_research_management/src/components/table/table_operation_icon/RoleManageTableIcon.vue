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
    <!-- <p>{{this.TableRow}}</p> -->
  </div>
</template>

<script>
export default {
  props: ["TableRow"],
  data() {
    return {
      RoleMap: [""],
    };
  },
  methods: {
    handleClick: function () {
      // this.$router.push({name:"RoleMember",params:{roleid:this.TableRow.id}});
      this.$router.push({
        path: "/role/member",
        query: { TableRow: this.TableRow },
      });
      //  this.$router.push({path: "/roletable/"+this.TableRow.id,query: { TableRow: this.TableRow.id },});
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