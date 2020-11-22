<template>
  <div>
    <el-row id="outer-container">
      <el-col
        :span="2"
        :offset="1"
      >
        <div class="grid-content bg-purple-dark"><span>可访问视图</span></div>
      </el-col>
      <el-col
        :span="21"
      >
        <div class="grid-content bg-purple-dark">
          <el-checkbox-group
            v-model="checkedItem"
            @change="handleCheckedItemChange"
          >
            <el-checkbox
              v-for="item in items"
              :label="item"
              :key="item"
            >{{
              item
            }}</el-checkbox>
          </el-checkbox-group>
          <el-checkbox
            :indeterminate="isIndeterminate"
            v-model="checkAll"
            @change="handleCheckAllChange"
          >全选</el-checkbox>
        </div>
      </el-col>
    </el-row>
    <el-divider></el-divider>

    <el-button
      type="primary"
      @click="handleSubmit"
      :loading="onLoad"
    >保存</el-button>
    <el-button @click="handleGoBack">返回</el-button>
  </div>
</template>

<script>
const itemOptions = [
  "首页",
  "项目",
  "成果",
  "团队",
  "考核结果",
  "统计报表",
  "项目评审",
  "考核",
  "机构及人员",
  "系统管理",
];
export default {
  data() {
    return {
      checkAll: false,
      checkedItem: [
        "首页",
        "项目",
        "成果",
        "团队",
        "考核结果",
        "统计报表",
        "项目评审",
        "考核",
      ],
      items: itemOptions,
      isIndeterminate: true,
      onLoad: false,
    };
  },
  methods: {
    handleCheckAllChange(val) {
      this.checkedItem = val ? itemOptions : [];
      this.isIndeterminate = false;
      console.log(this.checkedItem);
    },
    handleCheckedItemChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.items.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.items.length;
      console.log(this.checkedItem);
    },
    handleSubmit() {
      // 向服务端提交请求
      this.onLoad = true;

      // 还要根据router中的url修改
      this.$router.push("/home");
    },

    handleGoBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped>
#outer-container {
  text-align: left;
  margin-top: 15px;
}
</style>