<template>
  <!-- 项目申报按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="getCollegeData" color="primary">
            新增项目&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="getCollegeData"></el-button>
          </el-tooltip>
        </div>
        <!-- <p>{{this.TableRow}}</p> -->
      </mu-flex>

      <ProjectForm :key="reload" v-model="flag" :collegeInfo="collegeInfo"></ProjectForm>

    </mu-container>
  </div>
</template>

<script>
  import ProjectForm from "./ProjectForm.vue";

  export default {
    props: ["isDisabled", "TableRow"], //TableRow获取父组件表格指定行的数据
    model: {
      prop: "isDisabled",
      event: "click",
    },
    data() {
      return {
        flag: {
          openAlertProject: false, //项目申报表单
          isDisabled: false,
        },
        reload: "",
        collegeInfo: null,
      };
    },
    components: {
      ProjectForm,
    },
    methods: {
      openAlertProjectDialog() {

        //项目申报表单
        this.reload = new Date().getTime();

        this.flag.isDisabled = this.isDisabled;
        this.flag.openAlertProject = true;
      },

      getCollegeData() {
        this.axios.get(this.GLOBAL.BASE_URL + "/mangerSys/college/findAll").then(
          (response) => {
            this.collegeInfo = response.data.data;
            this.openAlertProjectDialog();
          },
          (response) => {
            console.log("getCollegeData request error");
          }
        );
      },
    },
  };
</script>

<style>
</style>
