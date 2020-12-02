package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.MagazineDao;
import cn.edu.sicnu.entity.Magazine;
import cn.edu.sicnu.service.MagazineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Magazine)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:27
 */
@Service("magazineService")
@Transactional
public class MagazineServiceImpl implements MagazineService {
    @Resource
    private MagazineDao magazineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Magazine queryById(String id) {
        return this.magazineDao.queryById(id);
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
    public List<Magazine> queryAllByLimit(int offset, int limit) {
        return this.magazineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Magazine> findAll() {
        return this.magazineDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param magazine 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Magazine insert(Magazine magazine) {
        this.magazineDao.insert(magazine);
        return magazine;
    }

    /**
     * 修改数据
     *
     * @param magazine 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Magazine update(Magazine magazine) {
        this.magazineDao.update(magazine);
        return this.queryById(magazine.getId());
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
        return this.magazineDao.deleteById(id) > 0;
    }
}