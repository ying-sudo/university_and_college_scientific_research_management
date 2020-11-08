<template>
  <div>
    <mu-container>
      <mu-flex justify-content="center">
        <mu-button @click="openAlertDialog">项目申报表单</mu-button>
      </mu-flex>
      <mu-dialog title="项目申报表单" width="600" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert">
        <div>
          <i class="el-icon-error" style="font-size: 32px"></i>
        </div>
        <ProjectFrom></ProjectFrom>
        <mu-button slot="actions" flat color="primary" @click="closeAlertDialog">确定申报</mu-button>
      </mu-dialog>
    </mu-container>
  </div>
</template>



<script>
  import ProjectFrom from './commons/forms/project_form.vue'

  export default {
    data() {
      return {
        openAlert: false
      };
    },
    methods: {
      openAlertDialog() {
        this.openAlert = true;
      },
      closeAlertDialog() {
        this.openAlert = false;
      }
    },
    components: {
      ProjectFrom
    }
  };
</script>

<style>

</style>
