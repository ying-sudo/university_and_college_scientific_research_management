<template>
  <div>


    <div>
      asdfasdfas
      <PaperButton v-model="is_disabled"></PaperButton>
    </div>



  </div>
</template>

<script>
  import WorkForm from './WorkForm.vue'
  import PaperButton from './PaperButton.vue'

  export default {
    data() {
      return {
        openAlertProject: false, //项目申报表单
        is_disabled: true
      };
    },
    components: {
      WorkForm,
      PaperButton
    },
    methods: {

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
