import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BaseHeaderNav from '@/components/views/BaseHeaderNav'
import BaseSideNav from '@/components/views/BaseSideNav'
import Home from '@/components/views/Home'
import Login from '@/components/login/Login.vue'
import InitPassword from '@/components/login/InitPassword.vue'
// import Table from '@/components/table/table_interface/CommonsTableImpl'
// import Table from '@/components/table/table_impl/AuthorityTableEnity'
// import Icon from '@/components/table/table_impl/AuthorityTableEnity'
import TestTable from '@/components/table/test_eltable'
import FormFrame from '@/components/forms/global/FormFrame.vue'



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
      component: Home
    },
    {
      path: '/first',
      name: 'First',
      component: resolve => require(['@/components/views/First'], resolve)
    },
    {
      path: '/author',
      name: 'Authority',
      component: resolve => require(['@/components/views/Authority'], resolve)
    },
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
    {
      path: '/@',
      name: 'TestTable',
      component: TestTable
    },
    // 表格访问地址根据tableKey参数决定表格(如表头以及表格中的数据)
    {
      path: '/table/:tableKey',
      name: 'Table',
      // component: Table
      component: resolve => require(['@/components/table/table_impl/TableEnity'], resolve)
    }, {
      path: '/noIdtable/:tableKey',
      name: 'LogTable',
      component: resolve => require(['@/components/table/table_impl/NoIdTableEnity'], resolve)
    }, {
      path: '/teams/member',
      name: 'Member',
      component: resolve => require(['@/components/table/table_impl/TeamMemberTable'], resolve)
    },
    {
      path: '/role/member',
      name: 'Member',
      component: resolve => require(['@/components/table/table_impl/RoleMemberTableEnity'], resolve)
    },
    {
      path: '/roletable/:roleid',
      name: 'RoleMember',
      component: resolve => require(['@/components/table/table_impl/RoleMemberTable'], resolve)

    },
    {
      path: '/form/:formKey',
      name: 'Form',
      component: FormFrame
    }
  ]
})
