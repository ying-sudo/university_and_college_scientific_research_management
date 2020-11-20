package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.PatentAchievement;

import java.util.List;

/**
 * (PatentAchievement)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:33
 */
public interface PatentAchievementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatentAchievement queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PatentAchievement> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<PatentAchievement> findAll();

    /**
     * 新增数据
     *
     * @param patentAchievement 实例对象
     * @return 实例对象
     */
    PatentAchievement insert(PatentAchievement patentAchievement);

    /**
     * 修改数据
     *
     * @param patentAchievement 实例对象
     * @return 实例对象
     */
    PatentAchievement update(PatentAchievement patentAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}