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
 * @since 2020-11-20 22:47:33
 */
@Service("teamService")
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
     * 根据传入对象进行匹配
     *
     * @param team 传入的团队对象
     * @return 符合条件的所有对象的list
     */
    @Override
    @Transactional
    public List<Team> queryAll(Team team) {
        return teamDao.queryAll(team);
    }

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Team team) {
        if (teamDao.queryById(team.getId()) == null) {
            int insert = this.teamDao.insert(team);
            return insert == 1;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 修改成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Team team) {
        int update = this.teamDao.update(team);
        return update == 1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        if (teamDao.queryById(id) != null) {
            return this.teamDao.deleteById(id) > 0;
        }
        return false;
    }
}