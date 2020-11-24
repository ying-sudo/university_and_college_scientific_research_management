<template>
  <div>
    <el-row
      id="outer-container"
      :gutter="20"
    >
      <el-col
        :span="2"
        :offset="1"
      >
        <div class="grid-content bg-purple-dark"><span>可访问视图</span></div>
      </el-col>
      <el-col :span="21">
        <el-checkbox
          :indeterminate="isIndeterminate"
          v-model="checkAll"
          @change="handleCheckAllChange"
        >全选</el-checkbox>
      </el-col>

    </el-row>

    <el-row
      id="outer-container"
      :gutter="20"
    >

      <el-col
        :span="21"
        :offset="3"
        v-for="item in items"
        :key="item.index"
      >
        <div class="grid-content bg-purple-dark">
          <el-checkbox-group
            v-model="checkedItem"
            @change="handleCheckedItemChange"
          >
            <el-checkbox :label="item.title">{{ item.title }}</el-checkbox>

            <el-checkbox
              v-for="subItem in item.subMenu"
              :label="subItem.title"
              :key="subItem.index"
            >{{
              subItem.title
            }}</el-checkbox>
          </el-checkbox-group>

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
export default {
  data() {
    return {
      checkAll: false,
      // 默认选择的选项，对应items中每个对象的title
      checkedItem: [],
      // 所有的选项
      items: [],
      isIndeterminate: true,
      onLoad: false,
    };
  },
  methods: {
    /**
     * 点击全选按钮触发的事件
     */
    handleCheckAllChange(val) {
      let i = 0,
        j = 0,
        arr = [...this.items],
        tempArr = [];
      // arr.splice(arr.length - 2, 2);
      for (const iterator of arr) {
        tempArr[i++] = iterator.title;
        if (iterator.subMenu !== null) {
          for (const subMenuItemTitle of iterator.subMenu) {
            tempArr[i++] = subMenuItemTitle.title;
          }
          j = 0;
        }
      }
      console.log(tempArr);

      this.checkedItem = val ? tempArr : [];
      this.isIndeterminate = false;
      console.log(this.checkedItem);
    },

    /**
     * 点击某个选项触发的事件
     */
    handleCheckedItemChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.items.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.items.length;
      console.log(this.checkedItem);
    },

    /**
     * 点击保存按钮触发的事件
     */
    handleSubmit() {
      // 向服务端提交请求
      // this.axios.post(
      //   "http://172.20.10.4:9999/mangerSys/user/test",
      //   { id: "hello", password: "213" },
      //   // {
      //   //   headers: {
      //   //     "Content-Type": "application/json;charset=UTF-8",
      //   //   },
      //   // }
      // );

      this.axios({
        method: "post",
        url: "http://172.20.10.4:9999/mangerSys/user/test",
        data: {
          123124: ["首页", "法", "首页"],
        },
      });

      // this.onLoad = true;

      // 还要根据router中的url修改
      // this.handleGoBack();
    },

    /**
     * 点击返回按钮触发的事件
     */
    handleGoBack() {
      this.$router.go(-1);
    },
  },

  /**
   * 请求所有的视图数据，对应导航栏中所有的选项(包括子菜单中所有选项)，并赋值给items数组
   * 代表默认选项的checkedItem中存放所有默认选项的title属性
   */
  created: function () {
    this.axios.get("/api/header").then(
      (response) => {
        this.items = response.data.data.headerLists;
        let i = 0,
          j = 0,
          arr = [...this.items];
        arr.splice(arr.length - 2, 2);
        for (const iterator of arr) {
          this.checkedItem[i++] = iterator.title;
          if (iterator.subMenu !== null) {
            for (const subMenuItemTitle of iterator.subMenu) {
              this.checkedItem[i++] = subMenuItemTitle.title;
            }
            j = 0;
          }
        }
        console.log(this.checkedItem);
      },
      (response) => {
        console.log("request data error");
      }
    );
  },
};
</script>

<style scoped>
#outer-container {
  text-align: left;
  margin-top: 15px;
}

.el-checkbox {
  margin-left: 20px;
  width: 90px;
}
</style>