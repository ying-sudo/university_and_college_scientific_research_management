<template>
</template>

<script>
  export default {
    data() {
      return {

      };
    },
    methods: {
      getElementById(that, id) {
        return that.$echarts.init(document.getElementById(id));
      },
      
    },
  };
</script>

<style>
</style>
