package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.EvaluationResult;

import java.util.List;

/**
 * (EvaluationResult)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:31
 */
public interface EvaluationResultService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EvaluationResult queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EvaluationResult> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<EvaluationResult> findAll();

    /**
     * 新增数据
     *
     * @param evaluationResult 实例对象
     * @return 实例对象
     */
    EvaluationResult insert(EvaluationResult evaluationResult);

    /**
     * 修改数据
     *
     * @param evaluationResult 实例对象
     * @return 实例对象
     */
    EvaluationResult update(EvaluationResult evaluationResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}