<template>

  <!-- 著作按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <el-button @click="openAlertDialog" type="primary" :loading="loading">
            著作申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </el-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="著作详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <WorkForm v-if="flag.openAlert" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :TableRow="TableRow"
        :publishLevelProp="publishLevel" :workTypeProp="workType" :publishLocationProp="publishLocation"
        :translateLanguageProp="translateLanguage" :firstDisciplineProp="firstDiscipline" :workSourceProp="workSource"></WorkForm>
    </mu-container>
  </div>

</template>

<script>
  import WorkForm from '@/components/forms/forms/WorkForm.vue'
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
        loading: false,
        collegeInfo: [],
        //著作：出版社级别，著作类别，出版地，翻译语种，一级学科，项目来源
        otherAll: [
          [],
          [],
          [],
          [],
          [],
          [],
        ],
        publishLevel: [],
        workType: [],
        publishLocation: [],
        translateLanguage: [],
        firstDiscipline: [],
        workSource: [],
      };
    },
    components: {
      WorkForm,
    },
    methods: {
      openAlertDialog() {
        this.loading = true;
        this.reload = new Date().getTime();

        this.firstDiscipline = this.otherAll[0];
        this.workType = this.otherAll[1];
        this.publishLevel = this.otherAll[2];
        this.publishLocation = this.otherAll[3];
        this.translateLanguage = this.otherAll[4];
        this.workSource = this.otherAll[5];

        this.getAllData();
      },
      getAllData() {
        Global.methods.getCollegeData(this, this.collegeInfo);

        var i = [1, 3, 4, 5, 6, 7];
        Global.methods.getFormData(this, i, 0, this.otherAll);
        return;
      },
    },
  }
</script>

<style>
</style>
