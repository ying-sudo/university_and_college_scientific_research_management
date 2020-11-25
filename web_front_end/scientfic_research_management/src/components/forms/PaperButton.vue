<template>
  <!-- 论文成果按钮 -->
  <div>
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
    props: ["is_disabled"],
    model: {
      prop: "is_disabled",
      event: "click",
    },
    data() {
      return {
        flag: {
          openAlertPaper: false,
          is_disabled: true,
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
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertPaper = true;
      },
    },
  };
</script>

<style>
</style>
