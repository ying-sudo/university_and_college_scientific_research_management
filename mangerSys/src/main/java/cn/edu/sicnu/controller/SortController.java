package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.SortService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SortController {
    /**
     * 服务对象
     */
    @Resource
    private SortService sortService;

    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 查询所有
     *
     * @return 所有数据
     */
//    @PreAuthorize("hasAnyAuthority()")
    @GetMapping("/sorts")
    public String findAll() {
        String re = "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":{";

        List<Sort> sorts = sortService.selectByNote("1");
        re += "\"firstDiscipline\":[";
        for (int i = 0; i < sorts.size(); i++) {
            if (i == sorts.size() - 1) {
                re += "\"" + sorts.get(i).getValue() + "\"],";
            } else {
                re += "\"" + sorts.get(i).getValue() + "\",";
            }
        }

        List<Sort> sorts1 = sortService.selectByNote("2");
        re += "\"level\":[";
        for (int i = 0; i < sorts1.size(); i++) {
            if (i == sorts1.size() - 1) {
                re += "\"" + sorts1.get(i).getValue() + "\"],";
            } else {
                re += "\"" + sorts1.get(i).getValue() + "\",";
            }
        }

        List<Sort> sorts2 = sortService.selectByNote("3");
        re += "\"sort\":[";
        for (int i = 0; i < sorts2.size(); i++) {
            if (i == sorts2.size() - 1) {
                re += "\"" + sorts2.get(i).getValue() + "\"]";
            } else {
                re += "\"" + sorts2.get(i).getValue() + "\",";
            }
        }
        re += "}}";
        return re;
    }

    /**
     * 根据类别(对应sort表中note)查询
     * 1 一级学科
     * 2 学科等级
     * 3 学科分类
     *
     * @param kindId 类别id
     * @return 查询数据放入data
     */
//    @PreAuthorize("hasAnyAuthority()")
    @GetMapping("/sorts/{kindId}")
    public Message find(@PathVariable("kindId") String kindId) {
        List<Sort> sorts = sortService.selectByNote(kindId);
        return Message.success(sorts);
    }

    /**
     * 新增字典项
     * 1 一级学科
     * 2 学科等级
     * 3 学科分类
     *
     * @param sort 多个字典项对应实体类的list
     * @return 新增成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @PostMapping("/sorts")
    public Message insert(@RequestBody List<Sort> sort) {
        boolean insert = sortService.insert(sort);
        if (insert) {
            operLogger.info("新增字典项成功");
            return Message.success();
        }
        operLogger.info("新增字典项失败");
        return Message.fail();
    }

    /**
     * 修改字典项
     *
     * @param sortList 字典项对应实体类
     * @return 修改成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @PutMapping("/sorts")
    public Message update(@RequestBody List<Sort> sortList) {
        boolean update = sortService.update(sortList);
        if (update) {
            operLogger.info("修改字典项成功");
            return Message.success();
        }
        operLogger.info("修改字典项失败");
        return Message.fail();
    }

    /**
     * 删除对应id(主码)的字典项
     *
     * @param sortId 字典项id
     * @return 删除成功返回状态码为0，失败返回其他状态码
     */
//    @PreAuthorize("hasAnyAuthority()")
    @DeleteMapping("/sorts/{sortId}")
    public Message delete(@PathVariable("sortId") Integer sortId) {
        boolean delete = sortService.deleteById(sortId);
        if (delete) {
            operLogger.info("删除字典项成功");
            return Message.success();
        }
        operLogger.info("删除字典项失败");
        return Message.fail();
    }

}