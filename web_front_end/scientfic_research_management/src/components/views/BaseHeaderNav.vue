<template>
  <div>
    <el-menu
      :default-active="selectIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item
        v-for="item in parentHeaderLists"
        :key="item.index"
        :index="item.index"
      >
        <router-link :to="getURL(item)">
          {{ item.title }}
        </router-link>
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
          @click="logout()"
        ></el-button>

      </el-menu-item>

    </el-menu>

  </div>
</template>

<script>
export default {
  name: "BaseHeaderNav",
  props: {
    parentHeaderLists: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
      activeIndex: "1",
      selectIndex: "1",
    };
  },

  mounted: function () {
    // console.log(this.parentHeaderLists);
  },
  methods: {
    handleSelect(key, keyPath) {
      // console.log("子组件 " + key, keyPath);
      this.selectIndex = key;
      // console.log("子组件 " + this.selectIndex);
      this.$emit("handelSelect", Number(this.selectIndex));
    },

    /**
     * 得到导航栏中按钮对应的url
     * 如果没有子菜单则直接返回对象中的urlPath,
     * 如果有则返回对象中的子菜单中第一个urlPath
     *
     * @param data中的headerLists参数，默认为第一条
     */
    getURL(
      menuObj = { index: "1", title: "首页", urlPath: "/home", subMenu: null }
    ) {
      let resURL = menuObj.urlPath;
      if (menuObj.subMenu != null) {
        resURL = menuObj.subMenu[0].urlPath;
      }
      // console.log(resURL);
      return resURL;
    },

    logout() {
      var token = sessionStorage.getItem('token');
      this.axios.defaults.headers.common["Authorization"] = token;
      this.axios.post(this.GLOBAL.BASE_URL + "/mangerSys/user/logout").then().catch((error) => {
        // console.log("log out fail")
      });
      sessionStorage.clear();
      this.$router.replace("/login")
    }
  },
};
</script>

<style>
#logoutbtn {
  float: right;
  /* margin-right: 10px; */
}
</style>
