<template>
  <WorkButton v-model="isDisabled" :TableRow="TableRow"></WorkButton>
</template>

<script>
import WorkButton from "@/components/forms/buttons/WorkButton";

export default {
  components: {
    WorkButton,
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