// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

import MuseUI from 'muse-ui'
import 'muse-ui/dist/muse-ui.css'
Vue.use(MuseUI)

// import Helpers from 'muse-ui/lib/Helpers';  //muse ui 的按钮波纹效果
// Vue.use(Helpers);

import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)

import echarts from "echarts";
Vue.prototype.$echarts = echarts

Vue.config.productionTip = false

// 引入mock
// require('./mock/index.js')

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
