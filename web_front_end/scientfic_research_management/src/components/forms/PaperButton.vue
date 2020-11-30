<template>
  <!-- 论文成果按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            论文成果申报&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PaperForm :key="reload" v-model="flag"></PaperForm>
    </mu-container>
  </div>
</template>

<script>
  import PaperForm from "./PaperForm.vue";
  import Global from './global.vue'

  export default {
    props: ["isDisabled", "TableRow"],
    model: {
      prop: "isDisabled",
      event: "click",
    },
    data() {
      return {
        flag: {
          openAlert: false,
          isDisabled: false,
        }, //论文成果表单
        reload: '',
        collegeInfo: null,
        firstDiscipline: null,
        level: null,
        sort: null,
      };
    },
    components: {
      PaperForm,
    },
    methods: {
      openAlertDialog() {
        this.reload = new Date().getTime();
        //论文成果表单
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },

    },
    computed: {
      getAllData() {
        if (
          this.collegeInfo !== null &&
          this.firstDiscipline !== null &&
          this.level !== null &&
          this.sort !== null
        ) {
          return true;
        } else {
          return false;
        }
      },
    }
  };
</script>

<style>
</style>
