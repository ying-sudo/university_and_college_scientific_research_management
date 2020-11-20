package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.EvaluationResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EvaluationResult)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 23:25:31
 */
public interface EvaluationResultDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EvaluationResult queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EvaluationResult> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<EvaluationResult> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param evaluationResult 实例对象
     * @return 对象列表
     */
    List<EvaluationResult> queryAll(EvaluationResult evaluationResult);

    /**
     * 新增数据
     *
     * @param evaluationResult 实例对象
     * @return 影响行数
     */
    int insert(EvaluationResult evaluationResult);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EvaluationResult> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EvaluationResult> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EvaluationResult> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EvaluationResult> entities);

    /**
     * 修改数据
     *
     * @param evaluationResult 实例对象
     * @return 影响行数
     */
    int update(EvaluationResult evaluationResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}