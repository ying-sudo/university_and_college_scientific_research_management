package cn.edu.sicnu.controller;

import cn.edu.sicnu.service.LogcolumnService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Logcolumn)表控制层
 *
 * @author makejava
 * @since 2020-11-28 20:45:11
 */
@RestController
@RequestMapping("logcolumn")
public class LogcolumnController {
    /**
     * 服务对象
     */
    @Resource
    private LogcolumnService logcolumnService;

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