package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.AchievementMagazineDao;
import cn.edu.sicnu.entity.AchievementMagazine;
import cn.edu.sicnu.service.AchievementMagazineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AchievementMagazine)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:21
 */
@Service("achievementMagazineService")
@Transactional
public class AchievementMagazineServiceImpl implements AchievementMagazineService {
    @Resource
    private AchievementMagazineDao achievementMagazineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param achievementId 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public AchievementMagazine queryById(String achievementId) {
        return this.achievementMagazineDao.queryById(achievementId);
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
    public List<AchievementMagazine> queryAllByLimit(int offset, int limit) {
        return this.achievementMagazineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<AchievementMagazine> findAll() {
        return this.achievementMagazineDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param achievementMagazine 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public AchievementMagazine insert(AchievementMagazine achievementMagazine) {
        this.achievementMagazineDao.insert(achievementMagazine);
        return achievementMagazine;
    }

    /**
     * 修改数据
     *
     * @param achievementMagazine 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public AchievementMagazine update(AchievementMagazine achievementMagazine) {
        this.achievementMagazineDao.update(achievementMagazine);
        return this.queryById(achievementMagazine.getAchievementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param achievementId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String achievementId) {
        return this.achievementMagazineDao.deleteById(achievementId) > 0;
    }
}