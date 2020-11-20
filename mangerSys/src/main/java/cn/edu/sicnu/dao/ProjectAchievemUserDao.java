package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.ProjectAchievemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProjectAchievemUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 23:25:35
 */
public interface ProjectAchievemUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectAchievemUser queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProjectAchievemUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<ProjectAchievemUser> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectAchievemUser 实例对象
     * @return 对象列表
     */
    List<ProjectAchievemUser> queryAll(ProjectAchievemUser projectAchievemUser);

    /**
     * 新增数据
     *
     * @param projectAchievemUser 实例对象
     * @return 影响行数
     */
    int insert(ProjectAchievemUser projectAchievemUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProjectAchievemUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProjectAchievemUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProjectAchievemUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProjectAchievemUser> entities);

    /**
     * 修改数据
     *
     * @param projectAchievemUser 实例对象
     * @return 影响行数
     */
    int update(ProjectAchievemUser projectAchievemUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}