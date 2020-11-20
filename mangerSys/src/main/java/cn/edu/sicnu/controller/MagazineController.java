package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Magazine;
import cn.edu.sicnu.service.MagazineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Magazine)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:32
 */
@RestController
@RequestMapping("magazine")
public class MagazineController {
    /**
     * 服务对象
     */
    @Resource
    private MagazineService magazineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Magazine selectOne(String id) {
        return this.magazineService.queryById(id);
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