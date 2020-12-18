package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.UserCharacterService;
import cn.edu.sicnu.utils.getRights;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (CharactersRight)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:24
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("charactersRight")
public class CharactersRightController {
    /**
     * 服务对象
     */
    @Resource
    private CharactersRightService charactersRightService;
    @Resource
    private UserCharacterService userCharacterService;

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

    /**
     * 改变权限
     * map<String,Object> 参数
     */
    @PreAuthorize("hasAnyAuthority('/admin','/noIdtable/authoritylists')")
    @PostMapping("updataRights")
    public String updateRights(@RequestBody Map<String,Object> map){
        getRights get = new getRights(userCharacterService,charactersRightService);
        System.out.println("map = " + map);
        String s = get.updataByMap(map);
        System.out.println("s = " + s);
        return s;
    }

}