<template>
  <div>
    {{this.$route.params.formKey}}
    {{this.$route.params.test}}

    <!-- 头 -->
    <div></div>

    <!-- 内容主体 -->
    <div>
      <div v-if="FormKey == 'PaperForm'">
        <PaperForm v-model="flag" :TableRow="TableRow"></PaperForm>
      </div>
      <div v-else-if="FormKey == 'PatentForm'">
        <PatentForm v-model="flag" :TableRow="TableRow"></PatentForm>
      </div>
      <div v-else-if="FormKey == 'ProjectForm'">
        <ProjectForm v-model="flag" :TableRow="TableRow"></ProjectForm>
      </div>
      <div v-else-if="FormKey == 'TeamForm'">
        <TeamForm v-model="flag" :TableRow="TableRow"></TeamForm>
      </div>
      <div v-else-if="FormKey == 'WorkForm'">
        <WorkForm v-model="flag" :TableRow="TableRow"></WorkForm>
      </div>
    </div>

    <!-- 尾部按钮 -->
    <div></div>

  </div>
</template>

<script>
  import ProjectForm from '@/components/forms/forms/ProjectForm.vue';
  import PaperForm from '@/components/forms/forms/PaperForm.vue';
  import PatentForm from '@/components/forms/forms/PatentForm.vue';
  import TeamForm from '@/components/forms/forms/TeamForm.vue';
  import WorkForm from '@/components/forms/forms/WorkForm.vue';

  export default {
    props: ["flag", "TableRow"],
    model: {
      prop: "flag",
      event: "click",
    },
    data() {
      return {
        FormKey: null,
        reload: '',
      };
    },
    components: {
      ProjectForm,
      PaperForm,
      PatentForm,
      TeamForm,
      WorkForm,
    },
    created: function() {

      this.FormKey = this.$route.params.formKey;
    },
    methods: {
      editForm() {
        // this.notDisabled = this.flag.isDisabled;
        Global.methods.editForm(this.flag);
      },
      closeAlertDialog() {
        Global.methods.closeAlertDialog(this.flag);
        //父子组件传值
        this.$emit("click", this.flag);
      },

    }
  }
</script>

<style>
</style>
