import Mock from "mockjs";
import Test from "./test";

Mock.mock("/api/test", "post", () => {
  return Test.userInfo;
});

// 这里引入模拟数据并约定请求地址以及方式，返回的数据
import CommonHeaderData from "./Header/CommonHeaderData";
Mock.mock("/api/header", "post", () => {
  return CommonHeaderData;
});

// import TableDataTest from './TableDataTest'
// Mock.mock('/api/table_data', 'get', () => {
//   return TableDataTest
// })

import project from './home/project.js';
Mock.mock("/api/project/college", "post", ()=> {
  return project;
});
import findall from './home/findAll.js';
Mock.mock("/api/project/all", "post", ()=> {
  return findall;
});

import TableDataTest from "./TableDataTest";
Mock.mock("/api/table_data", "get", () => {
  return  TableDataTest;
});

import TableDataTest1 from "./TableDataTest";
Mock.mock("/api/table_data1", "delete", () => {
  return  TableDataTest1;
});
