package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.Logtable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Logtable)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-28 20:45:12
 */
public interface LogtableDao {

    /**
     * 新增数据
     *
     * @param logtable 实例对象
     * @return 影响行数
     */
    int insert(Logtable logtable);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Logtable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}