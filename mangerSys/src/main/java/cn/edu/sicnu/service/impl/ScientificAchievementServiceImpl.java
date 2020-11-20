package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ScientificAchievementDao;
import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.service.ScientificAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ScientificAchievement)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:36
 */
@Service("scientificAchievementService")
@Transactional
public class ScientificAchievementServiceImpl implements ScientificAchievementService {
    @Resource
    private ScientificAchievementDao scientificAchievementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public ScientificAchievement queryById(String id) {
        return this.scientificAchievementDao.queryById(id);
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
    public List<ScientificAchievement> queryAllByLimit(int offset, int limit) {
        return this.scientificAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<ScientificAchievement> findAll() {
        return this.scientificAchievementDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param scientificAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ScientificAchievement insert(ScientificAchievement scientificAchievement) {
        this.scientificAchievementDao.insert(scientificAchievement);
        return scientificAchievement;
    }

    /**
     * 修改数据
     *
     * @param scientificAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ScientificAchievement update(ScientificAchievement scientificAchievement) {
        this.scientificAchievementDao.update(scientificAchievement);
        return this.queryById(scientificAchievement.getId());
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
        return this.scientificAchievementDao.deleteById(id) > 0;
    }
}