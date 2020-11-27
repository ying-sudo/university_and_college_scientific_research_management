package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.EvaluationResult;
import cn.edu.sicnu.service.EvaluationResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (EvaluationResult)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:26
 */
@RestController
@RequestMapping("evaluationResult")
public class EvaluationResultController {
    /**
     * 服务对象
     */
    @Resource
    private EvaluationResultService evaluationResultService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EvaluationResult selectOne(String id) {
        return this.evaluationResultService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @RequestMapping("")
    public String findAll() {
        return "";
    }

}