<template>
  <div>
    <PatentButton v-model="isDisabled" :TableRow="TableRow"></PatentButton>
    <!-- <p>{{ this.TableRow }}</p> -->
  </div>
</template>

<script>
import PatentButton from "@/components/forms/PatentButton";

export default {
  components: {
    PatentButton,
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