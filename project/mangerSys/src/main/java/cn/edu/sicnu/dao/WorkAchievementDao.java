package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.WorkAchievement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WorkAchievement)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
public interface WorkAchievementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkAchievement queryById(String id);

    /**
     * 通过UserID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<WorkAchievement> queryByUserId(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkAchievement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<WorkAchievement> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param workAchievement 实例对象
     * @return 对象列表
     */
    List<WorkAchievement> queryAll(WorkAchievement workAchievement);

    /**
     * 新增数据
     *
     * @param workAchievement 实例对象
     * @return 影响行数
     */
    int insert(WorkAchievement workAchievement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WorkAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WorkAchievement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WorkAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<WorkAchievement> entities);

    /**
     * 修改数据
     *
     * @param workAchievement 实例对象
     * @return 影响行数
     */
    int update(WorkAchievement workAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}