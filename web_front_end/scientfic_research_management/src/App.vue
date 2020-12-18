<template>
  <div id="app">
    <el-container id="out-container">

      <el-header v-if="isLoginPage">
        <headernav
          v-if="headerLists.length>0"
          :parentHeaderLists="headerLists"
          @handelSelect="headerClick"
        ></headernav>
      </el-header>

      <el-container>
        <el-aside
          width="14%"
          v-if="isLoginPage"
        >
          <sidenav
            v-if="headerLists.length>0"
            :parentHeaderLists="headerLists"
            :selectIndex="parentSelectIndex - 1"
          ></sidenav>

        </el-aside>
        <el-main>
          <router-view v-if="isRouterShow"></router-view>
        </el-main>
      </el-container>

    </el-container>
  </div>
</template>

<script>
import headernav from "@/components/views/BaseHeaderNav";
import sidenav from "@/components/views/BaseSideNav";

export default {
  components: {
    headernav: headernav,
    sidenav: sidenav,
  },
   provide () {
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      headerLists: [],
      parentSelectIndex: 1,
      isRouterShow: true,
    };
  },

  created: function () {
    if (this.$route.path !== "/login" && this.$route.path !== "/initPWD") {
      this.getHeaderData();
    }
  },

  computed: {
    /**
     * 判断当前url是否为登录页面的url
     * 如果是则不渲染导航栏，
     * 如果不是则渲染
     */
    isLoginPage: function () {
      return this.$route.path !== "/login" && this.$route.path !== "/initPWD";
    },
  },

  methods: {
    headerClick(key) {
      this.parentSelectIndex = key;
      // console.log(this.parentSelectIndex);
    },

    getHeaderData(requestUrl) {
      this.headerLists = JSON.parse(sessionStorage.getItem("home")).headerLists;
    },

    //刷新当前组件
    async reload () {
      this.isRouterShow = false
      await this.$nextTick()
      this.isRouterShow = true
    }
  },

  watch: {
    $route(to, from) {
      if (this.$route.path !== "/login" && this.$route.path !== "/initPWD") {
        this.getHeaderData();
        // console.log(this.headerLists)
      }
    },
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  font-size: xx-large !important;
  color: #2c3e50;
  height: 100%;
}

#out-container {
  flex-direction: column;
}

.el-container {
  min-height: 100%;
  /* flex-direction: column; */
}

.el-header,
.el-footer {
  /* background-color: #b3c0d1; */
  color: #333;
  text-align: center;
  line-height: 60px;
  margin-top: 10px;
  display: block;
}

.el-aside {
  /* background-color: #d3dce6; */
  display: block;
  position: relative;

  /* ���������� */
  overflow-y: auto;
  scrollbar-width: none;
  /* firefox */
  -ms-overflow-style: none;
  /* IE 10+ */
  overflow-x: hidden;

  /* background-color: #324157 !important; */
  margin: 8px 6px 0px 20px;
  color: #333;
  text-align: center;
  /* line-height: 200px; */
  width: 200px;
  /* min-height: 300px; */
}

/* ���������� */
.el-aside::-webkit-scrollbar {
  display: none;
  /* Chrome Safari */
}

.el-main {
  margin: 8px 20px 1px 3px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  /* background-color: #e9eef3; */
  /* height: 100%; */
  color: #333;
  text-align: center;
  font-size: xx-large;

  /* position: relative; */
  /* line-height: 160px; */
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

/* 解决表头数据和表格数据对不齐的问题 */
.el-table th.gutter{
   display: table-cell!important;
 }
</style>
