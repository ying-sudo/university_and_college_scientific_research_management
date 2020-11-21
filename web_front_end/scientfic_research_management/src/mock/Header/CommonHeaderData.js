let dataVal = {
  "headerLists": [
    {
      "index": "1",
      "title": "首页",
      "urlPath": "/home",
      "subMenu": null
    },
    {
      "index": "2",
      "title": "项目",
      "urlPath": "/projects",
      "subMenu": [
        {
          "index": "2-1",
          "title": "项目列表",
          "urlPath": "/table/projectlists",
          "subMenu": null
        },
        {
          "index": "2-2",
          "title": "经费列表",
          "urlPath": "/table/fundlists",
          "subMenu": null
        }
      ]
    },
    {
      "index": "3",
      "title": "成果",
      "urlPath": "/achievements",
      "subMenu": [
        {
          "index": "3-1",
          "title": "论文成果",
          "urlPath": "/papers",
          "subMenu": null
        },
        {
          "index": "3-2",
          "title": "著作成果",
          "urlPath": "/works",
          "subMenu": null
        },
        {
          "index": "3-3",
          "title": "科研成果",
          "urlPath": "/scientifics",
          "subMenu": null
        },
        {
          "index": "3-4",
          "title": "专利产品",
          "urlPath": "/patents",
          "subMenu": null
        }
      ]
    },
    {
      "index": "4",
      "title": "团队",
      "urlPath": "/teams",
      "subMenu": null
    },
    {
      "index": "5",
      "title": "考核结果",
      "urlPath": "/assessmentres",
      "subMenu": null
    },
    {
      "index": "6",
      "title": "统计报表",
      "urlPath": "/reports",
      "subMenu": null
    },
    {
      "index": "7",
      "title": "项目评审",
      "urlPath": "/reviews",
      "subMenu": [
        {
          "index": "7-1",
          "title": "项目批次",
          "urlPath": "/batch",
          "subMenu": null
        },
        {
          "index": "7-2",
          "title": "在线审评",
          "urlPath": "/online",
          "subMenu": null
        }
      ]
    },
    {
      "index": "8",
      "title": "考核",
      "urlPath": "/assessment",
      "subMenu": [
        {
          "index": "8-1",
          "title": "考核批次",
          "urlPath": "/batch",
          "subMenu": null
        },
        {
          "index": "8-2",
          "title": "项目考核",
          "urlPath": "/project",
          "subMenu": null
        },
        {
          "index": "8-3",
          "title": "成果考核",
          "urlPath": "/achievement",
          "subMenu": null
        },
        {
          "index": "8-4",
          "title": "个人考核",
          "urlPath": "/personal",
          "subMenu": null
        },
        {
          "index": "8-5",
          "title": "学院考核",
          "urlPath": "/college",
          "subMenu": null
        },
        {
          "index": "8-6",
          "title": "校级团队考核",
          "urlPath": "/team",
          "subMenu": null
        }
      ]
    },
    {
      "index": "9",
      "title": "机构及人员",
      "urlPath": "/institutions",
      "subMenu": [
        {
          "index": "9-1",
          "title": "院系机构",
          "urlPath": "/colleges",
          "subMenu": null
        },
        {
          "index": "9-2",
          "title": "科研人员",
          "urlPath": "/people",
          "subMenu": null
        }
      ]
    },
    {
      "index": "10",
      "title": "系统管理",
      "urlPath": "/admin",
      "subMenu": [
        {
          "index": "10-1",
          "title": "角色管理",
          "urlPath": "/roles",
          "subMenu": null
        },
        {
          "index": "10-2",
          "title": "分类设置",
          "urlPath": "/sorts",
          "subMenu": null
        }
      ]
    }
  ]
}

let response = {
  code: '200',
  msg: '请求成功',
  data: dataVal
}

export default response 

