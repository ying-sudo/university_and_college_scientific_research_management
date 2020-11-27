<template>

  <!-- 著作按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertWorkDialog" color="primary">
            著作申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertWorkDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <WorkForm :key="reload" v-model="flag"></WorkForm>
    </mu-container>
  </div>

</template>

<script>
  import WorkForm from './WorkForm.vue'

  export default {
    props: ['isDisabled'],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertWork: false, //著作申报表单
          isDisabled: false
        },
        reload: ''
      };
    },
    components: {
      WorkForm
    },
    methods: {
      openAlertWorkDialog() {
        this.reload = new Date().getTime();
        
        this.flag.isDisabled = this.isDisabled;
        this.flag.openAlertWork = true;
      }
    }
  }
</script>

<style>
</style>
