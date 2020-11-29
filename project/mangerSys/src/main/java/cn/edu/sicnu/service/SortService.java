package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Sort;

import java.util.List;

/**
 * (Sort)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:32
 */
public interface SortService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sort> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Sort> findAll();

    /**
     * 新增数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    Sort insert(Sort sort);

    /**
     * 修改数据
     *
     * @param sort 实例对象
     * @return 实例对象
     */
    Sort update(Sort sort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}