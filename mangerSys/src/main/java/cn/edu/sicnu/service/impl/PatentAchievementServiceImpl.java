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
    public List<PatentAchievement> queryAllByLimit(int offset, int limit) {
        return this.patentAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    public List<PatentAchievement> findAll() {
        return this.patentAchievementDao.findAll();
    }

    /**
     * 根据传入实体类模糊查询
     *
     * @param achievement 成果实体类
     * @return 和传入实体类相近的所有专利成果列表
     */
    @Override
    public List<PatentAchievement> queryAll(PatentAchievement achievement) {
        return this.patentAchievementDao.queryAll(achievement);
    }

    /**
     * 新增数据,先判断这个id是否已经使用，如果id已存在直接返回false
     * 只要有异常就回滚
     *
     * @param patentAchievement 实例对象
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(PatentAchievement patentAchievement) {
        if (patentAchievement.getId().charAt(0) != 'P') {
            patentAchievement.setId("P" + patentAchievement.getId());
        }

        PatentAchievement achievement = patentAchievementDao.queryById(patentAchievement.getId());
        if (achievement == null) {
            int i = this.patentAchievementDao.insert(patentAchievement);
            return i == 1;
        }
        return false;
    }

    /**
     * 修改数据
     * 只要有异常就回滚
     *
     * @param patentAchievement 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(PatentAchievement patentAchievement) {
        int i = this.patentAchievementDao.update(patentAchievement);
        return i == 1;
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