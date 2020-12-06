<template>
  <div>
    <PaperButton v-model="isDisabled" :TableRow="TableRow"></PaperButton>
  </div>
</template>

<script>
import PaperButton from "@/components/forms/PaperButton";

export default {
  components: {
    PaperButton,
  },
  props: ["TableRow"],
  data() {
    return {
      isDisabled: true,
    };
  },
};
</script>

<style>
</style>