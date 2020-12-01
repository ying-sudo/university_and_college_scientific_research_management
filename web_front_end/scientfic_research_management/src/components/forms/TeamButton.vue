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
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <TeamForm v-if="getAllData" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :levelProp="level" :sortProp="sort" :TableRow="TableRow"></TeamForm>
    </mu-container>
  </div>

</template>

<script>
  import TeamForm from './TeamForm.vue'
  import Global from './global.vue'

  export default {
    props: ['isDisabled', 'TableRow'],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertTeam: false, //团队申报表单
          isDisabled: false
        }, //论文成果表单
        reload: '',
        collegeInfo: null,
        firstDiscipline: null,
        level: null,
        sort: null,
      };
    },
    components: {
      TeamForm
    },
    methods: {
      openAlertDialog() { //论文成果表单
        this.getCollegeData();
        this.getOtherData();

        this.reload = new Date().getTime();
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
      getCollegeData() {
        this.axios.get(this.GLOBAL.BASE_URL + "/mangerSys/college/findAll").then(
          (response) => {
            this.collegeInfo = response.data.data;
          },
          (response) => {
            console.log("getCollegeData request error");
          }
        );
      },
      getOtherData() {
        this.axios
          .get(this.GLOBAL.BASE_URL + "/mangerSys/sort/findAll")
          .then((response) => {
            this.firstDiscipline = response.data.data.firstDiscipline;
            this.level = response.data.data.level;
            this.sort = response.data.data.sort;
          });
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
  }
</script>

<style>
</style>
