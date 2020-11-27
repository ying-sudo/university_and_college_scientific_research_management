package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.College;
import cn.edu.sicnu.service.CollegeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (College)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:25
 */
@RestController
@RequestMapping("college")
public class CollegeController {
    /**
     * 服务对象
     */
    @Resource
    private CollegeService collegeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public College selectOne(String id) {
        return this.collegeService.queryById(id);
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