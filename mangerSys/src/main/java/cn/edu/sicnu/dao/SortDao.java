package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Sort)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:32
 */
public interface SortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sort queryById(String id);

    /**
     * 通过NOTE查询单条数据
     *
     * @param note 参数
     * @return 实例对象list
     */
    List<Sort> selectByNote(String note);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Sort> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sort 实例对象
     * @return 对象列表
     */
    List<Sort> queryAll(Sort sort);

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int insert(Sort sort);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sort> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sort> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sort> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Sort> entities);

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 影响行数
     */
    int update(Sort sort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}