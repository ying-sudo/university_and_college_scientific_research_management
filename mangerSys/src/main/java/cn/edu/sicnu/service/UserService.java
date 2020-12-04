package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.Users;

import java.util.List;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Users> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<Users> findAll();

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
    /**
     * /login
     * id password 参数
     */
    Users findByIdAndPassword(String id, String password);
}