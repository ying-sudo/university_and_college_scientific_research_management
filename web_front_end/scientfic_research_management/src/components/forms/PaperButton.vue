<template>

  <!-- 论文成果按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertPaperDialog" color="primary">
            论文成果申报&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <mu-button @click="openAlertPaperDialog" color="primary">
            论文成果详情&nbsp;&nbsp;
          </mu-button>
        </div>
      </mu-flex>

      <PaperForm v-model="flag"></PaperForm>
    </mu-container>
  </div>

</template>

<script>
  import PaperForm from './PaperForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertPaper: false,
          is_disabled: true
        }, //论文成果表单
      };
    },
    components: {
      PaperForm
    },
    methods: {
      openAlertPaperDialog() { //论文成果表单
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertPaper = true;
      }
    }
  }
</script>

<style>
</style>
