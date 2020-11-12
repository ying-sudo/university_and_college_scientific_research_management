<template>

  <div>
    <mu-container>
      <mu-flex justify-content="center">
        <mu-button @click="openAlertDialog" color="primary">
          著作申报表单&nbsp;&nbsp;
          <i right class="el-icon-document-add"></i>
        </mu-button>
      </mu-flex>

      <mu-dialog width="800" max-width="80%" :esc-press-close="false" :overlay-close="false" :open.sync="openAlert">
        <div class="mu-dialog-title">
          著作申报表单
          <mu-button fab small color="indigo" @click="closeAlertDialog">
            <i class="el-icon-close" style="font-size: 32px;"></i>
          </mu-button>
        </div>

        <!-- 表单内容 -->
        <div style="height: 700px; overflow-y: scroll; padding: 10px;">
          <mu-container>
            <mu-form :model="form" class="mu-demo-form" :label-position="labelPosition" label-width="100">
              <mu-form-item prop="input" label="著作题目">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="input" label="出版单位">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版社级别">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="著作类别">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版地">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form" prop="input" label="ISBN号">
                <mu-text-field v-model="form.input"></mu-text-field>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="是否翻译">
                <mu-radio v-model="form.radio" value="male" label="横向"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="纵向"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="翻译语种">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="学科门类">
                <mu-radio v-model="form.radio" value="male" label="横向"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="纵向"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="出版时间">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="radio" label="研究类别">
                <mu-radio v-model="form.radio" value="male" label="横向"></mu-radio>
                <mu-radio v-model="form.radio" value="female" label="纵向"></mu-radio>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="一级学科">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <mu-form-item class="mu-demo-min-form float_left" prop="select" label="成果归属">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>


              <mu-form-item class="mu-demo-min-form" prop="select" label="项目来源">
                <mu-select v-model="form.select">
                  <mu-option v-for="option,index in options" :key="option" :label="option" :value="option"></mu-option>
                </mu-select>
              </mu-form-item>

              <!-- 表单底部表格 -->
              <div style="padding: 10px;">
                <div style=" padding-top: 60px;">
                  <mu-button style="float: right; margin: 10px;" color="primary">
                    添加用户&nbsp;&nbsp;
                    <i class="el-icon-s-custom" style="float: right; "></i>
                  </mu-button>
                </div>

                <div style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
                  <el-table :data="tableData" style="width: 100%" max-height="250">
                    <el-table-column fixed prop="name" label="姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="province" label="省份" width="120">
                    </el-table-column>
                    <el-table-column prop="city" label="市区" width="120">
                    </el-table-column>
                    <el-table-column prop="address" label="地址" width="300">
                    </el-table-column>
                    <el-table-column prop="zip" label="邮编" width="120">
                    </el-table-column>
                    <el-table-column fixed="right" label="操作" width="120">
                      <template slot-scope="scope">
                        <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
                          移除
                        </el-button>
                        <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
                          编辑
                        </el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
              </div>

              <!-- 表单备注 -->
              <mu-form-item style="margin: 10px;" prop="textarea" label="备注">
                <mu-text-field style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);" multi-line
                  :rows="3" :rows-max="6" v-model="form.textarea"></mu-text-field>
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
        tableData: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-08',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-06',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-07',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }],
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
      },
      deleteRow(index, rows) {
        rows.splice(index, 1);
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
