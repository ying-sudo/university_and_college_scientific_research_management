<template>

  <!-- 专利按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!is_disabled">
          <mu-button @click="openAlertPatentDialog" color="primary">
            专利申请表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="is_disabled">
          <el-tooltip effect="light" content="专利详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertPatentDialog"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PatentForm :key="reload" v-model="flag"></PatentForm>
    </mu-container>
  </div>

</template>

<script>
  import PatentForm from './PatentForm.vue'

  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlertPatent: false, //专利申请表单
          is_disabled: false
        },
        reload: ''
      };
    },
    components: {
      PatentForm
    },
    methods: {
      openAlertPatentDialog() { //专利申请表单
        this.reload = new Date().getTime();
        
        this.flag.is_disabled = this.is_disabled;
        this.flag.openAlertPatent = true;
      }
    }
  }
</script>

<style>
</style>
