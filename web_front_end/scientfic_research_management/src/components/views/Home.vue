<template>
  <div id="outerContainer">

    <div style="margin-left: 40px; float: left; width: 600px;">
      <Card></Card>
    </div>

    <div style="margin-left: 40px; padding: 10px; float: left; margin-top: 20px;
      box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
      <pieChart></pieChart>
      <checkChart></checkChart>
    </div>

  </div>
</template>

<script>
  import checkChart from '@/components/views/Home/checkChart.vue'
  import pieChart from '@/components/views/Home/pieChart.vue'
  import Card from '@/components/views/Home/Card.vue'

  export default {
    data() {
      return {

      };
    },
    mounted() {

    },
    methods: {

    },
    components: {
      checkChart,
      pieChart,
      Card,
    }
  };
</script>

<style>

</style>
