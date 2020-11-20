package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.UserCharacter;

import java.util.List;

/**
 * (UserCharacter)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 23:25:43
 */
public interface UserCharacterService {

    /**
     * 通过ID查询单条数据
     *
     * @param characterId 主键
     * @return 实例对象
     */
    UserCharacter queryById(String characterId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCharacter> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<UserCharacter> findAll();

    /**
     * 新增数据
     *
     * @param userCharacter 实例对象
     * @return 实例对象
     */
    UserCharacter insert(UserCharacter userCharacter);

    /**
     * 修改数据
     *
     * @param userCharacter 实例对象
     * @return 实例对象
     */
    UserCharacter update(UserCharacter userCharacter);

    /**
     * 通过主键删除数据
     *
     * @param characterId 主键
     * @return 是否成功
     */
    boolean deleteById(String characterId);

}