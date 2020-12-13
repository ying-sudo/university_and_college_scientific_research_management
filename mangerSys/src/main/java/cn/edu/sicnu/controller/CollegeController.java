package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.College;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.utils.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (College)学院表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:25
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CollegeController {
    /**
     * 服务对象
     */
    @Resource
    private CollegeService collegeService;

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/colleges")
    public Message findAll() {
        List<College> all = collegeService.findAll();
        return Message.success(all);
    }

}