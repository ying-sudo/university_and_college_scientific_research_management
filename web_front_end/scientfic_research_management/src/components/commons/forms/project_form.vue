<template>

  <div>
    <mu-container>
      <mu-flex justify-content="center">
        <mu-button @click="openAlertDialog" color="primary">
              项目申报表单&nbsp;&nbsp;
              <i right class="el-icon-document-add"></i>
        </mu-button>
      </mu-flex>

      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert">
        <div class="mu-dialog-title">
          项目申报表单
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 700px; overflow-y: scroll; padding: 10px;">
          <mu-container>
            <mu-form :model="form" class="mu-demo-form" :label-position="labelPosition" label-width="100">
              <mu-form-item prop="input" label="项目名称">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="项目编号">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="批准文号">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="负责人学工号">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="所在单位">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="项目级别">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="select" label="项目状态">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="项目性质">
                <mu-radio v-model="form.radio" value="male" label="横向"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="纵向"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="form.radio" value="male" label="理工科"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="社科"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="项目分类">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="select" label="项目子类">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="立项日期">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="结项日期">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="申请经费">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item prop="textarea" label="备注">
                <mu-text-field multi-line :rows="3" :rows-max="6" v-model="form.textarea"></mu-text-field>
              </mu-form-item>

            </mu-form>
          </mu-container>
        </div>

        <!-- 确定按钮 -->
        <div style="text-align: center;">
          <mu-button @click="closeAlertDialog" color="primary">
                确定申报&nbsp;&nbsp;
                <i right class="el-icon-upload"></i>
          </mu-button>
        </div>
      </mu-dialog>

    </mu-container>
  </div>

</template>


<script>
  export default {
    data() {
      return {
        options: [
          'Option 1', 'Option 2', 'Option 3', 'Option 4',
          'Option 5', 'Option 6', 'Option 7', 'Option 8',
          'Option 9', 'Option 10'
        ],
        labelPosition: 'top',
        form: {
          input: '',
          select: '',
          date: '',
          radio: '',
          textarea: ''
        },
        openAlert: false,
        openAlertProjectMessage: false
      };
    },
    methods: {
      openAlertDialog() {
        this.openAlert = true;
      },
      closeAlertDialog() {
        this.openAlert = false;
      }
    }
  };
</script>


<style>
  .mu-demo-form {
    width: 100%;
    max-width: 800px;
  }

  .mu-demo-min-form {
    width: 100%;
    max-width: 340px;
    padding-right: 40px;
    padding-left: 10px;
  }

  .float_left {
    float: left;
  }
</style>
