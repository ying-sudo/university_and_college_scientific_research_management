<template>

  <!-- 著作按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            科研申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="科研详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <ScientificForm v-if="flag.openAlert" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :levelProp="level" :sortProp="sort" :TableRow="TableRow"></ScientificForm>

    </mu-container>
  </div>

</template>

<script>
  import ScientificForm from './ScientificForm.vue'
  import Global from './global.vue'

  export default {
    props: ['isDisabled', "TableRow"],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlert: false, //著作申报表单
          isDisabled: false
        },
        reload: '',
        collegeInfo: this.GLOBAL.collegeInfo,
        firstDiscipline: this.GLOBAL.firstDiscipline,
        level: this.GLOBAL.level,
        sort: this.GLOBAL.sort,
      };
    },
    components: {
      ScientificForm
    },
    methods: {
      openAlertDialog() {
        this.reload = new Date().getTime();
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
    },
  }
</script>

<style>
</style>
