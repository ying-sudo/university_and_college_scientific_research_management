<template>
  <div>
    <el-row type="flex" justify="end"
      ><el-col :span="4"> <BantchDelete :multiSelect="multiSelect" v-on="$listeners"></BantchDelete></el-col
    ></el-row>
  </div>
</template>

<script>
import BantchDelete from "@/components/table/batch_delete/BantchDelete"

export default {
  components:{
    BantchDelete,
  },

  props: ["multiSelect"],

};
</script>
<style scoped>
.el-col {
  padding-bottom: 20px;
}
</style>