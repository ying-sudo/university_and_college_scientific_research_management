<template>
  <!-- 项目申报按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            新增项目&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="项目详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog"></el-button>
          </el-tooltip>
        </div>
        <!-- <p>{{this.TableRow}}</p> -->
      </mu-flex>

      <ProjectForm v-if="getAllData" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :levelProp="level" :sortProp="sort" :TableRow="TableRow"></ProjectForm>

    </mu-container>
  </div>
</template>

<script>
  import ProjectForm from "./ProjectForm.vue";
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
          openAlert: false, //项目申报表单
          isDisabled: false, //为true表示不能更改，详情界面
        },
        reload: "",
        collegeInfo: null,
        firstDiscipline: null,
        level: null,
        sort: null,
      };
    },
    components: {
      ProjectForm,
    },
    methods: {
      openAlertDialog() {
        //项目申报表单
        // this.click = true;
        this.getCollegeData();
        this.getOtherData();

        this.reload = new Date().getTime();

        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
      getCollegeData() {

        // var url = this.GLOBAL.BASE_URL + "/mangerSys/college/findAll";
        // Global.methods.getCollegeData(this, url, this.collegeInfo);

        console.log('requrest :   ');

        this.axios.get(this.GLOBAL.BASE_URL + "/mangerSys/college/findAll").then(
          (response) => {
            this.collegeInfo = response.data.data;
            // this.openAlertDialog();
          },
          (response) => {
            console.log("getCollegeData request error");
          }
        );
      },
      getOtherData() {

        // var url = this.GLOBAL.BASE_URL + "/mangerSys/sort/findAll";
        // Global.methods.getOtherData(url, this.firstDiscipline, this.level, this.sort);


        this.axios
          .get(this.GLOBAL.BASE_URL + "/mangerSys/sort/findAll")
          .then((response) => {
            //console.log(response.data);
            this.firstDiscipline = response.data.data.firstDiscipline;
            // //console.log(response.data.data.firstDiscipline);
            this.level = response.data.data.level;
            // //console.log(response.data.data.level);
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
    },
  }
</script>

<style>
</style>
