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
  methods: {
    _export() {
      //需要导出的JSON数据
      const data = {
        基本信息: this.baseData(),
        历史信息: this.history1(),
      };

      let columnHeaders = {
        基本信息: {
          data0: "主管单位或镇街道",
          data1: "单位",
          data2: "分管领导",
          data4: "固定电话",
          data5: "移动电话",
          data6: "任职时间",
        },

        历史信息: {
          extra: "主管单位或镇街道",
          data0: "单位",
          data1: "分管领导",
          data2: "职务",
          data3: "固定电话",
          data4: "移动电话",
          data5: "任职时间",
          data6: "离职时间",
        },
      };

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
      return [
        {
          data0: "虹桥街道",
          data1: "大数据中心",
          data2: "吴",
          data3: "副主任",
          data4: "025-88888888",
          data5: "13000000000",
          data6: "2019-12-14",
        },
        {
          data0: "崇川街道",
          data1: "大数据中心",
          data2: "成",
          data3: "科长",
          data4: "025-88888888",
          data5: "13000000000",
          data6: "2019-11-14",
        },
      ];
    },

    history1() {
      return [
        {
          extra: "虹桥街道",
          data0: "张",
          data1: "主任",
          data2: "025-88888888",
          data3: "13000000000",
          data4: "2019-11-14",
          data5: "2019-12-14",
        },

        {
          extra: "虹桥街道",
          data0: "吴",
          data1: "副主任",
          data2: "025-88888888",
          data3: "13000000000",
          data4: "2019-12-14",
          data5: "",
        },

        {
          extra: "文峰街道",
          data0: "王",
          data1: "主任",
          data2: "025-88888888",
          data3: "13000000000",
          data4: "2019-10-14",
          data5: "2019-11-14",
        },

        {
          extra: "文峰街道",
          data0: "成",
          data1: "科长",
          data2: "025-88888888",
          data3: "13000000000",
          data4: "2019-11-14",
          data5: "",
        },
      ];
    },
  },
};
</script>


<style scoped>

</style>

