package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.ScientificAchievementDao;
import cn.edu.sicnu.entity.ScientificAchievement;
import cn.edu.sicnu.service.ScientificAchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ScientificAchievement)科研成果表服务实现类
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:32
 */
@Service("scientificAchievementService")
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
    public List<ScientificAchievement> queryAllByLimit(int offset, int limit) {
        return this.scientificAchievementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    public List<ScientificAchievement> findAll() {
        return this.scientificAchievementDao.findAll();
    }

    /**
     * 根据传入的对象进行模糊匹配，所有匹配的结果放入一个list中
     *
     * @param scientificAchievement 实例对象
     * @return 所有匹配的结果的实例对象
     */
    @Override
    public List<ScientificAchievement> queryAll(ScientificAchievement scientificAchievement) {
        return this.scientificAchievementDao.queryAll(scientificAchievement);
    }

    /**
     * 新增数据,先判断这个id是否已存在，不存在才能插入，存在则返回false
     *
     * @param scientificAchievement 实例对象
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(ScientificAchievement scientificAchievement) {
        ScientificAchievement achievement = scientificAchievementDao.queryById(scientificAchievement.getId());
        if (achievement == null) {
            int insert = this.scientificAchievementDao.insert(scientificAchievement);
            return insert == 1;
        }
        return false;
    }

    /**
     * 修改数据,先判断这个id是否已存在，存在才能修改，不存在则返回false
     *
     * @param scientificAchievement 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(ScientificAchievement scientificAchievement) {
        ScientificAchievement achievement = scientificAchievementDao.queryById(scientificAchievement.getId());
        if (achievement != null) {
            int update = this.scientificAchievementDao.update(scientificAchievement);
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
        return this.scientificAchievementDao.deleteById(id) > 0;
    }
}