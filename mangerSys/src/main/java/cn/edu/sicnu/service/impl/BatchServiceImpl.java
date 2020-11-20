package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.BatchDao;
import cn.edu.sicnu.entity.Batch;
import cn.edu.sicnu.service.BatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Batch)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:22
 */
@Service("batchService")
@Transactional
public class BatchServiceImpl implements BatchService {
    @Resource
    private BatchDao batchDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Batch queryById(String id) {
        return this.batchDao.queryById(id);
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
    public List<Batch> queryAllByLimit(int offset, int limit) {
        return this.batchDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Batch> findAll() {
        return this.batchDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Batch insert(Batch batch) {
        this.batchDao.insert(batch);
        return batch;
    }

    /**
     * 修改数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Batch update(Batch batch) {
        this.batchDao.update(batch);
        return this.queryById(batch.getId());
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
        return this.batchDao.deleteById(id) > 0;
    }
}