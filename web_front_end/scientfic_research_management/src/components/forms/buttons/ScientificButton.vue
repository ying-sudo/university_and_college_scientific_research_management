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

      <ScientificForm v-if="canOpen" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :TableRow="TableRow"
        :workSourceProp="workSource" :translateLanguageProp="translateLanguage" :workTypeProp="workType"
        :firstDisciplineProp="firstDiscipline"></ScientificForm>

    </mu-container>
  </div>

</template>

<script>
  import ScientificForm from '@/components/forms/forms/ScientificForm.vue'
  import Global from '@/components/forms/global/global.vue'

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
        collegeInfo: null,
        //一级学科，研究类别，项目来源
        otherAll: {
          firstDiscipline: [],
          workType: [],
          translateLanguage: [],
          workSource: [],
        },
        firstDiscipline: null,
        workType: null,
        translateLanguage: null,
        workSource: null,
      };
    },
    created: function() {
      this.getAllData();
    },
    components: {
      ScientificForm
    },
    methods: {
      openAlertDialog() {
        this.reload = new Date().getTime();
        this.firstDiscipline = this.otherAll.firstDiscipline;
        this.workType = this.otherAll.workType;
        this.translateLanguage = this.otherAll.translateLanguage;
        this.workSource = this.otherAll.workSource;
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
      getAllData() {
        Global.methods.getCollegeData(this, this.collegeInfo);
        Global.methods.getOtherData(this, this.otherAll);

        return;
      },
    },
    computed: {
      canOpen() {
        var isEmpty = Global.methods.isEmpty(this.firstDiscipline, this.workType, this.translateLanguage, this.collegeInfo,
          this.workSource);
        return isEmpty;
      }
    },
  }
</script>

<style>
</style>
