package cn.edu.sicnu.dao;

import cn.edu.sicnu.entity.UserCharacter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserCharacter)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
public interface UserCharacterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param characterId 主键
     * @return 实例对象
     */
    UserCharacter queryById(String characterId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCharacter> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<UserCharacter> findAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userCharacter 实例对象
     * @return 对象列表
     */
    List<UserCharacter> queryAll(UserCharacter userCharacter);

    /**
     * 新增数据
     *
     * @param userCharacter 实例对象
     * @return 影响行数
     */
    int insert(UserCharacter userCharacter);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserCharacter> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserCharacter> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserCharacter> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserCharacter> entities);

    /**
     * 修改数据
     *
     * @param userCharacter 实例对象
     * @return 影响行数
     */
    int update(UserCharacter userCharacter);

    /**
     * 通过主键删除数据
     *
     * @param characterId 主键
     * @return 影响行数
     */
    int deleteById(String characterId);

}