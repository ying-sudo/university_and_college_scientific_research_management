import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BaseHeaderNav from '@/components/views/BaseHeaderNav'
import BaseSideNav from '@/components/views/BaseSideNav'
import Home from '@/components/views/Home'
import Login from '@/components/login/login.vue'
import InitPassword from '@/components/login/InitPassword.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/helloworld',
      name: 'helloworld',
      component: HelloWorld
    },
    // {
    //   path: '/',
    //   redirect: "/login"
    // },
    {
      path: '/home',
      name: 'Home',
      components: Home
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
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/InitPWD',
      name: 'InitPWD',
      components: InitPassword
    }
  ]
})
