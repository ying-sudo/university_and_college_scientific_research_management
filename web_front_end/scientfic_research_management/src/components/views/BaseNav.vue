<template>
  <div>
    <el-menu
      :default-active="activeIndex"
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
        ></el-button>

      </el-menu-item>

    </el-menu>

    <div>
      <el-row class="tac">

        <el-col>
          <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-menu-item
              v-if="headerLists[selectIndex - 1].subMenu === null"
              :index="selectIndex"
            >
              <i class="el-icon-setting"></i>
              <span slot="title">{{ headerLists[selectIndex - 1].title }}</span>
            </el-menu-item>
            <el-submenu
              v-else
              :index="selectIndex"
            >
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>{{ headerLists[selectIndex - 1].title}}</span>
              </template>
              <el-menu-item-group>
                <template slot="title">{{ headerLists[selectIndex - 1].title}}</template>
                <el-menu-item
                  v-for="submenu in headerLists[selectIndex - 1].subMenu"
                  :key="submenu.index"
                  :index="submenu.index"
                >{{ submenu.title }}</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <!-- <el-menu-item v-for="submenu in headerLists[1]" :key="submenu.id" :index="submenu.id">
          <i class="el-icon-setting"></i>
          <span slot="title">{{ submenu.title}}</span>
        </el-menu-item> -->

          </el-menu>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "BaseNav",
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

      selectIndex: "1",
    };
  },

  beforeMount: function () {
    // console.log("component before mount");
    this.getdata();
    // let str = this.getURL();
    // console.log(str);
  },

  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
      this.selectIndex = key;
    },

    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },

    getdata() {
      // console.log("header axios请求");
      this.axios
        .get("http://localhost:8080/static/BaseHeaderNavData.json", {})
        .then(
          (response) => {
            // console.log("header 有响应了");
            this.headerLists = response.data.headerLists;
            // console.log(this.headerLists);
          },
          (response) => {
            // console.log("header error");
          }
        );
    },

    /**
     * 得到导航栏中按钮对应的url
     * 如果没有子菜单则直接返回对象中的urlPath,
     * 如果有则返回对象中的urlPath和子菜单中第一个urlPath拼接后的url
     *
     * @param data中的headerLists参数，默认为第一条
     */
    getURL(
      menuObj = { index: "1", title: "首页", urlPath: "/home", subMenu: null }
    ) {
      let resURL = menuObj.urlPath;
      if (menuObj.subMenu != null) {
        resURL += menuObj.subMenu[0].urlPath;
      }
      // console.log(resURL);
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