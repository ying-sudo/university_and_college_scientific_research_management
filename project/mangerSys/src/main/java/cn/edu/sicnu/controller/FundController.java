package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Fund;
import cn.edu.sicnu.service.FundService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Fund)表控制层
 *
 * @author makejava
 * @since 2020-11-27 10:05:14
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fund")
public class FundController {
    /**
     * 服务对象
     */
    @Resource
    private FundService fundService;
    @Resource
    private ObjectMapper objectMapper;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Fund selectOne(String id) {
        return this.fundService.queryById(id);
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
     * 通过项目id获取项目的所有经费记录
     * 项目id 参数
     */
    @PostMapping("fund/{id}")
    public String getFundByProjectId(@PathVariable String id){
        try {
            List<Fund> fundList = fundService.getFundByProjectId(id);
            String string = objectMapper.writeValueAsString(fundList);
            return "{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":"+string+"}";
        } catch (Exception e) {
            e.toString();
            return "{\"resultCode\":\"-1\",\"resultMsg\":\"请求失败\"}";
        }
    }

}