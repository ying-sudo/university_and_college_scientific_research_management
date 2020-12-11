<template>
  <div>
    <ScientificButton v-model="isDisabled" :TableRow="TableRow"></ScientificButton>
  </div>
</template>

<script>
import ScientificButton from "@/components/forms/buttons/ScientificButton";
export default {
  components: {
    ScientificButton,
  },
  methods: {
  },
  props:["TableRow"],
  data() {
    return {
      isDisabled: true,
    };
  },
};
</script>

<style scoped>

</style>