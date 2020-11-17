import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import BaseHeaderNav from '@/components/views/BaseHeaderNav'
import BaseSideNav from '@/components/views/BaseSideNav'
import Home from '@/components/views/Home'
import First from '@/components/views/First'
import Table from '@/components/table/table_interface/CommonsTableImpl'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/home',
      redirect: "/"
    },
    {
      path: '/header',
      name: 'BaseHeaderNav',
      component: BaseHeaderNav
    },
    {
      path: '/side',
      name: 'BaseSideNav',
      component: BaseSideNav
    },
    // 表格访问地址根据tableKey参数决定表格(如表头以及表格中的数据)
    {
      path: '/table/:tableKey',
      name: 'Table',
      component: Table
    }
   
  ]
})
