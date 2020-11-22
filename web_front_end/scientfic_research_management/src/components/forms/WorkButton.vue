<template>

  <!-- 著作按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertWorkDialog" color="primary">
            著作申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <mu-button @click="openAlertWorkDialog" color="primary">
            项目详情&nbsp;&nbsp;
          </mu-button>
        </div>
      </mu-flex>

      <WorkForm v-model="flag"></WorkForm>
    </mu-container>
  </div>

</template>

<script>
  import WorkForm from './WorkForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertWork: false, //著作申报表单
          is_disabled: false
        },
      };
    },
    components: {
      WorkForm
    },
    methods: {
      openAlertWorkDialog() {
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertWork = true;
      }
    }
  }
</script>

<style>
</style>
