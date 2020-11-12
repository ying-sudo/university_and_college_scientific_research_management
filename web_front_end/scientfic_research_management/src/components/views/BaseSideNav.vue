<template>
  <div>
    <el-row class="tac">
      <el-col>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item
            v-if="!parentHeaderLists[selectIndex].subMenu"
            @click="getURL(parentHeaderLists[selectIndex], parentHeaderLists[selectIndex].index)"
          >
            <i class="el-icon-setting"></i>
            <span slot="title">{{ parentHeaderLists[selectIndex].title }}
              <router-link :to="getURL(parentHeaderLists[selectIndex], parentHeaderLists[selectIndex].index)"></router-link>
            </span>
          </el-menu-item>

          <el-submenu
            v-else
            :index="parentHeaderLists[selectIndex].index"
            :key="parentHeaderLists[selectIndex].index"
          >
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{ parentHeaderLists[selectIndex].title }}</span>
            </template>
            <el-menu-item-group>
              <template slot="title">{{ parentHeaderLists[selectIndex].title }}</template>
              <el-menu-item
                v-for="subMenu in parentHeaderLists[selectIndex].subMenu"
                :key="subMenu.index"
                :index="subMenu.index"
              >
                <router-link :to="getURL(subMenu, subMenu.index)">{{ subMenu.title }}</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>

        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  props: {
    parentHeaderLists: {
      type: Array,
      default: () => [],
    },
    selectIndex: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      menuItem: {},
    };
  },

  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },

    /**
     * 得到跳转的url
     * @param subMenu: headerLists中的其中一个元素
     * @param index: 鼠标点击的位置
     */
    getURL: function (subMenu, index) {
      // console.log("getURL: "+index)
      let path = "";
      let arr = subMenu.index.split("-");
      // console.log(arr);
      let menuObj = this.parentHeaderLists[Number(arr[0]) - 1];
      path += menuObj.urlPath;
      // console.log(path)

      for (let i = 1; i < arr.length; i++) {
        menuObj = menuObj.subMenu[Number(arr[i]) - 1];
        path += menuObj.urlPath;
      }
      console.log(path);

      return path;
    },
  },

  computed: {},
};
</script>

<style scoped>
a {
  color: rgb(255, 255, 255);
}
.router-link-exact-active {
  /* 路由点击后的样式 */
  /* 添加需要的样式 */
  color: #ffd04b;
}
</style>
