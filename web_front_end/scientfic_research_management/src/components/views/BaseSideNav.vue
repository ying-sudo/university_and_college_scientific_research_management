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
          <el-menu-item v-if="!parentHeaderLists[selectIndex].subMenu">
            <i class="el-icon-setting"></i>
            <span slot="title">{{ parentHeaderLists[selectIndex].title }}</span>
          </el-menu-item>

          <el-submenu
            v-else
            :index="parentHeaderLists[selectIndex].index"
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
              >{{ subMenu.title }}</el-menu-item>
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
      default: 0
    }
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
  },

  computed: {}
};
</script>

<style scoped></style>
