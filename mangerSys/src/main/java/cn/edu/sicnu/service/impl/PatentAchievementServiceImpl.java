package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.PatentAchievementDao;
import cn.edu.sicnu.entity.PatentAchievement;
import cn.edu.sicnu.service.PatentAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatentAchievement)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:29
 */
@Service("patentAchievementService")
@Transactional
public class PatentAchievementServiceImpl implements PatentAchievementService {
    @Resource
    private PatentAchievementDao patentAchievementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public PatentAchievement queryById(String id) {
        return this.patentAchievementDao.queryById(id);
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
    public List<PatentAchievement> queryAllByLimit(int offset, int limit) {
        return this.patentAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<PatentAchievement> findAll() {
        return this.patentAchievementDao.findAll();
    }

    @Override
    public List<PatentAchievement> queryAll(PatentAchievement achievement) {
        return this.patentAchievementDao.queryAll(achievement);
    }

    /**
     * 新增数据
     *
     * @param patentAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public PatentAchievement insert(PatentAchievement patentAchievement) {
        this.patentAchievementDao.insert(patentAchievement);
        return patentAchievement;
    }

    /**
     * 修改数据
     *
     * @param patentAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public PatentAchievement update(PatentAchievement patentAchievement) {
        this.patentAchievementDao.update(patentAchievement);
        return this.queryById(patentAchievement.getId());
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
        return this.patentAchievementDao.deleteById(id) > 0;
    }
}