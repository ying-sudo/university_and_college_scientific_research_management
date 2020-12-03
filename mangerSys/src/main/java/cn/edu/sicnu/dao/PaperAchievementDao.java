package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.PaperAchievement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PaperAchievement)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:28
 */
public interface PaperAchievementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PaperAchievement queryById(String id);

    /**
     * 通过UserID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<PaperAchievement> queryByUserId(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PaperAchievement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<PaperAchievement> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param paperAchievement 实例对象
     * @return 对象列表
     */
    List<PaperAchievement> queryAll(PaperAchievement paperAchievement);

    /**
     * 新增数据
     *
     * @param paperAchievement 实例对象
     * @return 影响行数
     */
    int insert(PaperAchievement paperAchievement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PaperAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PaperAchievement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PaperAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PaperAchievement> entities);

    /**
     * 修改数据
     *
     * @param paperAchievement 实例对象
     * @return 影响行数
     */
    int update(PaperAchievement paperAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}