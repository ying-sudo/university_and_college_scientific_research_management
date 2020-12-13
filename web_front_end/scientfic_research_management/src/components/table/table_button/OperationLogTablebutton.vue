<template>
  <div>
    <BantchDelete :multiSelect="multiSelect"></BantchDelete>
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
  padding: 10px;
  padding-bottom: 20px;
}
</style>