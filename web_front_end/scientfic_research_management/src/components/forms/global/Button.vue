<template>
  <!--  <div style="height: 750px; width: 100%; background-color: #000000;">
 -->

  <div>
    <PaperButton :isDisabled="isDisabled"></PaperButton>

    <div style="margin: 20px;"></div>

    <ProjectButton :isDisabled="isDisabled"></ProjectButton>

    <div style="margin: 20px;"></div>

    <PatentButton :isDisabled="isDisabled"></PatentButton>

    <div style="margin: 20px;"></div>

    <TeamButton :isDisabled="isDisabled"></TeamButton>

    <div style="margin: 20px;"></div>

    <WorkButton :isDisabled="isDisabled"></WorkButton>

    <div style="margin: 20px;"></div>

    <ScientificButton :isDisabled="isDisabled"></ScientificButton>

    <div style="margin: 20px;"></div>
    project
    <ProjectAssessButton :isDisabled="isDisabled"></ProjectAssessButton>

    <div style="margin: 20px;"></div>
    paper
    <PaperAssessButton :isDisabled="isDisabled"></PaperAssessButton>

    <div style="margin: 20px;"></div>
    patent
    <PatentAssessButton :isDisabled="isDisabled"></PatentAssessButton>

    <div style="margin: 20px;"></div>
    ScientificAssessButton
    <ScientificAssessButton :isDisabled="isDisabled"></ScientificAssessButton>

    <div style="margin: 20px;"></div>
    TeamAssessButton
    <TeamAssessButton :isDisabled="isDisabled"></TeamAssessButton>

    <div style="margin: 20px;"></div>
    WorkAssessButton
    <WorkAssessButton :isDisabled="isDisabled"></WorkAssessButton>



    <div style="margin: 20px;"></div>
    审核
    <bu :isDisabled="isDisabled"></bu>



<!-- <ExcelDialog :tHeader="tHeader" :filterVal="filterVal" :tableData="tableData" :excelName="excelName"></ExcelDialog> -->










    <div style="margin: 20px;"></div>
    personal
    <PersonalAssessButton :isDisabled="isDisabled"></PersonalAssessButton>

    <div style="margin: 20px;"></div>
    college
    <CollegeAssessButton :isDisabled="isDisabled"></CollegeAssessButton>


    <div style="margin: 20px;"></div>

    <div style="margin: 20px;"></div>

    <div style="margin: 20px;"></div>


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
  import Global from '@/components/forms/global/global.vue'
  import ExcelDialog from '@/components/forms/global/ExcelDialog.vue'

  import PaperButton from '@/components/forms/buttons/PaperButton.vue'
  import ProjectButton from '@/components/forms/buttons/ProjectButton.vue'
  import PatentButton from '@/components/forms/buttons/PatentButton.vue'
  import TeamButton from '@/components/forms/buttons/TeamButton.vue'
  import WorkButton from '@/components/forms/buttons/WorkButton.vue'
  import ScientificButton from '@/components/forms/buttons/ScientificButton.vue'
  import CollegeAssessButton from '@/components/forms/buttons/assessmentResult/CollegeAssessButton.vue'
  import PaperAssessButton from '@/components/forms/buttons/assessmentResult/PaperAssessButton.vue'
  import PatentAssessButton from '@/components/forms/buttons/assessmentResult/PatentAssessButton.vue'
  import PersonalAssessButton from '@/components/forms/buttons/assessmentResult/PersonalAssessButton.vue'
  import ProjectAssessButton from '@/components/forms/buttons/assessmentResult/ProjectAssessButton.vue'
  import ScientificAssessButton from '@/components/forms/buttons/assessmentResult/ScientificAssessButton.vue'
  import TeamAssessButton from '@/components/forms/buttons/assessmentResult/TeamAssessButton.vue'
  import WorkAssessButton from '@/components/forms/buttons/assessmentResult/WorkAssessButton.vue'
  import bu from '../buttons/review/ProjectButton.vue'

  export default {
    data() {
      return {

        tableData: [{
            'index': '999',
            "nickName": "的旧时光",
            "name": "98491231841251"
          },
          {
            'index': '1',
            "nickName": "高贵",
            "name": "张"
          },
          {
            'index': '2',
            "nickName": "海aaa灰尘",
            "name": "小兰"
          }
        ],
        tHeader: ['序号', '昵称', '姓名'],
        filterVal: ['index', 'nickName', 'name'],
        excelName: 'aaaa',


        isDisabled: false,
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
      PaperButton,
      ProjectButton,
      PatentButton,
      TeamButton,
      WorkButton,
      ScientificButton,
      CollegeAssessButton,
      PaperAssessButton,
      PatentAssessButton,
      PersonalAssessButton,
      ProjectAssessButton,
      ScientificAssessButton,
      TeamAssessButton,
      WorkAssessButton,
      bu,
      ExcelDialog,

    },
    methods: {
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
