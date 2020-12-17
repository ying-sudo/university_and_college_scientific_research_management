<template>

  <!-- 著作按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary" :loading="loading">
            著作申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="著作详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <WorkForm v-if="canOpen" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :TableRow="TableRow"
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
        otherAll: {
          publishLevel: [],
          workType: [],
          publishLocation: [],
          translateLanguage: [],
          firstDiscipline: [],
          workSource: [],
        },
        publishLevel: [],
        workType: [],
        publishLocation: [],
        translateLanguage: [],
        firstDiscipline: [],
        workSource: [],
      };
    },
    created: function() {
      this.getAllData();
    },
    components: {
      WorkForm
    },
    methods: {
      openAlertDialog() {
        this.loading = true;
        this.reload = new Date().getTime();
        this.publishLevel = this.otherAll.publishLevel;
        this.workType = this.otherAll.workType;
        this.publishLocation = this.otherAll.publishLocation;
        this.translateLanguage = this.otherAll.translateLanguage;
        this.firstDiscipline = this.otherAll.firstDiscipline;
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
        var isEmpty = Global.methods.isEmpty(this.firstDiscipline, this.collegeInfo, this.publishLevel, this.workType,
          this.publishLocation, this.workSource);
        if (isEmpty) {
          this.loading = false;
        }
        isEmpty = true;
        return isEmpty;
      }
    }
  }
</script>

<style>
</style>
