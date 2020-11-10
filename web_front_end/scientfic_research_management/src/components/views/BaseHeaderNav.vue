<template>

  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <el-menu-item
      v-for="item in headerLists"
      :key="item.index"
      :index="item.index"
    >
      {{ item.title }}
    </el-menu-item>

    <el-menu-item
      index="11"
      id="logoutbtn"
      style="margin-right: 0px"
    >
      <el-button
        type="danger"
        size="medium"
        round
        icon="el-icon-switch-button"
      ></el-button>

    </el-menu-item>

  </el-menu>

</template>

<script>
export default {
  name: "BaseHeaderNav",
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      headerLists: [
        { index: "1", title: "", urlPath: "", subMenu: null },
        { index: "2", title: "", urlPath: "", subMenu: null },
        { index: "3", title: "", urlPath: "", subMenu: null },
        { index: "4", title: "", urlPath: "", subMenu: null },
        { index: "5", title: "", urlPath: "", subMenu: null },
        { index: "6", title: "", urlPath: "", subMenu: null },
        { index: "7", title: "", urlPath: "", subMenu: null },
        { index: "8", title: "", urlPath: "", subMenu: null },
        { index: "9", title: "", urlPath: "", subMenu: null },
        { index: "10", title: "", urlPath: "", subMenu: null },
      ],
    };
  },

  beforeMount: function () {
    // console.log("component before mount");
    this.getdata();
    let str = this.getURL();
    console.log(str);
  },

  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },

    getdata() {
      console.log("header axios请求");
      this.axios
        .get("http://localhost:8080/static/BaseHeaderNavData.json", {})
        .then(
          (response) => {
            console.log("header 有响应了");
            this.headerLists = response.data.headerLists;
            console.log(this.headerLists);
          },
          (response) => {
            console.log("header error");
          }
        );
    },

    getURL(
      menuObj = { index: "1", title: "首页", urlPath: "/home", subMenu: null }
    ) {
      let resURL = menuObj.urlPath;
      if (menuObj.subMenu != null) {
        for (let index = 0; index < subMenu.length; index++) {
          const element = subMenu[index];
          resURL += element.urlPath;
        }
      }
      return resURL;
    },
  },
};
</script>

<style scoped>
#logoutbtn {
  float: right;
  /* margin-right: 10px; */
}
</style>
