<template>
  <!-- 权限 -->

<!--      <div class="select-control-group">
        Selects: {{checkbox.value1}}

        <mu-flex class="select-control-row" :key="'Cqwerqwrqwrwrx ' + i" v-for="i in 3">
          <mu-checkbox :value="'Checkasdox ' + i" v-model="checkbox.value1" :label="'asfasfsd ' + i"></mu-checkbox>
        </mu-flex>
      </div>
 -->

<div>
	<mu-container>
	  <mu-row gutter>
	    <mu-col span="12" lg="4" sm="6">
	      <mu-date-input v-model="value1" label="选择日期" label-float full-width></mu-date-input>
	    </mu-col>
	    <mu-col span="12" lg="4" sm="6">
	      <mu-date-input v-model="value2" label="横屏显示" label-float full-width landscape></mu-date-input>
	    </mu-col>
	    <mu-col span="12" lg="4" sm="6">
	      <mu-date-input v-model="value3" label="隐藏日期展示" label-float full-width no-display></mu-date-input>
	    </mu-col>
	  </mu-row>
	</mu-container>
</div>



</template>

<script>

	export default {
	  data () {
	    return {
	      value1: undefined,
	      value2: undefined,
	      value3: undefined
	    };
	  }
	};

  // export default {
  //   data() {
  //     return {
  //       checkbox: {
  //         value1: [],
  //         value2: false,
  //         value3: false
  //       }
  //     }
  //   }
  // }
</script>


<style>
  .select-control-row {
    padding: 8px 0;
  }

  .select-control-group {
    margin: 16px 0;
  }
</style>
