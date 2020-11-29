package cn.edu.sicnu.controller;

import cn.edu.sicnu.service.LogtableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Logtable)表控制层
 *
 * @author makejava
 * @since 2020-11-28 20:45:12
 */
@RestController
@RequestMapping("logtable")
public class LogtableController {
    /**
     * 服务对象
     */
    @Resource
    private LogtableService logtableService;

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