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

for (let i = 0; i < 5; i++) {
  let newsObj = {
    id: Random.csentence(3, 6),
    name: Random.csentence(3, 6),
    userName: Random.csentence(3, 6),
    collegeName: Random.csentence(3, 6),
    workType: Random.csentence(3, 6),
    discipline: Random.csentence(3, 6),
    firstDiscipline: Random.csentence(3, 6),
    workSource: Random.csentence(3, 6),
    beginDate: Random.csentence(3, 6),
    publisher: Random.csentence(3, 6),
    state: Random.csentence(3, 6),
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


