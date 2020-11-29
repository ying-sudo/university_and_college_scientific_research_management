package cn.edu.sicnu.controller;

import cn.edu.sicnu.service.LogoperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Logoperation)表控制层
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
@RestController
@RequestMapping("logoperation")
public class LogoperationController {
    /**
     * 服务对象
     */
    @Resource
    private LogoperationService logoperationService;

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