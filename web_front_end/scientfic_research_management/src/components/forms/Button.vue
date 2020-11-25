<template>
  <div>


    <div>
      asdfasdfas
      <PaperButton v-model="is_disabled"></PaperButton>
    </div>



<!--
    <template>

      <div class="block">
        <span class="demonstration">默认</span>
        <el-date-picker v-model="value1" type="date" placeholder="选择日期">
        </el-date-picker>
      </div>


      <mu-container>
        <mu-row gutter>
          <mu-col span="8" lg="4" sm="6" class="mu-demo-min-form float_left">
            <mu-date-input prop="input" v-model="value1" label="发表时间" label-float full-width landscape></mu-date-input>
          </mu-col>
        </mu-row>
      </mu-container>


      <button type="default" @click="onClick">asdfsd</button>

    </template> -->



  </div>
</template>

<script>
  import PaperButton from './PaperButton.vue'

  export default {
    data() {
      return {
        is_disabled: true,
        project: {
          id: 'ccc', //项目编号
          name: 'saaa', //项目名称
          user_id: 'asdf', //负责人
          college_id: 'asdf', //所属学院
          discipline: 'af', //学科门类
          characters: '', //项目性质
          first_discipline: '', //一级学科
          level: '', //项目级别
          sort: '', //项目分类
          begin_date: '', //立项日期
          end_date: '', //结项日期
          request_fund: '', //项目申请经费
          arrival_fund: '', //到账金额
          state: '', //审核状态
          approval_number: '', //批准文号
          information: '' //项目信息
        }
      };
    },
    components: {
      PaperButton
    }
  };


</script>

<style>
  @import 'https://unpkg.com/muse-ui/dist/muse-ui.css';
</style>
