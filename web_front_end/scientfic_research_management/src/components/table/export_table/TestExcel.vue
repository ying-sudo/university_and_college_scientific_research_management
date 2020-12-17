<template>
  <el-button
    type="primary"
    icon="el-icon-download"
    @click="_export"
    size="medium"
    >导出到execl</el-button
  >
</template>

<script>
import FileSaver from "file-saver";
import XLSX from "xlsx";
export default {
  data() {
    return {
      projectTableData: [],
      paperTableData: [],
      workTableData: [],
      scientificTableData: [],
      patentTableData:[],
    };
  },
  methods: {
    _export() {
      //需要导出的JSON数据

      const data = {
        项目: this.projectTableData,
        论文: this.paperTableData,
        著作: this.workTableData,
        科技成果: this.scientificTableData,
        专利: this.patentTableData,
      };

      console.log("excel data");
      console.log(data);

      let columnHeaders = {
        项目: {
          id: "项目编号",
          name: "项目名字",
          userName: "项目负责人",
          discipline: "学科分类",
          firstDiscipline: "第一学科",
          requestFund: "申请金额",
          beginDate: "项目开始日期",
          state: "审核状态",
        },

        论文: {
          id: "论文编号",
          name: "论文名字",
          userName: "撰写人",
          collegeName: "所属院校",
          paperType: "论文类型",
          discipline: "学科分类",
          firstDiscipline: "第一学科",
          paperSource: "论文来源",
          beginDate: "撰写日期",
          state: "审核状态",
        },

        著作: {
          id: "著作编号",
          name: "著作名字",
          userName: "撰写人",
          collegeName: "所属院校",
          workType: "著作类型",
          discipline: "学科分类",
          firstDiscipline: "第一学科",
          workSource: "论文来源",
          beginDate: "撰写日期",
          publisher:"出版社",
          state: "审核状态",
        },

        科技成果: {
          id: "科研成果编号",
          name: "科研成果名称",
          userName: "发明人",
          collegeName: "归属单位",
          characters: "研究类别",
          discipline: "学科分类",
          firstDiscipline: "第一学科",
          beginDate: "发表日期",
          state: "审核状态",
        },

        专利: {
          id: "科研成果编号",
          name: "科研成果名称",
          userName: "发明人",
          collegeName: "归属单位",
          patentType: "专利类型",
          patentRange:"专利范围",
          applicationDate:"申请日期",
          impowerDate: "授权日期",
          state: "审核状态",
        },

      };

      //每一列的宽度
      let wscols = [
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
        { wch: 12 },
      ]; //设置字段宽度

      let sheetNames = [];
      let sheetsList = {};
      const wb = XLSX.utils.book_new();

      for (let key in data) {
        sheetNames.push(key);
        let columnHeader = columnHeaders[key]; // 此处是每个sheet的表头
        let temp = this.transferData(data[key], columnHeader);
        sheetsList[key] = XLSX.utils.aoa_to_sheet(temp);
        sheetsList[key]["!cols"] = wscols;
      }

      wb["SheetNames"] = sheetNames;
      wb["Sheets"] = sheetsList;
      XLSX.writeFile(wb, "通讯录.xlsx");
    },

    transferData(data, columnHeader) {
      let content = [],
        header = [];

      for (let i in columnHeader) {
        header.push(columnHeader[i]);
      }

      content.push(header);
      data.forEach((item, index) => {
        let arr = [];
        for (let i in columnHeader) {
          arr.push(item[i]);
        }

        content.push(arr);
      });

      return content;
    },

    baseData() {
      this.axios.get("/api/table_data/projectExcel").then((res) => {
        this.projectTableData = res.data.data;
      });

      this.axios.get("/api/table_data/paperExcel").then((res) => {
        this.paperTableData = res.data.data;
      });

      this.axios.get("/api/table_data/scientificExcel").then((res) => {
        this.scientificTableData = res.data.data;
      });

      this.axios.get("/api/table_data/workExcel").then((res) => {
        this.workTableData = res.data.data;
      });

      this.axios.get("/api/table_data/patentExcel").then((res) => {
        this.patentTableData = res.data.data;
      });
    },

  },
  created() {
    this.baseData();
  },
};
</script>


<style scoped>
</style>

