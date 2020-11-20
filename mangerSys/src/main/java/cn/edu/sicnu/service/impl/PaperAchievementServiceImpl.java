package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.PaperAchievementDao;
import cn.edu.sicnu.entity.PaperAchievement;
import cn.edu.sicnu.service.PaperAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PaperAchievement)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:33
 */
@Service("paperAchievementService")
@Transactional
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
    @Transactional
    public PaperAchievement queryById(String id) {
        return this.paperAchievementDao.queryById(id);
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
    public List<PaperAchievement> queryAllByLimit(int offset, int limit) {
        return this.paperAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<PaperAchievement> findAll() {
        return this.paperAchievementDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param paperAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public PaperAchievement insert(PaperAchievement paperAchievement) {
        this.paperAchievementDao.insert(paperAchievement);
        return paperAchievement;
    }

    /**
     * 修改数据
     *
     * @param paperAchievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public PaperAchievement update(PaperAchievement paperAchievement) {
        this.paperAchievementDao.update(paperAchievement);
        return this.queryById(paperAchievement.getId());
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
        return this.paperAchievementDao.deleteById(id) > 0;
    }
}