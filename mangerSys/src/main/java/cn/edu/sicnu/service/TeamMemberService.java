package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.TeamMember;

import java.util.List;

/**
 * (TeamMember)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:41
 */
public interface TeamMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    TeamMember queryById(String teamId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeamMember> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<TeamMember> findAll();

    /**
     * 新增数据
     *
     * @param teamMember 实例对象
     * @return 实例对象
     */
    TeamMember insert(TeamMember teamMember);

    /**
     * 修改数据
     *
     * @param teamMember 实例对象
     * @return 实例对象
     */
    TeamMember update(TeamMember teamMember);

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 是否成功
     */
    boolean deleteById(String teamId);

}