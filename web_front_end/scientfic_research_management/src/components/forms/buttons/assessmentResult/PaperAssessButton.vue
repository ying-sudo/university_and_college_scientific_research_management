<template>

  <!-- 专利按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div>
          <el-tooltip effect="light" content="论文考核详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PaperAssessmentResultForm v-if="flag.openAlert" :key="reload" v-model="flag" :TableRow="TableRow"></PaperAssessmentResultForm>
    </mu-container>
  </div>

</template>

<script>
  import PaperAssessmentResultForm from '@/components/forms/forms/assessmentResult/PaperAssessmentResultForm.vue'
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: ['isDisabled', 'TableRow'],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlert: false, //专利申请表单
          isDisabled: false
        },
        reload: '',
      };
    },
    components: {
      PaperAssessmentResultForm,

    },
    methods: {
      openAlertDialog() { //专利申请表单
        this.reload = new Date().getTime(); //重载改组件
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
    },
  }
</script>

<style>
</style>
