<template>

  <div>

    <!-- 项目申报按钮 -->
    <div style="padding: 40px;">
      <ProjectForm></ProjectForm>
    </div>

    <!-- 论文成果按钮 -->
    <div style="padding: 40px;">
      <PaperForm></PaperForm>
    </div>

    <!-- 著作按钮 -->
    <div style="padding: 40px;">
      <WorkForm></WorkForm>
    </div>

    <!-- 专利按钮 -->
    <div style="padding: 40px;">
      <PatentForm></PatentForm>
    </div>
    
    <!-- 团队按钮 -->
    <div style="padding: 40px;">
      <TeamForm></TeamForm>
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
    components: {
      ProjectForm,
      PaperForm,
      WorkForm,
      PatentForm,
      TeamForm
    }
  };
</script>

<style>
</style>
