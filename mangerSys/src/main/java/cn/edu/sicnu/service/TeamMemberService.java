package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.TeamMember;

import java.util.List;

/**
 * (TeamMember)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:34
 */
public interface TeamMemberService {

    /**
     * 通过ID联合主码(teamId, userId)查询单条数据
     *
     * @param teamId 团队id
     * @param userId 团队成员id，即userId
     * @return 实体对象，如果不存在则返回null
     */
    TeamMember queryById(String teamId, String userId);

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
     * 通过传入对象进行匹配
     *
     * @param teamMember 传入对象
     * @return 所有匹配的TeamMember类实体对象list
     */
    List<TeamMember> queryAll(TeamMember teamMember);

    /**
     * 新增数据,一次添加多个团队成员，有一个失败就是全部添加失败
     *
     * @param teamMemberList 团队成员列表
     * @return 新增成功返回true，失败返回false
     */
    boolean insert(List<TeamMember> teamMemberList);

    /**
     * 修改数据,一次可以修改多个团队成员，有一个失败就是全部修改失败
     *
     * @param teamMember 实例对象
     * @return 修改成功返回true，失败返回false
     */
    boolean update(TeamMember teamMember);

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 删除成功返回true，失败返回false
     */
    boolean deleteById(String teamId, String userId);

}