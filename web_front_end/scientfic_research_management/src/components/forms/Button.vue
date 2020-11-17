<template>
  <div>
    <!-- 项目申报按钮 -->
    <div style="padding: 40px;">
      <mu-container>
        <!-- 表单按钮 -->
        <mu-flex justify-content="center">
          <mu-button @click="openAlertProjectDialog" color="primary">
            项目申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </mu-flex>

        <ProjectForm v-model="openAlertProject"></ProjectForm>
      </mu-container>
    </div>

    <!-- 论文成果按钮 -->
    <div style="padding: 40px;">
      <mu-container>
        <!-- 表单按钮 -->
        <mu-flex justify-content="center">
          <mu-button @click="openAlertPaperDialog" color="primary">
            论文成果表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </mu-flex>

        <PaperForm v-model="openAlertPaper"></PaperForm>
      </mu-container>
    </div>

    <!-- 著作按钮 -->
    <div style="padding: 40px;">
      <mu-container>
        <!-- 表单按钮 -->
        <mu-flex justify-content="center">
          <mu-button @click="openAlertWorkDialog" color="primary">
            著作申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </mu-flex>

        <WorkForm v-model="openAlertWork"></WorkForm>
      </mu-container>
    </div>

    <!-- 专利按钮 -->
    <div style="padding: 40px;">
      <mu-container>
        <!-- 表单按钮 -->
        <mu-flex justify-content="center">
          <mu-button @click="openAlertPatentDialog" color="primary">
            专利申请表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </mu-flex>

        <PatentForm v-model="openAlertPatent"></PatentForm>
      </mu-container>
    </div>

    <!-- 团队按钮 -->
    <div style="padding: 40px;">
      <mu-container>
        <!-- 表单按钮 -->
        <mu-flex justify-content="center">
          <mu-button @click="openAlertTeamDialog" color="primary">
            团队申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </mu-flex>

        <TeamForm v-model="openAlertTeam"></TeamForm>
      </mu-container>
    </div>
  </div>
</template>

<script>
  import ProjectForm from './ProjectForm.vue'
  import PaperForm from './PaperForm.vue'
  import WorkForm from './WorkForm.vue'
  import PatentForm from './PatentForm.vue'
  import TeamForm from './TeamForm.vue'

  export default {
    data() {
      return {
        openAlertPaper: false, //论文成果表单
        openAlertPatent: false, //专利申请表单
        openAlertProject: false, //项目申报表单
        openAlertTeam: false, //团队申报表单
        openAlertWork: false //著作申报表单
      };
    },
    components: {
      ProjectForm,
      PaperForm,
      WorkForm,
      PatentForm,
      TeamForm
    },
    methods: {
      openAlertPaperDialog() { //论文成果表单
        this.openAlertPaper = true;
      },
      openAlertPatentDialog() { //专利申请表单
        this.openAlertPatent = true;
      },
      openAlertProjectDialog() { //项目申报表单
        this.openAlertProject = true;
      },
      openAlertTeamDialog() { //团队申报表单
        this.openAlertTeam = true;
      },
      openAlertWorkDialog() { //著作申报表单
        this.openAlertWork = true;
      }
    }
  };
</script>

<style>
</style>
