package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.WorkAchievementDao;
import cn.edu.sicnu.entity.WorkAchievement;
import cn.edu.sicnu.service.WorkAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WorkAchievement)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
@Service("workAchievementService")
@Transactional
public class WorkAchievementServiceImpl implements WorkAchievementService {
    @Resource
    private WorkAchievementDao workAchievementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public WorkAchievement queryById(String id) {
        return this.workAchievementDao.queryById(id);
    }

    /**
     * 通过UserID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public List<WorkAchievement> queryByUserId(String userId) {
        return workAchievementDao.queryByUserId(userId);
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
    public List<WorkAchievement> queryAllByLimit(int offset, int limit) {
        return this.workAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<WorkAchievement> findAll() {
        return this.workAchievementDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param workAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public WorkAchievement insert(WorkAchievement workAchievement) {
        this.workAchievementDao.insert(workAchievement);
        return workAchievement;
    }

    /**
     * 修改数据
     *
     * @param workAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public WorkAchievement update(WorkAchievement workAchievement) {
        this.workAchievementDao.update(workAchievement);
        return this.queryById(workAchievement.getId());
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
        return this.workAchievementDao.deleteById(id) > 0;
    }
}