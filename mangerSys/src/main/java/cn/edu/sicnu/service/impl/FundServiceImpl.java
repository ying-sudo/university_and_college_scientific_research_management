package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.FundDao;
import cn.edu.sicnu.entity.Fund;
import cn.edu.sicnu.service.FundService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Fund)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:26
 */
@Service("fundService")
@Transactional
public class FundServiceImpl implements FundService {
    @Resource
    private FundDao fundDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund queryById(String id) {
        return this.fundDao.queryById(id);
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
    public List<Fund> queryAllByLimit(int offset, int limit) {
        return this.fundDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Fund> findAll() {
        return this.fundDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund insert(Fund fund) {
        this.fundDao.insert(fund);
        return fund;
    }

    /**
     * 修改数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Fund update(Fund fund) {
        this.fundDao.update(fund);
        return this.queryById(fund.getId());
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
        return this.fundDao.deleteById(id) > 0;
    }
}