package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Batch;

import java.util.List;

/**
 * (Batch)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:22
 */
public interface BatchService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Batch queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Batch> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Batch> findAll();

    /**
     * 新增数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    Batch insert(Batch batch);

    /**
     * 修改数据
     *
     * @param batch 实例对象
     * @return 实例对象
     */
    Batch update(Batch batch);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}