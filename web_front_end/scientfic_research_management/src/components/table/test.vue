<template>
  <div id="div">

  </div>
</template>
 
<script>
varvm = new Vue({
  el: "#div",
  data: {
    numbers: [1, 2, 3, 4, 5],
  },
  computed: {
    evenNumbers: function () {
      return this.numbers.filter(function (number) {
        return number < 4;
      });
    },
  },
});
</script>