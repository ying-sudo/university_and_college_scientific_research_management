package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Fund;

import java.util.List;

/**
 * (Fund)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:26
 */
public interface FundService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fund queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Fund> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Fund> findAll();

    /**
     * 新增数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    Fund insert(Fund fund);

    /**
     * 修改数据
     *
     * @param fund 实例对象
     * @return 实例对象
     */
    Fund update(Fund fund);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}