<template>

  <!-- 权限 -->
  <div>
    <div v-if="flag.flag">
      <div style="font-size: 30px; margin: 20px;">
        角色权限管理
      </div>

      <div>
          <el-table :data="character" style="width: 100%" height="750" max-height="750">
            <el-table-column fixed prop="id" label="编号" width="100"></el-table-column>
            <el-table-column prop="name" label="角色名称" width="200"></el-table-column>
            <el-table-column prop="note" label="描述" width="600"></el-table-column>
            <el-table-column fixed="right" label="操作" width="300">
              <template slot-scope="scope">
                <el-button @click.native.prevent="deleteCharacter(scope.$index, character)" type="text" size="medium">
                  <i class="el-icon-delete" style="font-size: 20px;"></i>
                </el-button>
                <el-button @click.native.prevent="editCharacter(scope.$index, character)" type="text" size="medium">
                  <i class="el-icon-edit-outline" style="font-size: 20px;"></i>
                </el-button>
                <el-button @click.native.prevent="lookCharacter(scope.$index, character)" type="text" size="medium">
                  <i class="el-icon-user" style="font-size: 20px;"></i>
                </el-button>
                <el-button @click.native.prevent="deleteRow(scope.$index, character)" type="text" size="medium">
                  <i class="el-icon-delete" style="font-size: 20px;"></i>
                </el-button>
              </template>
            </el-table-column>
          </el-table>
      </div>
    </div>

    <RightCharacter v-if="flag.is_edit" v-model="flag"></RightCharacter>

    <RightUser v-if="flag.is_user" v-model="flag"></RightUser>

  </div>

</template>

<script>
  import RightCharacter from './RightCharacter.vue'
  import RightUser from './RightUser.vue'

  export default {
    methods: {
      deleteCharacter(index, rows) { //移除
        console.log('移除');
        rows.splice(index, 1);
      },
      editCharacter(index, rows) { //编辑
        this.flag.is_edit = true;
        this.flag.flag = false;
      },
      lookCharacter(index, rows) { //查看用户
        this.flag.is_user = true;
        this.flag.flag = false;
      },
      deleteRow(index, rows) {
        console.log('不知道');
      }
    },
    data() {
      return {
        character: [{
          id: '1',
          name: '普通用户',
          note: '普普通通'
        }, {
          id: '2',
          name: '一般管理员',
          note: '一般管理'
        }, {
          id: '3',
          name: '高级管理员',
          note: '高级管理'
        }, {
          id: '4',
          name: '高级管理员',
          note: '高级管理'
        }],
        flag: {
          is_edit: false,
          is_user: false,
          flag: true
        }
      };
    },
    components: {
      RightCharacter,
      RightUser
    }
  }
</script>


<style>
</style>
