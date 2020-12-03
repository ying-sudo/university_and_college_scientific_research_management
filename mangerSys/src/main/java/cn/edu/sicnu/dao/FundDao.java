package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Fund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Fund)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
public interface FundDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fund queryById(String id);

    /**
     * 通过项目id获取项目的所有经费记录
     * 项目id 参数
     */
    List<Fund> getFundByProjectId(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Fund> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Fund> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param fund 实例对象
     * @return 对象列表
     */
    List<Fund> queryAll(Fund fund);

    /**
     * 新增数据
     *
     * @param fund 实例对象
     * @return 影响行数
     */
    int insert(Fund fund);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fund> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fund> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fund> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Fund> entities);

    /**
     * 修改数据
     *
     * @param fund 实例对象
     * @return 影响行数
     */
    int update(Fund fund);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}