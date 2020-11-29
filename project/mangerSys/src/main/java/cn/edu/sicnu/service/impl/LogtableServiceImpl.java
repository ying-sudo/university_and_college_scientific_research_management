package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.LogtableDao;
import cn.edu.sicnu.entity.Logtable;
import cn.edu.sicnu.service.LogtableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Logtable)表服务实现类
 *
 * @author makejava
 * @since 2020-11-28 20:45:12
 */
@Service("logtableService")
@Transactional
public class LogtableServiceImpl implements LogtableService {
    @Resource
    private LogtableDao logtableDao;

    /**
     * 新增数据
     *
     * @param logtable 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(Logtable logtable) {
        return this.logtableDao.insert(logtable);
    }

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Logtable> queryAllByLimit(int offset, int limit) {
        return logtableDao.queryAllByLimit(offset,limit);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Override
    @Transactional
    public int deleteById(Integer id) {
        return logtableDao.deleteById(id);
    }
}