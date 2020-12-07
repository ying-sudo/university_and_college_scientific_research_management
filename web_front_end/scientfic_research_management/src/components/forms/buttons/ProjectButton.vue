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
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
        <!-- <p>{{this.TableRow}}</p> -->
      </mu-flex>

      <ProjectForm v-if="flag.openAlert" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :levelProp="level" :sortProp="sort" :TableRow="TableRow"></ProjectForm>

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
        collegeInfo: this.GLOBAL.collegeInfo,
        firstDiscipline: this.GLOBAL.firstDiscipline,
        level: this.GLOBAL.level,
        sort: this.GLOBAL.sort,
      };
    },
    components: {
      ProjectForm,
    },
    methods: {
      openAlertDialog() {
        console.log(this.GLOBAL.collegeInfo);
        console.log(this.GLOBAL.firstDiscipline);
        //项目申报表单
        this.reload = new Date().getTime();
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
    },
  }
</script>

<style>
</style>
