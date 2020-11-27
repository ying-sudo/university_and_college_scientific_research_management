package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.SortDao;
import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.SortService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
@Service("sortService")
@Transactional
public class SortServiceImpl implements SortService {
    @Resource
    private SortDao sortDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Sort queryById(String id) {
        return this.sortDao.queryById(id);
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
    public List<Sort> queryAllByLimit(int offset, int limit) {
        return this.sortDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Sort> findAll() {
        return this.sortDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Sort insert(Sort sort) {
        this.sortDao.insert(sort);
        return sort;
    }

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Sort update(Sort sort) {
        this.sortDao.update(sort);
        return this.queryById(sort.getId());
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
        return this.sortDao.deleteById(id) > 0;
    }
}