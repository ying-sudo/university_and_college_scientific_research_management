package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ProjectDao;
import cn.edu.sicnu.entity.Project;
import cn.edu.sicnu.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)项目表服务实现类
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:30
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Project queryById(String id) {
        return this.projectDao.queryById(id);
    }

    /**
     * 通过USERID查询单条数据
     *
     * @param userId 外键
     * @return 实例对象
     */
    @Override
    @Transactional
    public List<Project> queryByUserId(String userId) {
        return this.projectDao.queryByUserId(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Project> queryAllByLimit(int offset, int limit) {
        return this.projectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Project> findAll() {
        return this.projectDao.findAll();
    }

    /**
     * 新增数据,判断开始日期必须早于结束日期,
     * 只要出现异常就回滚
     *
     * @param project 实例对象
     * @return 如果插入成功返回实例对象，失败返回null
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Project insert(Project project) {
        if (project.getId().charAt(0) != 'I') {
            project.setId("I" + project.getId());
        }

        if (project.getEndDate() == null || project.getBeginDate().before(project.getEndDate())) {
            int i = this.projectDao.insert(project);
            if (i == 1) {
                return project;
            }
        }
        return null;
    }

    /**
     * 修改数据,判断开始日期必须早于结束日期
     * 只要出现异常就回滚
     *
     * @param project 实例对象
     * @return 如果修改成功返回实例对象，失败返回null
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Project update(Project project) {
        if (project.getBeginDate().before(project.getEndDate())) {
            int i = this.projectDao.update(project);
            if (i == 1) {
                return project;
            }
        }
        return null;
    }

    /**
     * 通过主键删除数据,先判断是否存在这个id的记录，不存在直接返回
     * 只要出现异常就回滚
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        if (this.projectDao.queryById(id).getId() == null) {
            return false;
        }
        return this.projectDao.deleteById(id) > 0;
    }
}