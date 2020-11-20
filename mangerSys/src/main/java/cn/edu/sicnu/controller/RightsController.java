package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Rights;
import cn.edu.sicnu.service.RightsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Rights)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:36
 */
@RestController
@RequestMapping("rights")
public class RightsController {
    /**
     * 服务对象
     */
    @Resource
    private RightsService rightsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Rights selectOne(String id) {
        return this.rightsService.queryById(id);
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