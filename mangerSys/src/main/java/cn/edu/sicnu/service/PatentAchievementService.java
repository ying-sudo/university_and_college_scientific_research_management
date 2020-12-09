package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.PatentAchievement;

import java.util.List;

/**
 * (PatentAchievement)专利成果表服务接口
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:29
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
     * 根据传入的专利成果实体类模糊查询，
     *
     * @param achievement 成果实体类
     * @return 所有匹配的专利成果记录
     */
    List<PatentAchievement> queryAll(PatentAchievement achievement);

    /**
     * 新增数据
     *
     * @param patentAchievement 实例对象
     * @return 新增成功返回true，失败返回false
     */
    boolean insert(PatentAchievement patentAchievement);

    /**
     * 修改数据
     *
     * @param patentAchievement 实例对象
     * @return 修改成功返回true，失败返回false
     */
    boolean update(PatentAchievement patentAchievement);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}