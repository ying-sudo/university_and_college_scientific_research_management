<template>

  <!-- 专利按钮 -->
  <div>
    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            专利申请表单&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="专利详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PatentForm v-if="canOpen" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :patentRangeProp="patentRange"
        :patentTypeProp="patentType" :TableRow="TableRow"></PatentForm>
    </mu-container>
  </div>

</template>

<script>
  import PatentForm from '@/components/forms/forms/PatentForm.vue'
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: ['isDisabled', 'TableRow'],
    model: {
      prop: 'isDisabled',
      event: 'click'
    },
    data() {
      return {
        flag: {
          openAlert: false, //专利申请表单
          isDisabled: false
        },
        reload: '',
        collegeInfo: [],
        //专利：  专利类型，专利范围
        otherAll: {
          patentType: [],
          patentRange: [],
        },
        patentType: null,
        patentRange: null,
      };
    },
    created: function() {
      this.getAllData();
    },
    components: {
      PatentForm
    },
    methods: {
      openAlertDialog() { //专利申请表单
        this.reload = new Date().getTime(); //重载改组件
        this.patentRange = this.otherAll.patentRange;
        this.patentType = this.otherAll.patentType;
        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
      getAllData() {
        Global.methods.getCollegeData(this, this.collegeInfo);
        Global.methods.getOtherData(this, this.otherAll);

        return;
      },
    },
    computed: {
      canOpen() {
        var isEmpty = Global.methods.isEmpty(this.patentRange, this.patentType, this.collegeInfo);
        return isEmpty;
      }
    }
  }
</script>

<style>
</style>
