package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.TeamMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TeamMember)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 23:25:41
 */
public interface TeamMemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    TeamMember queryById(String teamId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeamMember> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<TeamMember> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param teamMember 实例对象
     * @return 对象列表
     */
    List<TeamMember> queryAll(TeamMember teamMember);

    /**
     * 新增数据
     *
     * @param teamMember 实例对象
     * @return 影响行数
     */
    int insert(TeamMember teamMember);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TeamMember> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TeamMember> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TeamMember> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TeamMember> entities);

    /**
     * 修改数据
     *
     * @param teamMember 实例对象
     * @return 影响行数
     */
    int update(TeamMember teamMember);

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 影响行数
     */
    int deleteById(String teamId);

}