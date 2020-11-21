<template>
  <div class="SearchBox">
    <!-- 
      导入组件FilterBox 和 InputBox
     -->
    <el-row>
      <el-col :span="6"><FilterBox></FilterBox></el-col>
      <!-- v-bind="$attrs" 跨组件传输父组件的值
           v-on="$listeners" 跨组件修改父组件的值 -->
      <el-col :span="8"><InputBox v-bind="$attrs" v-on="$listeners"></InputBox></el-col>
      <!-- :search="search" @SearchChange="SearchChange" -->
    </el-row>

  </div>
</template>

<script>
import FilterBox from "@/components/search_box/Filter";
import InputBox from "@/components/search_box/InputBox";
export default {
  data() {
    return {

    };
  },
  inheritAttrs: true,
  components: {
    FilterBox,
    InputBox,
  },
  methods: {
   
  },
};
</script>

<style>
/*@margin-bottom 底部margin
  没有添加scope*/
.SearchBox{
  margin-bottom: 10px;
}
</style>