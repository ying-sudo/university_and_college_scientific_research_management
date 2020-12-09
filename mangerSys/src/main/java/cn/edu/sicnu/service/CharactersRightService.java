package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.RightsAndcharacters;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Set;

/**
 * (CharactersRight)表服务接口
 *
 * @author makejava
 * @since 2020-11-20 22:47:24
 */
public interface CharactersRightService {

    /**
     * 通过ID查询单条数据
     *
     * @param characterId 主键
     * @return 实例对象
     */
    CharactersRight queryById(String characterId);


    /**
     * 通过CharacterID查询单条数据
     *
     * @param characterId
     * @return 实例对象
     */
    List<CharactersRight> queryByCharacterId(String characterId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CharactersRight> queryAllByLimit(int offset, int limit);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<CharactersRight> findAll();

    /**
     * 新增数据
     *
     * @param charactersRight 实例对象
     * @return 实例对象
     */
    CharactersRight insert(CharactersRight charactersRight);

    /**
     * 修改数据
     *
     * @param charactersRight 实例对象
     * @return 实例对象
     */
    CharactersRight update(CharactersRight charactersRight);

    /**
     * 通过主键删除数据
     *
     * @param characterId 主键
     * @return 是否成功
     */
    boolean deleteById(String characterId);
    /**
     * 通过角色id获取所有权限
     * id 参数
     */
    List<RightsAndcharacters> getRights(String id);
}