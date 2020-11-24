<template>
  <div>


    <div>
      asdfasdfas
      <PaperButton v-model="is_disabled"></PaperButton>
    </div>



  </div>
</template>

<script>
  import PaperButton from './PaperButton.vue'

  export default {
    data() {
      return {
        is_disabled: true
      };
    },
    components: {
      PaperButton
    }
  };
</script>

<style>
</style>
