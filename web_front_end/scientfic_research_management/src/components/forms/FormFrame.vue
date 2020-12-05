<template>

  <div>
  <!--  <mu-container>
      表单头部
      <el-dialog title="项目表单" class="el-dialog__title" style="font-size: 10px;" fullscreen :esc-press-close="false"
        :overlay-close="false" :visible.sync="flag.openAlert">
 -->
 
        <div v-if="FormKey == 'PaperForm'">
          <PaperForm></PaperForm>
        </div>
        <div v-else-if="FormKey == 'PatentForm'">
          <PatentForm></PatentForm>
        </div>
        <div v-else-if="FormKey == 'ProjectForm'">
          <ProjectForm v-model="flag" :TableRow="TableRow"></ProjectForm>
        </div>
        <div v-else-if="FormKey == 'TeamForm'">
          <TeamForm></TeamForm>
        </div>
        <div v-else-if="FormKey == 'WorkForm'">
          <WorkForm></WorkForm>
        </div>

        <!-- 确定按钮 -->
<!--        <div style="text-align: center;">
          <div v-if="!flag.isDisabled">
            <mu-button @click="canMakesure('project')" color="primary">
              确定&nbsp;&nbsp;
              <i right class="el-icon-upload"></i>
            </mu-button>
          </div>
          <div v-else>
            <mu-button @click="editForm" color="primary">
              编辑&nbsp;&nbsp;
              <i right class="el-icon-edit-outline"></i>
            </mu-button>
            <mu-button @click="closeAlertDialog" color="primary">
              返回
            </mu-button>
          </div>
        </div>

      </el-dialog>
    </mu-container> -->

  </div>



</template>

<script>
  import ProjectForm from './ProjectForm.vue';
  import PaperForm from './PaperForm.vue';
  import PatentForm from './PatentForm.vue';
  import TeamForm from './TeamForm.vue';
  import WorkForm from './WorkForm.vue';

  export default {
    props: ["flag", "TableRow"],
    model: {
      prop: "flag",
      event: "click",
    },
    data() {
      return {
        FormKey: null,
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
      console.log('aaa :    ' + this.$route.params.formKey);
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

      // getTitle(index) {
      //   switch (index) {
      //     case 1:
      //       return '项目表单';
      //     case 2:


      //   }
      // }
    }
  }
</script>

<style>
</style>
