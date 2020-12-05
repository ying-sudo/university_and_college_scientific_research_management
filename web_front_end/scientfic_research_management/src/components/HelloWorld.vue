<template>
  <div>

    <MButton></MButton>

    <!-- <Right></Right> -->

    <!--    <div>
      <button type="default" @click="test">button</button>
    </div> -->

    <div class="block">
      <span class="demonstration">默认</span>
      <el-date-picker v-model="value1" type="date" placeholder="选择日期">
      </el-date-picker>
    </div>



  </div>

</template>


<script>
  import MButton from './forms/Button.vue'
  import Right from './right/RightTable.vue'

  export default {
    components: {
      MButton,
      Right
    },
    data() {
      return {
        value1: null,
      }
    },
    methods: {
      test() {
        console.log('test');
        this.axios.post(this.GLOBAL.BASE_URL + "/tset/test")
          .then((response) => {
            console.log('tset1');
          })
          .catch(error => {
            console.log(error);
            console.log(error.response);
          });
      }
    }
  };
</script>


<style>

</style>
