<template>
  <div>
    <!-- <PaperButton v-model="isDisabled" :TableRow="TableRow"></PaperButton> -->
    <TeamButton v-model="isDisabled" :TableRow="TableRow"></TeamButton>
  </div>
</template>

<script>
import PaperButton from "@/components/forms/buttons/PaperButton";

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