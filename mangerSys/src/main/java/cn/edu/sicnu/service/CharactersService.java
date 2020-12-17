package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Characters;

import java.util.List;

/**
 * (Characters)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:23
 */
public interface CharactersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Characters queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Characters> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Characters> findAll();

    /**
     * 新增数据
     *
     * @param characters 实例对象
     * @return 实例对象
     */
    Characters insert(Characters characters);

    /**
     * 修改数据
     *
     * @param characters 实例对象
     * @return 实例对象
     */
    Characters update(Characters characters);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 通过删除数据
     *
     * @param
     * @return 影响行数
     */
    boolean deleteByName(String name);

}