package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ProjectAchievemUserDao;
import cn.edu.sicnu.entity.ProjectAchievemUser;
import cn.edu.sicnu.service.ProjectAchievemUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectAchievemUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:35
 */
@Service("projectAchievemUserService")
@Transactional
public class ProjectAchievemUserServiceImpl implements ProjectAchievemUserService {
    @Resource
    private ProjectAchievemUserDao projectAchievemUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public ProjectAchievemUser queryById(String id) {
        return this.projectAchievemUserDao.queryById(id);
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
    public List<ProjectAchievemUser> queryAllByLimit(int offset, int limit) {
        return this.projectAchievemUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<ProjectAchievemUser> findAll() {
        return this.projectAchievemUserDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param projectAchievemUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ProjectAchievemUser insert(ProjectAchievemUser projectAchievemUser) {
        this.projectAchievemUserDao.insert(projectAchievemUser);
        return projectAchievemUser;
    }

    /**
     * 修改数据
     *
     * @param projectAchievemUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ProjectAchievemUser update(ProjectAchievemUser projectAchievemUser) {
        this.projectAchievemUserDao.update(projectAchievemUser);
        return this.queryById(projectAchievemUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String id) {
        return this.projectAchievemUserDao.deleteById(id) > 0;
    }
}