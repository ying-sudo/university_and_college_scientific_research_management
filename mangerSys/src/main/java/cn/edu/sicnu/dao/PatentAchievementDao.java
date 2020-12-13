package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.PatentAchievement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (PatentAchievement)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:29
 */
@Repository
public interface PatentAchievementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatentAchievement queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PatentAchievement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<PatentAchievement> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param patentAchievement 实例对象
     * @return 对象列表
     */
    List<PatentAchievement> queryAll(PatentAchievement patentAchievement);

    /**
     * 新增数据
     *
     * @param patentAchievement 实例对象
     * @return 影响行数
     */
    int insert(PatentAchievement patentAchievement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatentAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatentAchievement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatentAchievement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PatentAchievement> entities);

    /**
     * 修改数据
     *
     * @param patentAchievement 实例对象
     * @return 影响行数
     */
    int update(PatentAchievement patentAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}