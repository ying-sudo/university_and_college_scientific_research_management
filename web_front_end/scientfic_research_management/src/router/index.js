import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import BaseHeaderNav from '@/components/views/BaseHeaderNav'
import BaseSideNav from '@/components/views/BaseSideNav'
import Home from '@/components/views/Home'
import First from '@/components/views/First'

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
      path: '/header',
      name: 'BaseHeaderNav',
      component: BaseHeaderNav
    },
    {
      path: '/side',
      name: 'BaseSideNav',
      component: BaseSideNav
    },
    // {
    //   path: '/first',
    //   component: First
    // }
  ]
})
