package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.SortDao;
import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.SortService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表服务实现类
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:33
 */
@Service("sortService")
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
    public Sort queryById(Integer id) {
        return this.sortDao.queryById(id);
    }

    /**
     * 通过NOTE查询单条数据
     *
     * @param note 参数
     * @return 实例对象list
     */
    @Override
    @Transactional
    public List<Sort> selectByNote(String note) {
        return sortDao.selectByNote(note);
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
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Sort sort) {
        int insert = this.sortDao.insert(sort);
        return insert == 1;
    }

    /**
     * 批量新增字典项
     *
     * @param sortList 装有sort对象的list
     * @return 全部添加成功返回true，有一个失败回滚返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(List<Sort> sortList) {
        return sortDao.insertBatch(sortList) == sortList.size();
    }

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Sort sort) {
        if (sortDao.queryById(sort.getId()) != null) {
            int update = this.sortDao.update(sort);
            return update == 1;
        }
        return false;
    }

    /**
     * 批量修改数据
     *
     * @param sortList 装有sort对象的list
     * @return 全部修改成功返回true，有一个失败回滚返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(List<Sort> sortList) {
        int update = 0;
        for (Sort sort : sortList) {
            update = sortDao.update(sort);
            if (update != 1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return update == sortList.size();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        return this.sortDao.deleteById(id) > 0;
    }
}