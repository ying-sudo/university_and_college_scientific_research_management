let dataVal = {
  headerLists: [
    {
      id: "1",
      index: "1",
      title: "首页",
      urlPath: "/home",
      subMenu: null
    },
    {
      id: "2",
      index: "2",
      title: "项目",
      urlPath: "/projects",
      subMenu: [
        {
          id: "3",
          index: "2-1",
          title: "项目列表",
          urlPath: "/table/projectlists",
          subMenu: null
        },
        {
          id: "4",
          index: "2-2",
          title: "经费列表",
          urlPath: "/table/fundlists",
          subMenu: null
        }
      ]
    },
    {
      id: "5",
      index: "3",
      title: "成果",
      urlPath: "/achievements",
      subMenu: [
        {
          id: "6",
          index: "3-1",
          title: "论文成果",
          urlPath: "/table/papers",
          subMenu: null
        },
        {
          id: "7",
          index: "3-2",
          title: "著作成果",
          urlPath: "/table/works",
          subMenu: null
        },
        {
          id: "8",
          index: "3-3",
          title: "科研成果",
          urlPath: "/table/scientifics",
          subMenu: null
        },
        {
          id: "9",
          index: "3-4",
          title: "专利产品",
          urlPath: "/table/patents",
          subMenu: null
        }
      ]
    },
    {
      id: "10",
      index: "4",
      title: "团队",
      urlPath: "/table/teams",
      subMenu: null
    },
    {
      id: "11",
      index: "5",
      title: "考核结果",
      urlPath: "/assessmentres",
      subMenu: [
        // {
        //   id: "33",
        //   index: "5-1",
        //   title: "考核结果批次",
        //   urlPath: "/table/result_batch",
        //   subMenu: null
        // },
        {
          id: "34",
          index: "5-2",
          title: "项目考核结果",
          urlPath: "/table/project_result",
          subMenu: null
        },
        {
          id: "35",
          index: "5-3",
          title: "论文考核结果",
          urlPath: "/table/paper_result",
          subMenu: null
        }, {
          id: "36",
          index: "5-4",
          title: "著作考核结果",
          urlPath: "/table/work_result",
          subMenu: null
        }, {
          id: "37",
          index: "5-5",
          title: "科研成果考核结果",
          urlPath: "/table/scientific_result",
          subMenu: null
        },
        {
          id: "38",
          index: "5-6",
          title: "专利考核结果",
          urlPath: "/table/patent_result",
          subMenu: null
        },
        // {
        //   id: "39",
        //   index: "5-7",
        //   title: "个人考核结果",
        //   urlPath: "/table/personal_result",
        //   subMenu: null
        // },
        // {
        //   id: "40",
        //   index: "5-8",
        //   title: "学院考核结果",
        //   urlPath: "/table/college_result",
        //   subMenu: null
        // },
        // {
        //   id: "41",
        //   index: "5-9",
        //   title: "校级团队考核结果",
        //   urlPath: "/table/team_result",
        //   subMenu: null
        // }
      ]
    },
    {
      id: "12",
      index: "6",
      title: "统计报表",
      urlPath: "/reports",
      subMenu: [
        {
          id: "45",
          index: "7-1",
          title: "统计报表",
          urlPath: "/table/reports",
          subMenu: null
        }
      ]
    },
    // {
    //   id: "13",
    //   index: "7",
    //   title: "项目评审",
    //   urlPath: "/reviews",
    //   subMenu: [
    //     {
    //       id: "14",
    //       index: "7-1",
    //       title: "项目批次",
    //       urlPath: "/table/batch",
    //       subMenu: null
    //     },
    //     {
    //       id: "15",
    //       index: "7-2",
    //       title: "在线审评",
    //       urlPath: "/online",
    //       subMenu: null
    //     }
    //   ]
    // },
    {
      id: "16",
      index: "7",
      title: "考核",
      urlPath: "/assessment",
      subMenu: [
        // {
        //   id: "17",
        //   index: "8-1",
        //   title: "考核批次",
        //   urlPath: "/table/batch",
        //   subMenu: null
        // },
        {
          id: "18",
          index: "7-2",
          title: "项目考核",
          urlPath: "/table/project_check",
          subMenu: null
        },
        {
          id: "19",
          index: "7-3",
          title: "论文考核",
          urlPath: "/table/paper_check",
          subMenu: null
        }, {
          id: "42",
          index: "7-4",
          title: "著作考核",
          urlPath: "/table/work_check",
          subMenu: null
        }, {
          id: "43",
          index: "7-5",
          title: "科研成果考核",
          urlPath: "/table/scientific_check",
          subMenu: null
        },
        {
          id: "44",
          index: "7-6",
          title: "专利考核",
          urlPath: "/table/patent_check",
          subMenu: null
        },
        // {
        //   id: "20",
        //   index: "8-7",
        //   title: "个人考核",
        //   urlPath: "/table/personal",
        //   subMenu: null
        // },
        // {
        //   id: "21",
        //   index: "8-8",
        //   title: "学院考核",
        //   urlPath: "/table/college",
        //   subMenu: null
        // },
        // {
        //   id: "22",
        //   index: "8-9",
        //   title: "校级团队考核",
        //   urlPath: "/table/team",
        //   subMenu: null
        // }
      ]
    },
    {
      id: "23",
      index: "8",
      title: "机构及人员",
      urlPath: "/institutions",
      subMenu: [
        {
          id: "24",
          index: "8-1",
          title: "院系机构",
          urlPath: "/noIdtable/collegesdep",
          subMenu: null
        },
        {
          id: "25",
          index: "8-2",
          title: "科研人员",
          urlPath: "/noIdtable/researchers",
          subMenu: null
        }
      ]
    },
    {
      id: "26",
      index: "9",
      title: "系统管理",
      urlPath: "/admin",
      subMenu: [
        {
          id: "27",
          index: "9-1",
          title: "角色管理",
          urlPath: "/noIdtable/roles",
          subMenu: null
        },
        // {
        //   id: "28",
        //   index: "9-2",
        //   title: "分类设置",
        //   urlPath: "/sorts",
        //   subMenu: null
        // },
        {
          id: "29",
          index: "9-3",
          title: "权限设置",
          urlPath: "/noIdtable/authoritylists",
          subMenu: null
        },
        {
          id: "30",
          index: "9-4",
          title: "登录日志记录",
          urlPath: "/noIdtable/loginlog",
          subMenu: null
        },
        {
          id: "31",
          index: "9-5",
          title: "系统日志记录",
          urlPath: "/noIdtable/systemlog",
          subMenu: null
        }, {
          id: "32",
          index: "9-6",
          title: "操作日志记录",
          urlPath: "/noIdtable/operationlog",
          subMenu: null
        },
      ]
    }
  ]
};

let response = {
  resultCode: "0",
  resultMsg: "请求成功",
  data: dataVal
};

export default response;
