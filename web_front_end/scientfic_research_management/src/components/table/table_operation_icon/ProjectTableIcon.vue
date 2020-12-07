<template>
  <div>
    <ProjectButton v-model="isDisabled" :TableRow="TableRow"></ProjectButton>
    <!-- <p>{{this.TableRow}}</p> -->
  </div>
</template>

<script>
import ProjectButton from "@/components/forms/buttons/ProjectButton";
export default {
  components: {
    ProjectButton,
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