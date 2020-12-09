package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.PaperAchievement;

import java.util.List;

/**
 * (PaperAchievement)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:28
 */
public interface PaperAchievementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PaperAchievement queryById(String id);

    /**
     * 通过UserID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<PaperAchievement> queryByUserId(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PaperAchievement> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<PaperAchievement> findAll();

    /**
     * 新增数据
     *
     * @param paperAchievement 实例对象
     * @return 新增是否成功，成功为true，失败为false
     */
    boolean insert(PaperAchievement paperAchievement);

    /**
     * 修改数据
     *
     * @param paperAchievement 实例对象
     * @return 修改是否成功，成功为true，失败为false
     */
    boolean update(PaperAchievement paperAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}