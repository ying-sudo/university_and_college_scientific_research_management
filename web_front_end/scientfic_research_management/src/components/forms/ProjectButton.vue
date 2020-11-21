<template>

  <!-- 项目申报按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertProjectDialog" color="primary">
            项目申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <mu-button @click="openAlertProjectDialog" color="primary">
            项目详情&nbsp;&nbsp;
          </mu-button>
        </div>
      </mu-flex>

      <ProjectForm v-model="flag"></ProjectForm>

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
        }
      };
    },
    components: {
      ProjectForm
    },
    methods: {
      openAlertProjectDialog() { //项目申报表单
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertProject = true;
      }
    }
  };
</script>

<style>
</style>
