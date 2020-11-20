package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.UserCharacterDao;
import cn.edu.sicnu.entity.UserCharacter;
import cn.edu.sicnu.service.UserCharacterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserCharacter)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:43
 */
@Service("userCharacterService")
@Transactional
public class UserCharacterServiceImpl implements UserCharacterService {
    @Resource
    private UserCharacterDao userCharacterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param characterId 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public UserCharacter queryById(String characterId) {
        return this.userCharacterDao.queryById(characterId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<UserCharacter> queryAllByLimit(int offset, int limit) {
        return this.userCharacterDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<UserCharacter> findAll() {
        return this.userCharacterDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param userCharacter 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public UserCharacter insert(UserCharacter userCharacter) {
        this.userCharacterDao.insert(userCharacter);
        return userCharacter;
    }

    /**
     * 修改数据
     *
     * @param userCharacter 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public UserCharacter update(UserCharacter userCharacter) {
        this.userCharacterDao.update(userCharacter);
        return this.queryById(userCharacter.getCharacterId());
    }

    /**
     * 通过主键删除数据
     *
     * @param characterId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String characterId) {
        return this.userCharacterDao.deleteById(characterId) > 0;
    }
}