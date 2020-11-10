import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import BaseHeaderNav from '@/components/views/BaseHeaderNav'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/header',
      name: 'HeaderNav',
      component: BaseHeaderNav
    }
  ]
})
