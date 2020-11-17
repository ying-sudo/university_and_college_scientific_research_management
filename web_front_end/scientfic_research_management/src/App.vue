<template>
  <div id="frame">
    <el-container>

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
          <router-view></router-view>
        </el-main>
      </el-container>

    </el-container>
  </div>
</template>

<script>
import headernav from "@/components/views/BaseHeaderNav";
import sidenav from "@/components/views/BaseSideNav";

export default {
  components: { headernav: headernav, sidenav: sidenav },
  data() {
    return {
      headerLists: [],
      parentSelectIndex: 1,
    };
  },

  created: function () {
    // console.log("header axiosÇëÇó");
    this.axios.get("http://localhost:8080/static/BaseHeaderNavData.json").then(
      (response) => {
        // console.log("header ÓĞÏìÓ¦ÁË");
        this.headerLists = response.data.headerLists;
        // console.log(this.parentHeaderLists);
      },
      (response) => {
        console.log("header error");
      }
    );
  },

  computed: {
    /**
     * åˆ¤æ–­å½“å‰urlæ˜¯å¦ä¸ºç™»å½•é¡µé¢çš„url
     * å¦‚æœæ˜¯åˆ™ä¸æ¸²æŸ“å¯¼èˆªæ ï¼Œ
     * å¦‚æœä¸æ˜¯åˆ™æ¸²æŸ“
     */
    isLoginPage: function () {
      return this.$route.path !== "/login";
    },
  },

  methods: {
    headerClick(key) {
      this.parentSelectIndex = key;
      console.log(this.parentSelectIndex);
    },
  },
};
</script>

<style>
#frame {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.el-header,
.el-footer {
  /* background-color: #b3c0d1; */
  color: #333;
  text-align: center;
  line-height: 60px;
  margin-top: 10px;
}

.el-aside {
  /* background-color: #d3dce6; */
  display: block;
  position: relative;

  /* ¹ö¶¯ÌõÒş²Ø */
  overflow-y: auto;
  scrollbar-width: none; /* firefox */
  -ms-overflow-style: none; /* IE 10+ */
  overflow-x: hidden;

  background-color: #324157 !important;
  margin: 8px 6px 0px 20px;
  color: #333;
  text-align: center;
  /* line-height: 200px; */
  width: 200px;
  /* min-height: 300px; */
}

/* ¹ö¶¯ÌõÒş²Ø */
.el-aside::-webkit-scrollbar {
  display: none; /* Chrome Safari */
}

.el-main {
  margin: 8px 20px 1px 3px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  /* background-color: #e9eef3; */
  color: #333;
  text-align: center;
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
</style>
