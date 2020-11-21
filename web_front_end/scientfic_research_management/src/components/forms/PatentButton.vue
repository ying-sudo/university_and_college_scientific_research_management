<template>

  <!-- 专利按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertPatentDialog" color="primary">
            专利申请表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <mu-button @click="openAlertPatentDialog" color="primary">
            专利详情&nbsp;&nbsp;
          </mu-button>
        </div>
      </mu-flex>

      <PatentForm v-model="flag"></PatentForm>
    </mu-container>
  </div>

</template>

<script>
  import PatentForm from './PatentForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertPatent: false, //专利申请表单
          is_disabled: false
        }
      };
    },
    components: {
      PatentForm
    },
    methods: {
      openAlertPatentDialog() { //专利申请表单
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertPatent = true;
      }
    }
  }
</script>

<style>
</style>
