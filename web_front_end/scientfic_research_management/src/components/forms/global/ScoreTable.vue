<template>
  <!-- 成绩框 -->

  <div style="width: 180px; height: 210px; border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); float: left;">
    <div style="font-size: 30px; margin-top: 20px;">
      考核结果
    </div>
    <el-divider></el-divider>
    <el-input ref="score" v-model="evaluationResult.score" :disabled="scoreDisabled"></el-input>
    <div>
      <div v-if="!scoreDisabled">
        <mu-button style="margin-top: 20px;" @click="makeScore" color="primary">
          确定&nbsp;&nbsp;
          <i right class="el-icon-check"></i>
        </mu-button>
      </div>
      <div v-else>
        <mu-button style="margin-top: 20px;" @click="editScore" color="primary">
          修改&nbsp;&nbsp;
          <i right class="el-icon-edit"></i>
        </mu-button>
      </div>
    </div>
  </div>

</template>

<script>
  import Global from '@/components/forms/global/global.vue'

  export default {
    props: [
      "flag",
      "id",
      "sort",
    ],
    data() {
      return {
        notDisabled: true, //成绩能否修改，true为不能
        scoreDisabled: true,
        evaluationResult: {
          id: null,
          score: null,
          sort: null,
          datename: null,
        },
      }
    },
    created: function() {
      if (!this.evaluationResult.score) {
        this.$nextTick(() => {
          this.$refs.score.focus();
        });
        this.scoreDisabled = false;
      }
      if (!this.flag.isDisabled) {
        this.enterScore();
      }
    },
    methods: {
      enterScore() {
        //回车进行成绩输入确定
        let that = this;
        document.onkeypress = function(e) {
          var keyCode = document.all ? event.keyCode : e.which;
          if (that.$route.path == "/helloworld" && keyCode == 13) {
            that.makeScore();
            return;
          }
        }
      },
      makeScore() { //成绩确定按钮
        if (this.evaluationResult.score == null || this.evaluationResult.score == '') {
          Global.methods.message_warning(this, '成绩不符合规范');
          this.evaluationResult.score = null;
          return false;
        }
        this.evaluationResult.score = this.evaluationResult.score * 1.0;
        //判断成绩是否符合规范
        if (this.evaluationResult.score >= 0 && this.evaluationResult.score <= 100) {
          this.evaluationResult.id = this.id;
          this.evaluationResult.sort = this.sort;
          this.evaluationResult.datename = null;
          Global.methods.message_success(this, '成绩输入成功');
          this.scoreDisabled = true;
          return true;
        } else {
          Global.methods.message_warning(this, '成绩不符合规范');
          this.evaluationResult.score = null;
          return false;
        }
      },
      makeButton() { //确定按钮
        if (this.evaluationResult.score && this.scoreDisabled) {
          this.closeAlertDialog();
        } else {
          Global.methods.message_warning(this, '请输入成绩');
        }
      },
      editScore() {
        //修改成绩
        this.scoreDisabled = false;
        //获取焦点
        this.$nextTick(() => {
          this.$refs.score.focus();
        });
      },
    },
  }
</script>

<style>
</style>
