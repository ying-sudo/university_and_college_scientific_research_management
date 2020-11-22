<template>
  <div>

    <div style="font-size: 30px; margin: 20px;">
      用户
    </div>


    <div style="font-size: 20px; float: left; margin: 10px;">
      <div>
        角色编号:
      </div>
      <div>
        角色名称:
      </div>
      <div>
        角色描述:
      </div>
    </div>

    <div>
      <el-table :data="character" style="width: 100%" height="630" max-height="630">
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

    <mu-button @click="makeSure" color="primary" style="margin: 10px;">
      确定
    </mu-button>

  </div>
</template>

<script>
  export default {
    props: ['flag'],
    model: {
      prop: 'flag',
      event: 'click'
    },
    methods: {
      makeSure() {
        console.log('make sure');
        this.flag.flag = true;
        this.flag.is_user = false;
        this.$emit('click', this.flag);
      }
    }
  }
</script>

<style>
</style>
