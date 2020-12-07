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

    <button type="default" @click="test1">aaaa</button>

  </div>

</template>


<script>
  import MButton from './forms/global/Button.vue'

  export default {
    components: {
      MButton,
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
      },
      test1() {
        console.log('asdfwqer');
        this.$router.push({name: 'Form', params: { formKey: 'test' , test: 'asdfsf'}});
        // this.$router.push({path: 'Form', query: { formKey: 'test' }});
      }
    }
  };
</script>


<style>

</style>
