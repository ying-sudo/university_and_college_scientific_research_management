<template>
  <!-- 论文成果按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertPaperDialog" color="primary">
            论文成果申报&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertPaperDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PaperForm :key="reload" v-model="flag"></PaperForm>
    </mu-container>
  </div>
</template>

<script>
  import PaperForm from "./PaperForm.vue";

  export default {
    props: ["isDisabled"],
    model: {
      prop: "isDisabled",
      event: "click",
    },
    data() {
      return {
        flag: {
          openAlertPaper: false,
          isDisabled: true,
        }, //论文成果表单
        reload: ''
      };
    },
    components: {
      PaperForm,
    },
    methods: {
      openAlertPaperDialog() {
        this.reload = new Date().getTime();
        //论文成果表单
        this.flag.isDisabled = this.isDisabled;
        this.flag.openAlertPaper = true;
      },
    },
  };
</script>

<style>
</style>
