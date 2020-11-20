package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Magazine;

import java.util.List;

/**
 * (Magazine)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:32
 */
public interface MagazineService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Magazine queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Magazine> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Magazine> findAll();

    /**
     * 新增数据
     *
     * @param magazine 实例对象
     * @return 实例对象
     */
    Magazine insert(Magazine magazine);

    /**
     * 修改数据
     *
     * @param magazine 实例对象
     * @return 实例对象
     */
    Magazine update(Magazine magazine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}