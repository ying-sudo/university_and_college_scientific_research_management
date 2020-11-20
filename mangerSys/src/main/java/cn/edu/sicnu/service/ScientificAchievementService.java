package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.ScientificAchievement;

import java.util.List;

/**
 * (ScientificAchievement)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:32
 */
public interface ScientificAchievementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScientificAchievement queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ScientificAchievement> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<ScientificAchievement> findAll();

    /**
     * 新增数据
     *
     * @param scientificAchievement 实例对象
     * @return 实例对象
     */
    ScientificAchievement insert(ScientificAchievement scientificAchievement);

    /**
     * 修改数据
     *
     * @param scientificAchievement 实例对象
     * @return 实例对象
     */
    ScientificAchievement update(ScientificAchievement scientificAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}