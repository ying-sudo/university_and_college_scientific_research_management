<template>
  <div>
    <component
      :is="item.location"
      v-for="(item, index) in simulateData"
      :key="index"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      simulateData: [
        { location: "AuthorityTableIcon" },
      ],
    };
  },

  created() {
    this.simulateData.map((el) => {
      this.$options.components[el.location] = () =>
        import("@/components/table/table_operation_icon/" + el.location + ".vue");
    });
  },
};
</script>