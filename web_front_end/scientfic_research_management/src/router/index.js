import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Login from '@/components/login/Login.vue'
import InitPassword from '@/components/login/InitPassword.vue'
// import Table from '@/components/table/table_interface/CommonsTableImpl'
import Table from '@/components/table/table_impl/SPTableEnity'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/helloworld',
      name: 'helloworld',
      component: HelloWorld
    },
    {
      path: '/',
      redirect: "/login"
    },
    {
      path: '/home',
      name: 'Home',
      component: resolve => require(['@/components/views/Home'], resolve)
    },
    // {
    //   path: '/header',
    //   name: 'BaseHeaderNav',
    //   component: BaseHeaderNav
    // },
    // {
    //   path: '/side',
    //   name: 'BaseSideNav',
    //   component: BaseSideNav
    // },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/initPWD',
      name: 'InitPassword',
      component: InitPassword
    },
    // 表格访问地址根据tableKey参数决定表格(如表头以及表格中的数据)
    {
      path: '/table/:tableKey',
      name: 'Table',
      component: Table
    }
   
  ]
})
