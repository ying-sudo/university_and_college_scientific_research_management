package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.service.CharactersRightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (CharactersRight)表控制层
 *
 * @author makejava
 * @since 2020-11-19 23:25:29
 */
@RestController
@RequestMapping("charactersRight")
public class CharactersRightController {
    /**
     * 服务对象
     */
    @Resource
    private CharactersRightService charactersRightService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CharactersRight selectOne(String id) {
        return this.charactersRightService.queryById(id);
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