<template>
  <!-- 项目申报按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <el-button @click="openAlertDialog" type="primary" :loading="loading">
            新增项目&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </el-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="项目详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <ProjectForm :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :levelProp="level" :sortProp="sort" :TableRow="TableRow" v-if="flag.openAlert"></ProjectForm>

    </mu-container>
  </div>
</template>

<script>
  import ProjectForm from "@/components/forms/forms/ProjectForm.vue";
  import Global from '@/components/forms/global/global.vue'

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
        loading: false,
        collegeInfo: [],
        otherAll: [
          [],
          [],
          [],
        ],
        firstDiscipline: [],
        level: [],
        sort: [],
      };
    },
    components: {
      ProjectForm,
    },
    methods: {
      openAlertDialog() {
        this.loading = true;
        this.reload = new Date().getTime();

        this.firstDiscipline = this.otherAll[0];
        this.level = this.otherAll[1];
        this.sort = this.otherAll[2];

        this.getAllData();
      },
      getAllData() {
        
        Global.methods.getCollegeData(this, this.collegeInfo);

        var i = [1, 2, 3];
        Global.methods.getFormData(this, i, 0, this.otherAll);
        return;
      },
    },
  }
</script>

<style>
</style>
