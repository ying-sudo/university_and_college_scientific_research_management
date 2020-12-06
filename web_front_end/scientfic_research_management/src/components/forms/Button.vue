<template>
  <!--  <div style="height: 750px; width: 100%; background-color: #000000;">
 -->

  <div>
    <PaperButton :isDisabled="isDisabled"></PaperButton>
  </div>


  <!-- <div>
  <template>
    <div class="block">
      <span class="demonstration">默认</span>
      <el-date-picker
        v-model="value1"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </div>
  </template>

</div> -->


  <!-- </div> -->
</template>

<script>
  import PaperButton from './PaperButton.vue'

  export default {
    data() {
      return {
        isDisabled: true,
        project: {
          id: 'ccc', //项目编号
          name: 'saaa', //项目名称
          user_id: 'asdf', //负责人
          college_id: 'asdf', //所属学院
          discipline: 'af', //学科门类
          characters: '', //项目性质
          first_discipline: '', //一级学科
          level: '', //项目级别
          sort: '', //项目分类
          begin_date: '', //立项日期
          end_date: '', //结项日期
          request_fund: '', //项目申请经费
          arrival_fund: '', //到账金额
          state: '', //审核状态
          approval_number: '', //批准文号
          information: '' //项目信息
        },
        users: [{

        }]
      };
    },
    components: {
      PaperButton
    }
  };


  // export default {
  //   data() {
  //     return {
  //       pickerOptions: {
  //         disabledDate(time) {
  //           return time.getTime() > Date.now();
  //         }
  //       },
  //       value1: '',
  //     };
  //   }
  // };




  // export default {
  //       data() {
  //         return {
  //           ruleForm: {
  //             name: '',
  //             region: '',
  //             date1: '',
  //             date2: '',
  //             delivery: false,
  //             type: [],
  //             resource: '',
  //             desc: ''
  //           },
  //           rules: {
  //             name: [
  //               { required: true, message: '请输入活动名称', trigger: 'blur' },
  //               { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
  //             ],
  //             region: [
  //               { required: true, message: '请选择活动区域', trigger: 'change' }
  //             ],
  //             date1: [
  //               { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
  //             ],
  //             date2: [
  //               { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
  //             ],
  //             type: [
  //               { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
  //             ],
  //             resource: [
  //               { required: true, message: '请选择活动资源', trigger: 'change' }
  //             ],
  //             desc: [
  //               { required: true, message: '请填写活动形式', trigger: 'blur' }
  //             ]
  //           }
  //         };
  //       },
  //       methods: {
  //         submitForm(formName) {
  //           this.$refs[formName].validate((valid) => {
  //             if (valid) {
  //               alert('submit!');
  //             } else {
  //               console.log('error submit!!');
  //               return false;
  //             }
  //           });
  //         },
  //         resetForm(formName) {
  //           this.$refs[formName].resetFields();
  //         }
  //       }
  //     }
</script>


<style>
  @import 'https://unpkg.com/muse-ui/dist/muse-ui.css';
</style>
