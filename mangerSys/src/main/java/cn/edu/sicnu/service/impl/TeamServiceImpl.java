package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.TeamDao;
import cn.edu.sicnu.entity.Team;
import cn.edu.sicnu.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Team)表服务实现类
 *
 * @author makejava
 * @since 2020-11-19 23:25:41
 */
@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamDao teamDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public Team queryById(String id) {
        return this.teamDao.queryById(id);
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
    public List<Team> queryAllByLimit(int offset, int limit) {
        return this.teamDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<Team> findAll() {
        return this.teamDao.findAll();
    }

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Team insert(Team team) {
        this.teamDao.insert(team);
        return team;
    }

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Team update(Team team) {
        this.teamDao.update(team);
        return this.queryById(team.getId());
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
        return this.teamDao.deleteById(id) > 0;
    }
}