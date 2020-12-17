package cn.edu.sicnu.service;

import cn.edu.sicnu.entity.EvaluationResult;

import java.util.List;

/**
 * (EvaluationResult)表服务接口
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:26
 */
public interface EvaluationResultService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EvaluationResult queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<EvaluationResult> queryAllByLimit(int offset, int limit);

    /**
     * 根据传入实体类进行精确匹配(不是模糊匹配)
     *
     * @param sort 查找哪个类别的审核结果，
     *             项目:project
     *             论文成果:paper
     *             科研成果:scientific
     *             专利:patent
     *             著作:work
     * @return 如果传入参数不是指定的类别返回null，如果参数合法则返回符合结果的所有记录
     * 直接返回审核的结果(包括审核条目的信息)，如审核项目的话，直接返回Project的list，
     * 其中每一项的分数(score)设置为从审核结果表查出的分数
     */
    List<Object> queryBySort(String sort);

    /**
     * 查这个用户下对应类别的所有记录的审核结果
     * 如传入类别为项目，则返回改用户的所有项目记录，如果没有审核结果则这个项目的审核结果为null，
     *
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
    List<Object> queryByUserId(String sort, String userId);

    /**
     * 查询表所有对象
     *
     * @return 对象列表
     */
    List<EvaluationResult> findAll();

    /**
     * 新增数据
     *
     * @param evaluationResult 实例对象
     * @return 新增成功返回true，失败返回false
     */
    boolean insert(EvaluationResult evaluationResult);

    /**
     * 修改数据
     *
     * @param evaluationResult 实例对象
     * @return 修改成功返回true，失败返回false
     */
    boolean update(EvaluationResult evaluationResult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}