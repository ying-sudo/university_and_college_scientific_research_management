<template>

  <!-- 项目申报按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertProjectDialog" color="primary">
            新增项目&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertProjectDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <ProjectForm :key="reload" v-model="flag"></ProjectForm>

    </mu-container>
  </div>
</template>

<script>
  import ProjectForm from './ProjectForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertProject: false, //项目申报表单
          is_disabled: false
        },
        reload: ''
      };
    },
    components: {
      ProjectForm
    },
    methods: {
      openAlertProjectDialog() { //项目申报表单
        this.reload = new Date().getTime();

        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertProject = true;
      }
    }
  };
</script>

<style>
</style>
