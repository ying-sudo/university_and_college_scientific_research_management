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
          urlPath: "/papers",
          subMenu: null
        },
        {
          id: "7",
          index: "3-2",
          title: "著作成果",
          urlPath: "/works",
          subMenu: null
        },
        {
          id: "8",
          index: "3-3",
          title: "科研成果",
          urlPath: "/scientifics",
          subMenu: null
        },
        {
          id: "9",
          index: "3-4",
          title: "专利产品",
          urlPath: "/patents",
          subMenu: null
        }
      ]
    },
    {
      id: "10",
      index: "4",
      title: "团队",
      urlPath: "/teams",
      subMenu: null
    },
    {
      id: "11",
      index: "5",
      title: "考核结果",
      urlPath: "/assessmentres",
      subMenu: null
    },
    {
      id: "12",
      index: "6",
      title: "统计报表",
      urlPath: "/reports",
      subMenu: null
    },
    {
      id: "13",
      index: "7",
      title: "项目评审",
      urlPath: "/reviews",
      subMenu: [
        {
          id: "14",
          index: "7-1",
          title: "项目批次",
          urlPath: "/batch",
          subMenu: null
        },
        {
          id: "15",
          index: "7-2",
          title: "在线审评",
          urlPath: "/online",
          subMenu: null
        }
      ]
    },
    {
      id: "16",
      index: "8",
      title: "考核",
      urlPath: "/assessment",
      subMenu: [
        {
          id: "17",
          index: "8-1",
          title: "考核批次",
          urlPath: "/batch",
          subMenu: null
        },
        {
          id: "18",
          index: "8-2",
          title: "项目考核",
          urlPath: "/project",
          subMenu: null
        },
        {
          id: "19",
          index: "8-3",
          title: "成果考核",
          urlPath: "/achievement",
          subMenu: null
        },
        {
          id: "20",
          index: "8-4",
          title: "个人考核",
          urlPath: "/personal",
          subMenu: null
        },
        {
          id: "21",
          index: "8-5",
          title: "学院考核",
          urlPath: "/college",
          subMenu: null
        },
        {
          id: "22",
          index: "8-6",
          title: "校级团队考核",
          urlPath: "/team",
          subMenu: null
        }
      ]
    },
    {
      id: "23",
      index: "9",
      title: "机构及人员",
      urlPath: "/institutions",
      subMenu: [
        {
          id: "24",
          index: "9-1",
          title: "院系机构",
          urlPath: "/colleges",
          subMenu: null
        },
        {
          id: "25",
          index: "9-2",
          title: "科研人员",
          urlPath: "/people",
          subMenu: null
        }
      ]
    },
    {
      id: "26",
      index: "10",
      title: "系统管理",
      urlPath: "/admin",
      subMenu: [
        {
          id: "27",
          index: "10-1",
          title: "角色管理",
          urlPath: "/roles",
          subMenu: null
        },
        {
          id: "28",
          index: "10-2",
          title: "分类设置",
          urlPath: "/sorts",
          subMenu: null
        },
        {
          id: "29",
          index: "10-3",
          title: "权限设置",
          urlPath: "/table/authoritylists",
          subMenu: null
        }
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
