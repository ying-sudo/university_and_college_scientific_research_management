package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.CharactersRightDao;
import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.RightsAndcharacters;
import cn.edu.sicnu.service.CharactersRightService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CharactersRight)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:24
 */
@Service("charactersRightService")
@Transactional
public class CharactersRightServiceImpl implements CharactersRightService {
    @Resource
    private CharactersRightDao charactersRightDao;

    /**
     * 通过ID查询单条数据
     *
     * @param characterId 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public CharactersRight queryById(String characterId) {
        return this.charactersRightDao.queryById(characterId);
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
    public List<CharactersRight> queryAllByLimit(int offset, int limit) {
        return this.charactersRightDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<CharactersRight> findAll() {
        return this.charactersRightDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param charactersRight 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public CharactersRight insert(CharactersRight charactersRight) {
        this.charactersRightDao.insert(charactersRight);
        return charactersRight;
    }

    /**
     * 修改数据
     *
     * @param charactersRight 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public CharactersRight update(CharactersRight charactersRight) {
        this.charactersRightDao.update(charactersRight);
        return this.queryById(charactersRight.getCharacterId());
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
        return this.charactersRightDao.deleteById(characterId) > 0;
    }

    /**
     * 通过角色id获取所有权限
     * id 参数
     */
    @Override
    public List<RightsAndcharacters> getRights(String id) {
        return charactersRightDao.getRights(id);
    }
}