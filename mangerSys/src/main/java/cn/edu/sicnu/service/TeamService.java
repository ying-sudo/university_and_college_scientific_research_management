package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Team;

import java.util.List;

/**
 * (Team)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
public interface TeamService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Team queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Team> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Team> findAll();

    /**
     * 根据传入对象进行匹配
     *
     * @param team 传入的团队对象
     * @return 所有符合的团队对象的list
     */
    List<Team> queryAll(Team team);

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 新增成功返回true，失败返回false
     */
    boolean insert(Team team);

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 修改成功返回true，失败返回false
     */
    boolean update(Team team);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}