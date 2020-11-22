<template>
  <div>

    <div style="font-size: 30px; margin: 20px;">
      编辑
    </div>

    <div style="font-size: 20px; text-align: left; margin: 10px;">
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

    <div style="width: 100%; height: 600px;">

      <el-collapse accordion>
        <el-collapse-item title="顶部导航栏显示控制">

          <div style="">
            <!-- <el-checkbox :indeterminate="isIndeterminate" v-model="checked.all" @change="handleCheckAllChange">全选</el-checkbox> -->
          </div>

          <div style="padding: 20px;">
            <el-tabs v-model="activeName" type="card">

              <el-tab-pane label="项目" name="projects">
                <div>
                  <!-- <el-checkbox :indeterminate="checked.projects.all" v-model="checked.projects.all" @change="handleCheckAllProjects">项目</el-checkbox> -->

                  <el-checkbox-group v-model="checkedChildView.projects" @change="changeProject">
                    <el-checkbox v-for="project_name,i in check.projects.name" :label="check.projects.id[i]" :key="check.projects.id[i]">{{project_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>

              <el-tab-pane label="成果" name="achievements">
                <div>
                  <!-- <el-checkbox :indeterminate="isIndeterminate" v-model="checked.achievements.all" @change="handleCheckAllAchievements">项目</el-checkbox> -->

                  <el-checkbox-group v-model="checkedChildView.achievements" @change="changeAchievement">
                    <el-checkbox v-for="achievement_name,i in check.achievements.name" :label="check.achievements.id[i]" :key="check.achievements.id[i]">{{achievement_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>

              <el-tab-pane label="团队" name="teams">
                
              </el-tab-pane>

              <el-tab-pane label="考核结果" name="assessmentres">
                
              </el-tab-pane>

              <el-tab-pane label="统计报表" name="reports">
                
              </el-tab-pane>

              <el-tab-pane label="项目评审" name="reviews">
                <div>
                  <el-checkbox-group v-model="checkedChildView.reviews" @change="changeProject">
                    <el-checkbox v-for="review_name,i in check.reviews.name" :label="check.reviews.id[i]" :key="check.reviews.id[i]">{{review_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>

              <el-tab-pane label="考核" name="assessment">
                <div>
                  <el-checkbox-group v-model="checkedChildView.assessment" @change="changeProject">
                    <el-checkbox v-for="assessment_name,i in check.assessment.name" :label="check.assessment.id[i]"
                      :key="check.assessment.id[i]">{{assessment_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>

              <el-tab-pane label="机构人员" name="institutions">
                <div>
                  <el-checkbox-group v-model="checkedChildView.institutions" @change="changeProject">
                    <el-checkbox v-for="institution_name,i in check.institutions.name" :label="check.institutions.id[i]"
                      :key="check.institutions.id[i]">{{institution_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>

              <el-tab-pane label="系统管理" name="admin">
                <div>
                  <el-checkbox-group v-model="checkedChildView.admin" @change="changeProject">
                    <el-checkbox v-for="admin_name,i in check.admin.name" :label="check.admin.id[i]" :key="check.admin.id[i]">{{admin_name}}</el-checkbox>
                  </el-checkbox-group>
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>

        </el-collapse-item>
        <el-collapse-item title="操作">

        </el-collapse-item>
      </el-collapse>

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
    data() {
      return {
        activeName: 'projects',
        isIndeterminate: true,
        checked: {
          all: false,
          projects: {
            all: false,
            child: true
          },
          achievements: {
            all: false,
            child: true
          },
          teams: {
            all: false,
            child: false
          },
          assessmentres: {
            all: false,
            child: false
          },
          reports: {
            all: false,
            child: false
          },
          reviews: {
            all: false,
            child: true
          },
          assessment: {
            all: false,
            child: true
          },
          institutions: {
            all: false,
            child: true
          },
          admin: {
            all: false,
            child: true
          }
        },
        checkedChildView: {
          projects: [
            'table/fundlists'
          ],
          achievements: [],
          reviews: [],
          assessment: [],
          institutions: [],
          admin: []
        },
        check: {
          projects: {
            id: [
              '/table/projectlists', 'table/fundlists'
            ],
            name: [
              '项目列表', '经费列表'
            ]
          },
          achievements: {
            id: [
              'papers', 'works', 'scientifics', 'patents'
            ],
            name: [
              '论文成果', '著作成果', '科研成果', '专利产品'
            ]
          },
          reviews: {
            id: [
              'batch', 'online',
            ],
            name: [
              '项目批次', '在线评审'
            ]
          },
          assessment: {
            id: [
              'batch', 'project', 'achievement', 'personal', 'college', 'team'
            ],
            name: [
              '考核批次', '项目考核', '成果考核', '个人考核', '学院考核', '校级团队考核'
            ]
          },
          institutions: {
            id: [
              'colleges', 'people'
            ],
            name: [
              '院系机构', '科研人员'
            ]
          },
          admin: {
            id: [
              'roles', 'sorts'
            ],
            name: [
              '角色管理', '分类设置'
            ]
          }
        }
      };
    },
    methods: {
      makeSure() {
        this.flag.flag = true;
        this.flag.is_edit = false;
        this.$emit('click', this.flag);
      },
      // 项目
      handleCheckAllProjects(val) {
        this.checked.projects.all = val;
        if (this.checked.projects.child) {
          this.checkedChildView.projects = val ? this.check.projects.id : [];
        }
         // this.checked.projects.all = false;
      },
      changeProject(value) {
        // this.checked.projects.all = value.length === this.check.projects.name.length;
        this.checked.projects.all = value.length > 0 && value.length < this.check.projects.name.length;
      },

      handleCheckAllAchievements(val) {
        // this.checked.achievements.all = val;
        if (this.checked.achievements.child) {
          this.checkedChildView.achievements = val ? this.check.achievements.id : [];
        }
        this.checked.projects.all = false;
      },
      changeAchievement(value) {
        this.checked.achievements.all = value.length === this.check.achievements.name.length;
        this.isIndeterminate = value.length > 0 && value.length < this.check.achievements.name.length;
      },

      handleCheckedCitiesChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.cities.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
      }
    }
  }
</script>

<style>
</style>
