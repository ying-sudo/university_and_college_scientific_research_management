package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.RightsDao;
import cn.edu.sicnu.entity.Rights;
import cn.edu.sicnu.service.RightsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rights)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:31
 */
@Service("rightsService")
@Transactional
public class RightsServiceImpl implements RightsService {
    @Resource
    private RightsDao rightsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Rights queryById(String id) {
        return this.rightsDao.queryById(id);
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
    public List<Rights> queryAllByLimit(int offset, int limit) {
        return this.rightsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Rights> findAll() {
        return this.rightsDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param rights 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Rights insert(Rights rights) {
        this.rightsDao.insert(rights);
        return rights;
    }

    /**
     * 修改数据
     *
     * @param rights 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Rights update(Rights rights) {
        this.rightsDao.update(rights);
        return this.queryById(rights.getId());
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
        return this.rightsDao.deleteById(id) > 0;
    }
}