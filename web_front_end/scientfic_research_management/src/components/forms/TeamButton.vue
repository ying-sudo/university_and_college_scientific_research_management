<template>

  <!-- 团队按钮 -->
  <div style="padding: 40px;">
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertTeamDialog" color="primary">
            团队申报表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertTeamDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <TeamForm :key="reload" v-model="flag"></TeamForm>
    </mu-container>
  </div>

</template>

<script>
  import TeamForm from './TeamForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertTeam: false, //团队申报表单
          is_disabled: true
        }, //论文成果表单
        reload: ''
      };
    },
    components: {
      TeamForm
    },
    methods: {
      openAlertTeamDialog() { //论文成果表单
        this.reload = new Date().getTime();

        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertTeam = true;
      }
    }
  }
</script>

<style>
</style>
