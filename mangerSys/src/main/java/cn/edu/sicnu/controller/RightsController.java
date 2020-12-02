package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Rights;
import cn.edu.sicnu.service.RightsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Rights)表控制层
 *
 * @author makejava
 * @since 2020-11-23 20:19:19
 */
@CrossOrigin(origins = "*", maxAge = 3600)
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
//    public Rights selectOne(String id) {
//        return this.rightsService.queryById(id);
//    }
    public Rights selectOne(String name) {
        Rights rights = rightsService.queryByName("首页");
        System.out.println("rights = " + rights);
        return this.rightsService.queryByName(name);
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