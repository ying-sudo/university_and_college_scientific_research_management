package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.CollegeDao;
import cn.edu.sicnu.entity.College;
import cn.edu.sicnu.service.CollegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (College)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:25
 */
@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {
    @Resource
    private CollegeDao collegeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public College queryById(String id) {
        return this.collegeDao.queryById(id);
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
    public List<College> queryAllByLimit(int offset, int limit) {
        return this.collegeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<College> findAll() {
        return this.collegeDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param college 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public College insert(College college) {
        this.collegeDao.insert(college);
        return college;
    }

    /**
     * 修改数据
     *
     * @param college 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public College update(College college) {
        this.collegeDao.update(college);
        return this.queryById(college.getId());
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
        return this.collegeDao.deleteById(id) > 0;
    }
}