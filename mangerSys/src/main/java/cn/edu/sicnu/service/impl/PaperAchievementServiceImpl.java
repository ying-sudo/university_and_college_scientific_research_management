package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.PaperAchievementDao;
import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.service.PaperAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.IdWorker.getId;

/**
 * (PaperAchievement)论文成果表服务实现类
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:28
 */
@Service("paperAchievementService")
public class PaperAchievementServiceImpl implements PaperAchievementService {
    @Resource
    private PaperAchievementDao paperAchievementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PaperAchievement queryById(String id) {
        return this.paperAchievementDao.queryById(id);
    }

    /**
     * 通过UserID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<PaperAchievement> queryByUserId(String id) {
        return paperAchievementDao.queryByUserId(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PaperAchievement> queryAllByLimit(int offset, int limit) {
        return this.paperAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    public List<PaperAchievement> findAll() {
        return this.paperAchievementDao.findAll();
    }

    /**
     * 新增数据
     * 先查看这个id的论文成果是否已存在，如果存在直接返回false
     * 只要有异常就回滚
     *
     * @param paperAchievement 实例对象
     * @return 新增是否成功，成功为true，失败为false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(PaperAchievement paperAchievement) {
        PaperAchievement achievement = paperAchievementDao.queryById(paperAchievement.getId());
        if (achievement == null) {
            int insert = this.paperAchievementDao.insert(paperAchievement);
            return insert == 1;
        }
        return false;
    }

    /**
     * 修改数据
     * 先查看这个id的论文成果是否已存在，如果不存在直接返回false
     * 只要有异常就回滚
     *
     * @param paperAchievement 实例对象
     * @return 修改是否成功，成功为true，失败为false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(PaperAchievement paperAchievement) {
        PaperAchievement achievement = paperAchievementDao.queryById(paperAchievement.getId());
        if (achievement != null) {
            int update = this.paperAchievementDao.update(paperAchievement);
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
        return this.paperAchievementDao.deleteById(id) > 0;
    }
}