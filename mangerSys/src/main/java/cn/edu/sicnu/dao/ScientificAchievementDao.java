package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.ScientificAchievement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ScientificAchievement)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:32
 */
@Repository
public interface ScientificAchievementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScientificAchievement queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ScientificAchievement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<ScientificAchievement> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param scientificAchievement 实例对象
     * @return 对象列表
     */
    List<ScientificAchievement> queryAll(ScientificAchievement scientificAchievement);

    /**
     * 新增数据
     *
     * @param scientificAchievement 实例对象
     * @return 影响行数
     */
    int insert(ScientificAchievement scientificAchievement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScientificAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ScientificAchievement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScientificAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ScientificAchievement> entities);

    /**
     * 修改数据
     *
     * @param scientificAchievement 实例对象
     * @return 影响行数
     */
    int update(ScientificAchievement scientificAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}