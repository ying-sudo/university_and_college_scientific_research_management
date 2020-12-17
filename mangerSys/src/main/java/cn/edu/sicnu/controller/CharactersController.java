package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Characters;
import cn.edu.sicnu.service.CharactersService;
import cn.edu.sicnu.utils.Message;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Characters)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:23
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("characters")
public class CharactersController {
    /**
     * 服务对象
     */
    @Resource
    private CharactersService charactersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Characters selectOne(String id) {
        return this.charactersService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @PreAuthorize("hasAnyAuthority('/admin','/table/roles')")
    @PostMapping("findAll")
    public Message findAll() {
        List<Characters> all = charactersService.findAll();
        return Message.success(all);
    }
    /**
     *
     * 新增角色
     */
    @PreAuthorize("hasAnyAuthority('/admin','/table/roles')")
    @PostMapping("insertRole")
    public Message insertRole(@RequestBody Map<String,String> map){
        try{
            String i = String.valueOf (charactersService.findAll().size() + 1);
            Characters characters = new Characters(i, map.get("name"), map.get("note"));
            charactersService.insert(characters);
            return Message.success();
        }catch (Exception e){
            return Message.fail();
        }
    }
    /**
     * 删除角色
     */
    @PreAuthorize("hasAnyAuthority('/admin','/table/roles')")
    @PostMapping("deleteRole")
    public Message deleteRole(@RequestBody String name){
        try{
            charactersService.deleteByName(name);
            return Message.success();
        }catch (Exception e){
            return Message.fail();
        }
    }
}