<template>

  <!-- 表单底部表格 -->
  <div style="padding: 10px;">
    <div style=" padding-top: 70px;" v-if="!is_disabled">
      <mu-button style="float: right; margin: 10px;" color="primary">
        添加用户&nbsp;&nbsp;
        <i class="el-icon-s-custom" style="float: right; "></i>
      </mu-button>
    </div>

    <div style="border-radius: 4px; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
      <el-table :data="project_achievement_user" style="width: 100%" max-height="250">
        <el-table-column fixed prop="name" label="姓名" width="120"></el-table-column>
        <el-table-column prop="college_name" label="单位" width="300"></el-table-column>
        <el-table-column prop="arrange" label="排名" width="120"></el-table-column>
        <el-table-column prop="contribution" label="贡献率" width="120"></el-table-column>
        <div v-if="!is_disabled">
          <el-table-column fixed="right" label="操作" width="120">
            <template slot-scope="scope">
              <el-button @click.native.prevent="deleteRow(scope.$index, project_achievement_user)" type="text" size="small">
                移除
              </el-button>
              <el-button @click.native.prevent="editRow(scope.$index, project_achievement_user)" type="text" size="small">
                编辑
              </el-button>
            </template>
          </el-table-column>
        </div>
      </el-table>
    </div>
  </div>

</template>

<script>
  export default {
    props: ['is_disabled'],
    model: {
      prop: 'is_disabled',
      event: 'click'
    },
    data() {
      return {
        project_achievement_user: [{ //作者相关信息
            id: 'aaa',
            name: '小a',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
          { //作者相关信息
            id: 'bbb',
            name: '小b',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
          { //作者相关信息
            id: 'bbb',
            name: '小b',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
          { //作者相关信息
            id: 'bbb',
            name: '小b',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
          { //作者相关信息
            id: 'bbb',
            name: '小b',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
          { //作者相关信息
            id: 'bbb',
            name: '小b',
            college_name: '计算机',
            arrange: '1',
            contribution: '90'
          },
        ],
        editFlag: false
      }
    },
    methods: {
      deleteRow(index, rows) {
        console.log('删除的id： ' + this.project_achievement_user[index].id);
        rows.splice(index, 1);
      },
      editRow(index, rows) {
        this.editFlag = true;
      }
    }
  }
</script>

<style>
</style>
