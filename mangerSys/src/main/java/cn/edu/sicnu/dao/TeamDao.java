package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Team)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
public interface TeamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Team queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Team> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Team> findAll();

    List<Team> findAllTeam(@Param("userId") String userId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param team 实例对象
     * @return 对象列表
     */
    List<Team> queryAll(Team team);

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 影响行数
     */
    int insert(Team team);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Team> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Team> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Team> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Team> entities);

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 影响行数
     */
    int update(Team team);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}