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
    public List<WorkAchievement> queryAllByLimit(int offset, int limit) {
        return this.workAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    public List<WorkAchievement> findAll() {
        return this.workAchievementDao.findAll();
    }

    /**
     * 先查询这个id的记录是否存在，如果不存在则新增数据，如果存在则返回false
     *
     * @param workAchievement 实例对象
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(WorkAchievement workAchievement) {
        WorkAchievement achievement = workAchievementDao.queryById(workAchievement.getId());
        if (achievement == null) {
            int insert = this.workAchievementDao.insert(workAchievement);
            return insert == 1;
        }
        return false;
    }

    /**
     * 新查询这个id的记录是否存在，存在才能修改数据，否则直接返回false
     *
     * @param workAchievement 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(WorkAchievement workAchievement) {
        WorkAchievement achievement = workAchievementDao.queryById(workAchievement.getId());
        if (achievement != null) {
            int update = this.workAchievementDao.update(workAchievement);
            return update == 1;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        return this.workAchievementDao.deleteById(id) > 0;
    }
}