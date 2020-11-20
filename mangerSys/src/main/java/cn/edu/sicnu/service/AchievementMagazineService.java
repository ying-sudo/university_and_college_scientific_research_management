package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.AchievementMagazine;

import java.util.List;

/**
 * (AchievementMagazine)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:21
 */
public interface AchievementMagazineService {

    /**
     * 通过ID查询单条数据
     *
     * @param achievementId 主键
     * @return 实例对象
     */
    AchievementMagazine queryById(String achievementId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AchievementMagazine> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<AchievementMagazine> findAll();

    /**
     * 新增数据
     *
     * @param achievementMagazine 实例对象
     * @return 实例对象
     */
    AchievementMagazine insert(AchievementMagazine achievementMagazine);

    /**
     * 修改数据
     *
     * @param achievementMagazine 实例对象
     * @return 实例对象
     */
    AchievementMagazine update(AchievementMagazine achievementMagazine);

    /**
     * 通过主键删除数据
     *
     * @param achievementId 主键
     * @return 是否成功
     */
    boolean deleteById(String achievementId);

}