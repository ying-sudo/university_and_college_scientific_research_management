package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.CharactersDao;
import cn.edu.sicnu.entity.Characters;
import cn.edu.sicnu.service.CharactersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Characters)表服务实现类
 *
 * @author makejava
 * @since 2020-11-20 22:47:23
 */
@Service("charactersService")
@Transactional
public class CharactersServiceImpl implements CharactersService {
    @Resource
    private CharactersDao charactersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Characters queryById(String id) {
        return this.charactersDao.queryById(id);
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
    public List<Characters> queryAllByLimit(int offset, int limit) {
        return this.charactersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Characters> findAll() {
        return this.charactersDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param characters 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Characters insert(Characters characters) {
        this.charactersDao.insert(characters);
        return characters;
    }

    /**
     * 修改数据
     *
     * @param characters 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Characters update(Characters characters) {
        this.charactersDao.update(characters);
        return this.queryById(characters.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(String id) {
        return this.charactersDao.deleteById(id) > 0;
    }

    /**
     * 通过删除数据
     *
     * @param
     * @return 影响行数
     */
    @Override
    @Transactional
    public boolean deleteByName(String name) {
        return this.charactersDao.deleteByName(name)>0;
    }
}