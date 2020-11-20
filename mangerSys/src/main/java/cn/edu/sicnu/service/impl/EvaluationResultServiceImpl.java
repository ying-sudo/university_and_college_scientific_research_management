package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.EvaluationResultDao;
import cn.edu.sicnu.entity.EvaluationResult;
import cn.edu.sicnu.service.EvaluationResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EvaluationResult)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:31
 */
@Service("evaluationResultService")
@Transactional
public class EvaluationResultServiceImpl implements EvaluationResultService {
    @Resource
    private EvaluationResultDao evaluationResultDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public EvaluationResult queryById(String id) {
        return this.evaluationResultDao.queryById(id);
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
    public List<EvaluationResult> queryAllByLimit(int offset, int limit) {
        return this.evaluationResultDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<EvaluationResult> findAll() {
        return this.evaluationResultDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param evaluationResult 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public EvaluationResult insert(EvaluationResult evaluationResult) {
        this.evaluationResultDao.insert(evaluationResult);
        return evaluationResult;
    }

    /**
     * 修改数据
     *
     * @param evaluationResult 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public EvaluationResult update(EvaluationResult evaluationResult) {
        this.evaluationResultDao.update(evaluationResult);
        return this.queryById(evaluationResult.getId());
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
        return this.evaluationResultDao.deleteById(id) > 0;
    }
}