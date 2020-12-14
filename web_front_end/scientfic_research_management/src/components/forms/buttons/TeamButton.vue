<template>

  <!-- 团队按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            团队申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <TeamForm v-if="canOpen" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :TableRow="TableRow"></TeamForm>
    </mu-container>
  </div>

</template>

<script>
  import TeamForm from '@/components/forms/forms/TeamForm.vue'
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: ['isDisabled', 'TableRow'],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlert: false, //团队申报表单
          isDisabled: false
        }, //论文成果表单
        reload: '',
        collegeInfo: [],
        //团队：一级学科
        otherAll: {
          firstDiscipline: [],
        },
        firstDiscipline: null,
      };
    },
    created: function() {
      this.getAllData();
    },
    components: {
      TeamForm
    },
    methods: {
      openAlertDialog() { //论文成果表单
        this.reload = new Date().getTime();
        this.firstDiscipline = this.otherAll.firstDiscipline;
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
        var isEmpty = Global.methods.isEmpty(this.firstDiscipline, this.collegeInfo);
        return isEmpty;
      }
    },
  }
</script>

<style>
</style>
