import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import MuseUI from 'muse-ui'
import 'muse-ui/dist/muse-ui.css'

// import Layui from 'layui'
// import 'layui/lib/index.js'

Vue.use(ElementUI)
Vue.use(MuseUI)

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')

// $( ()=>{  //这里用到了jquery，所以要配置好jquery；
//     const configs = ['layer', 'laydate', 'laypage', 'laytpl', 'layedit',
//      'form', 'upload', 'tree', 'table', 'element', 'util',
//      'flow', 'carousel', 'rate', 'transfer' ];
//     layui.config( {
//          base : 'static/layui_exts/transfer/'   //配置 layui 第三方扩展组件存放的基础目录
//  } ).use( configs, ()=>{ new Vue({ el: '#app', store, router, components: { App }, template: '<App/>' }) } ) } )
