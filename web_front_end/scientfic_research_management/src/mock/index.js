import Mock from 'mockjs'
import Test from './test'

Mock.mock('/api/test', 'post', () => {
  return Test.userInfo
})

// 这里引入模拟数据并约定请求地址以及方式，返回的数据
import CommonHeaderData from './Header/CommonHeaderData'
Mock.mock('/api/header', 'get', () => {
  return CommonHeaderData
})