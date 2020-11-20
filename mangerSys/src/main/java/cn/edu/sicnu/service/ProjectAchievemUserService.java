package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.ProjectAchievemUser;

import java.util.List;

/**
 * (ProjectAchievemUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:35
 */
public interface ProjectAchievemUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectAchievemUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProjectAchievemUser> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<ProjectAchievemUser> findAll();

    /**
     * 新增数据
     *
     * @param projectAchievemUser 实例对象
     * @return 实例对象
     */
    ProjectAchievemUser insert(ProjectAchievemUser projectAchievemUser);

    /**
     * 修改数据
     *
     * @param projectAchievemUser 实例对象
     * @return 实例对象
     */
    ProjectAchievemUser update(ProjectAchievemUser projectAchievemUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}