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

import TableDataTest1 from "./table_data/ProjectTableData";
Mock.mock("/api/table_data1", "delete", () => {
  return  TableDataTest1;
});

//项目列表模拟数据
import ProjectData from "./table_data/ProjectTableData";
Mock.mock("/api/table_data/project", "get", ProjectData);

//经费列表模拟数据
import FundsData from "./table_data/FundsTableData";
Mock.mock("/api/table_data/funds", "get", FundsData);

//项目考核列表模拟数据
import ProjectCheckResultData from "./table_data/ProjectCheckResultTableData";
Mock.mock("/api/table_data/project_check_result", "get", ProjectCheckResultData);

//项目导出到excel
import projectExcel from "./excel _data/projectExcel";
Mock.mock("/api/table_data/projectExcel", "get", projectExcel);
//论文导出到excel
import paperExcel from "./excel _data/paperExcel";
Mock.mock("/api/table_data/paperExcel", "get", paperExcel);
//著作导出到excel
import workExcel from "./excel _data/workExcel";
Mock.mock("/api/table_data/workExcel", "get", workExcel);
//科技成果导出到excel
import scientificExcel from "./excel _data/scientificExcel";
Mock.mock("/api/table_data/scientificExcel", "get", scientificExcel);
//专利导出到excel
import patentExcel from "./excel _data/patentExcel";
Mock.mock("/api/table_data/patentExcel", "get", patentExcel);
