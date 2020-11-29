package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.UserCharacter;
import cn.edu.sicnu.service.UserCharacterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserCharacter)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("userCharacter")
public class UserCharacterController {
    /**
     * 服务对象
     */
    @Resource
    private UserCharacterService userCharacterService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserCharacter selectOne(String id) {
        return this.userCharacterService.queryBycharacterId(id);
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