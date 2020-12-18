<template>
  <!-- 论文成果按钮 -->
  <div>

    <mu-container>
      <!-- 表单按钮 -->
      <mu-flex justify-content="center">
        <div v-if="!isDisabled">
          <el-button @click="openAlertDialog" type="primary" :loading="loading">
            论文成果申报&nbsp;&nbsp;
            <i right class="el-icon-document-add"></i>
          </el-button>
        </div>
        <div v-if="isDisabled">
          <el-tooltip effect="light" content="论文详情" placement="bottom-end" :open-delay="500">
            <el-button icon="el-icon-view" type="text" @click="openAlertDialog" style="color: #545C64; font-size: 18px;"></el-button>
          </el-tooltip>
        </div>
      </mu-flex>

      <PaperForm v-if="flag.openAlert" :key="reload" v-model="flag" :collegeInfo="collegeInfo" :firstDisciplineProp="firstDiscipline"
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
        loading: false,
        paperId: null,
        //收录，一级学科
        collegeInfo: [],
        firstDiscipline: [],
        magazineSort: [],
        magazineId: [],
        otherAll: [
          [],
        ],
      };
    },
    components: {
      PaperForm,
    },
    methods: {
      openAlertDialog() {
        this.loading = true;
        this.reload = new Date().getTime();

        // this.axios
        //   .get(this.GLOBAL.BASE_URL + "/mangerSys/sorts/" + )

        this.firstDiscipline = this.otherAll[0];

        this.getAllData();
      },
      getAllData() {

        Global.methods.getCollegeData(this, this.collegeInfo);

        var i = [1];
        Global.methods.getFormData(this, i, 0, this.otherAll);

        if (this.flag.isDisabled) {
          //修改的按钮
          this.axios
            .get(
              this.GLOBAL.BASE_URL + "/mangerSys/magazine/" + this.TableRow.id,
            )
            .then((response) => {
              console.log('begin111');
              console.log(response);
              if (response.data.resultCode == 0) {
                this.magazineSort = response.data.data.magazineSort;
                this.magazineId = response.data.data.magazineId;
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        } else {
          this.axios
            .get(
              this.GLOBAL.BASE_URL + "/mangerSys/magazine"
            )
            .then((response) => {
              console.log(response);
              if (response.data.resultCode == 0) {
                this.magazineSort = response.data.data;
                // this.magazineId = response.data.data.magazineId;
              }
            })
            .catch((error) => {
              this.loading = false;
              Global.methods.message_error(this, '网络或服务器错误，请稍后重试');
            });
        }

        return;
      },
    },
  };
</script>

<style>
</style>
