package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.SortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
@RestController
@RequestMapping("sort")
public class SortController {
    /**
     * 服务对象
     */
    @Resource
    private SortService sortService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sort selectOne(String id) {
        return this.sortService.queryById(id);
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