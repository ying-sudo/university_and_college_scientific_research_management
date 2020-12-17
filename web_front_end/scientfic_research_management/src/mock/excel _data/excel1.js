const Mock = require("mockjs")
const Random = Mock.Random
let articles = [];

Mock.mock('/api/pageList/batchDelete', 'delete', (params) => {
  console.log(params, '批量删除传参')
  let deleteArr = JSON.parse(params.body)
  console.log(deleteArr, 'deleteArr')
  // tableList = tableList.filter(val => !deleteArr.includes(val.id))
  return {
    code: '0',
    message: 'success',
    data: []
  }
})

for (let i = 0; i < 10; i++) {
  let newsObj = {
    data0: Random.csentence(3, 6),
    data1: Random.csentence(3, 6),
    data2: Random.csentence(3, 6),
    data3: Random.csentence(3, 6),
    data4: Random.csentence(3, 6),
    data5: Random.csentence(3, 6),
    data6: Random.csentence(3, 6),
  }
  articles.push(newsObj)
}

let response = {
  code: "1",
  msg: "请求成功",
  data: articles
};

export default response;

// Mock.mock("/api/table_data", "get", response);


