<template>
  <!-- 论文成果按钮 -->
  <div>

    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <mu-button @click="openAlertDialog" color="primary">
            论文成果申报&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </mu-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PaperForm v-if="canOpen" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
        :magazineSortProp="magazineSort" :magazineIdProp="magazineId" :TableRow="TableRow"></PaperForm>
    </mu-container>
  </div>
</template>

<script>
  import PaperForm from "@/components/forms/forms/PaperForm"
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: ["isDisabled", "TableRow"],
    model: {
      prop: "isDisabled",
      event: "click",
    },
    data() {
      return {
        flag: {
          openAlert: false,
          isDisabled: false,
        }, //论文成果表单
        reload: '',
        //收录，一级学科
        collegeInfo: [],
        firstDiscipline: [],
        magazineSort: [],
        magazineId: [],
        otherAll: {
          firstDiscipline: [],
        },
      };
    },
    created: function() {
      this.getAllData();
    },
    components: {
      PaperForm,
    },
    methods: {
      openAlertDialog() {
        this.reload = new Date().getTime();
        this.firstDiscipline = this.otherAll.firstDiscipline;



        Global.methods.openAlertDialog(this.flag, this.isDisabled);
      },
      getAllData() {

        Global.methods.getCollegeData(this, this.collegeInfo);
        Global.methods.getOtherData(this, this.otherAll);

        if (this.flag.isDisabled) {
          //修改的按钮

          this.axios
            .get(
              this.GLOBAL.BASE_URL + "/mangerSys/magazine",
              this.TableRow.id
            )
            .then((response) => {
              if (response.data.resultCode == 0) {
                this.magazineSort = response.data.data.magazineSort;
                this.magazineId = response.data.data.magazineId;
              }
            });
          // .catch((error) => {
          //   this.loading = false;
          //   Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
          // });
        }

        this.firstDiscipline = this.otherAll.firstDiscipline;
        return;
      },
    },
    computed: {
      canOpen() {
        var isEmpty = Global.methods.isEmpty(this.firstDiscipline, this.collegeInfo,
          this.magazineId, this.magazineSort);
        // isEmpty = true;
        return isEmpty;
      }
    }

  };
</script>

<style>
</style>
