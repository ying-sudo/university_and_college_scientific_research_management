package cn.edu.sicnu.service.impl;

import cn.edu.sicnu.dao.*;
import cn.edu.sicnu.entity.*;
import cn.edu.sicnu.service.EvaluationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (EvaluationResult)表服务实现类
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:26
 */
@Service("evaluationResultService")
public class EvaluationResultServiceImpl implements EvaluationResultService {
    @Resource
    private EvaluationResultDao evaluationResultDao;

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaperAchievementDao paperAchievementDao;
    @Autowired
    private PatentAchievementDao patentAchievementDao;
    @Autowired
    private ScientificAchievementDao scientificAchievementDao;
    @Autowired
    private WorkAchievementDao workAchievementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Transactional
    public EvaluationResult queryById(String id) {
        return this.evaluationResultDao.queryById(id);
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
    public List<EvaluationResult> queryAllByLimit(int offset, int limit) {
        return this.evaluationResultDao.queryAllByLimit(offset, limit);
    }

    /**
     * 根据输入的类别查找
     *
     * @param sort 查找哪个类别的审核结果，
     *             项目:project
     *             论文:paper
     *             科研:scientific
     *             专利:patent
     *             著作:work
     * @return 如果输入不正确直接返回null，输入符合规则才能查找
     * 直接返回审核的结果(包括审核条目的信息)，如审核项目的话，直接返回Project的list，
     * 其中每一项的分数(score)设置为从审核结果表查出的分数
     */
    @Override
    @Transactional
    public List<Object> queryBySort(String sort) {
        if (sort.matches("project|paper|scientific|patent|work")) {
            EvaluationResult result = new EvaluationResult();
            result.setSort(sort);
//            根据类别查询
            List<EvaluationResult> evaluationResults = evaluationResultDao.queryAll(result);

            List<Object> resultList = new ArrayList<>();
            if ("project".equals(sort)) {
                Project project;
                for (EvaluationResult evaluationResult : evaluationResults) {
                    project = projectDao.queryById(evaluationResult.getId());
                    project.setScore(evaluationResult.getScore());
                    resultList.add(project);
                }
            } else if ("paper".equals(sort)) {
                PaperAchievement paper;
                for (EvaluationResult evaluationResult : evaluationResults) {
                    paper = paperAchievementDao.queryById(evaluationResult.getId());
                    paper.setScore(evaluationResult.getScore());
                    resultList.add(paper);
                }
            } else if ("scientific".equals(sort)) {
                ScientificAchievement scientificAchievement;
                for (EvaluationResult evaluationResult : evaluationResults) {
                    scientificAchievement = scientificAchievementDao.queryById(evaluationResult.getId());
                    scientificAchievement.setScore(evaluationResult.getScore());
                    resultList.add(scientificAchievement);
                }
            } else if ("patent".equals(sort)) {
                PatentAchievement patentAchievement;
                for (EvaluationResult evaluationResult : evaluationResults) {
                    patentAchievement = patentAchievementDao.queryById(evaluationResult.getId());
                    patentAchievement.setScore(evaluationResult.getScore());
                    resultList.add(patentAchievement);
                }
            } else if ("work".equals(sort)) {
                WorkAchievement workAchievement;
                for (EvaluationResult evaluationResult : evaluationResults) {
                    workAchievement = workAchievementDao.queryById(evaluationResult.getId());
                    workAchievement.setScore(evaluationResult.getScore());
                    resultList.add(workAchievement);
                }
            }
            return resultList;
        }
        return null;
    }

    /**
     * @param sort   类别
     *               查找哪个类别的审核结果，
     *               项目:project
     *               论文成果:paper
     *               科研成果:scientific
     *               专利:patent
     *               著作:work
     * @param userId 用户id
     * @return
     */
    @Override
    @Transactional
    public List<Object> queryByUserId(String sort, String userId) {
        if (!sort.matches("project|paper|scientific|patent|work")) {
            return null;
        }

        List<Object> objectList = new ArrayList<>();
        EvaluationResult result;
        if ("project".equals(sort)) {
            List<Project> projectList = projectDao.queryByUserId(userId);
            for (Project project : projectList) {
                result = evaluationResultDao.queryById(project.getId());
                if (result != null) {
                    project.setScore(result.getScore());
                } else {
                    project.setScore(-1);
                }
                objectList.add(project);
            }

        } else if ("paper".equals(sort)) {
            List<PaperAchievement> achievementList = paperAchievementDao.queryByUserId(userId);
            for (PaperAchievement achievement : achievementList) {
                result = evaluationResultDao.queryById(achievement.getId());
                if (result != null) {
                    achievement.setScore(result.getScore());
                } else {
                    achievement.setScore(-1);
                }
                objectList.add(achievement);
            }

        } else if ("scientific".equals(sort)) {
            ScientificAchievement scientificAchievement = new ScientificAchievement();
            scientificAchievement.setUserId(userId);
            List<ScientificAchievement> achievementList = scientificAchievementDao.queryAll(scientificAchievement);
            for (ScientificAchievement achievement : achievementList) {
                result = evaluationResultDao.queryById(achievement.getId());
                if (result != null) {
                    achievement.setScore(result.getScore());
                } else {
                    achievement.setScore(-1);
                }
                objectList.add(achievement);
            }

        } else if ("patent".equals(sort)) {
            PatentAchievement patentAchievement = new PatentAchievement();
            patentAchievement.setUserId(userId);
            List<PatentAchievement> achievementList = patentAchievementDao.queryAll(patentAchievement);
            for (PatentAchievement achievement : achievementList) {
                result = evaluationResultDao.queryById(achievement.getId());
                if (result != null) {
                    achievement.setScore(result.getScore());
                } else {
                    achievement.setScore(-1);
                }
                objectList.add(achievement);
            }

        } else if ("work".equals(sort)) {
            List<WorkAchievement> achievementList = workAchievementDao.queryByUserId(userId);
            for (WorkAchievement achievement : achievementList) {
                result = evaluationResultDao.queryById(achievement.getId());
                if (result != null) {
                    achievement.setScore(result.getScore());
                } else {
                    achievement.setScore(-1);
                }
                objectList.add(achievement);
            }
        }
        return objectList;
    }

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    @Override
    @Transactional
    public List<EvaluationResult> findAll() {
        return this.evaluationResultDao.findAll();
    }


    /**
     * 新增数据, 生成时间
     *
     * @param evaluationResult 实例对象
     * @return 新增成功返回true，失败返回false
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(EvaluationResult evaluationResult) {
        System.out.println(evaluationResult);
        if (evaluationResultDao.queryById(evaluationResult.getId()) == null
                && isLegal(evaluationResult)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            evaluationResult.setDatename(dateFormat.format(new Date()));
            int insert = this.evaluationResultDao.insert(evaluationResult);
            return insert == 1;
        }
        return false;
    }

    /**
     * 检查传入的EvaluationResult对象是否合法
     * 如id是否在项目，论文，科研成果，专利，著作表中存在,id是否已经重复
     * 类别，分数是否合法
     *
     * @param result 传入的EvaluationResult对象
     * @return 合法返回true，否则返回false
     */
    private boolean isLegal(EvaluationResult result) {
        if (!result.getSort().matches("project|paper|scientific|patent|work")
                || result.getScore() < 0
                || result.getScore() > 100) {

            return false;
        }

        String id = result.getId();
        Object object = null;

        if ("project".equals(result.getSort())) {
            object = projectDao.queryById(id);
            return true;
        } else if ("paper".equals(result.getSort())) {
            object = paperAchievementDao.queryById(id);
            return true;
        } else if ("scientific".equals(result.getSort())) {
            object = scientificAchievementDao.queryById(id);
            return true;
        } else if ("patent".equals(result.getSort())) {
            object = patentAchievementDao.queryById(id);
            return true;
        } else if ("work".equals(result.getSort())) {
            object = workAchievementDao.queryById(id);
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param evaluationResult 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(EvaluationResult evaluationResult) {
        return evaluationResultDao.update(evaluationResult) == 1;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        return this.evaluationResultDao.deleteById(id) > 0;
    }
}