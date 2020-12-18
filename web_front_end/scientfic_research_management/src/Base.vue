<template>
</template>

<script>
  // const BASE_URL = 'http://192.168.1.101:9999';
  // const BASE_URL = 'http://172.20.10.4:9999';
  const BASE_URL = 'http://192.168.43.229:9999';
  // const BASE_URL = 'http://192.168.43.25:9999';
  // const BASE_URL = 'http://172.20.10.4:9999';
  // const BASE_URL = 'http://192.168.43.229:9999';
  // const BASE_URL = 'http://127.0.0.1:9999/';
  // const BASE_URL = 'http://192.168.1.102:9999';
  // const BASE_URL = 'http://192.168.1.105:9999';
  // const BASE_URL = 'http://192.168.1.102:9999'; //313
  // const BASE_URL = 'http://172.20.10.6:9999';
  // const BASE_URL = 'http://192.168.1.106:9999';

  const rules = {
    name: [{
      required: true,
      message: '请输入名称'
    }],
    id: [{
      required: true,
      message: '请输入编号'
    }],
    userId: [{
      required: true,
      message: '请输入负责人学号'
    }], //负责人
    // collegeId: [{
    //   required: true,
    //   message: '请输入所在单位'
    // }], //所属学院
    discipline: [{
      required: true,
      message: '请输入学科门类'
    }], //学科门类
    characters: [{}, ], //项目性质
    firstDiscipline: [{
      required: true,
      message: '请输入一级学科'
    }], //一级学科
    level: [{
      required: true,
      message: '请输入级别'
    }], //项目级别
    sort: [{}], //项目分类
    beginDate: [{
      required: true,
      message: '请选择日期',
    }], //立项日期
    foundingTime: [{
      required: true,
      message: '请选择日期',
    }],
    applicationDate: [{
      required: true,
      message: '请选择日期'
    }],
    applicationId: [{
      required: true,
      message: '请输入编号'
    }],
    isbnId: [{
      required: true,
      message: '请输入ISBN编号'
    }],
    isTranslate: [{
      required: true,
      message: '请选择是否翻译'
    }],
    endDate: [{}], //结项日期
    researchDiection: [{
      required: true,
      message: '请填写研究方向'
    }],
    phone: [{
      required: true,
      message: '请填写电话'
    }],
    requestFund: [{
        required: true,
        message: '请输入申请经费'
      },
      {
        pattern: /^[+-]?(0|([1-9]\d*))(\.\d+)?$/g,
        message: '请输入数字'
      },
    ], //项目申请经费
    contribution: [{
        required: true,
        message: '请输入贡献'
      },
      {
        pattern: /^[+-]?(0|([1-9]\d*))(\.\d+)?$/g,
        message: '请输入数字'
      }
    ],
    arrivalFund: [{
      type: 'number',
      message: '请输入数字'
    }], //到账金额
    state: [{
        required: true,
        message: '请输入审核状态'
      },
      {
        type: 'number'
      },
    ], //审核状态
    approvalNumber: [{
      required: true,
      message: '请输入批准文号'
    }], //批准文号
    information: [{}], //项目信息
    user_name: [{
      required: true,
      message: '请输入名字'
    }],
    user_id: [{
      required: true,
      message: '请输入学号'
    }],
  };


  export default {
    BASE_URL,
    rules,
  }
</script>

<style>
</style>
