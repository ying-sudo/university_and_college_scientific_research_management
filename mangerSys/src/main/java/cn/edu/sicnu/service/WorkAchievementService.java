package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.WorkAchievement;

import java.util.List;

/**
 * (WorkAchievement)著作成果表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
public interface WorkAchievementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkAchievement queryById(String id);

    /**
     * 通过UserID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<WorkAchievement> queryByUserId(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkAchievement> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<WorkAchievement> findAll();

    /**
     * 新增数据
     *
     * @param workAchievement 实例对象
     * @return 新增成功返回true，失败返回false
     */
    boolean insert(WorkAchievement workAchievement);

    /**
     * 修改数据
     *
     * @param workAchievement 实例对象
     * @return 修改成功返回true，失败返回false
     */
    boolean update(WorkAchievement workAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}