package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.EvaluationResult;
import cn.edu.sicnu.service.EvaluationResultService;
import cn.edu.sicnu.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EvaluationResult)表控制层
 *
 * @author makejava, liangjin
 * @since 2020-11-20 22:47:26
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EvaluationResultController {
    /**
     * 服务对象
     */
    @Resource
    private EvaluationResultService evaluationResultService;
    private final Logger operLogger = LoggerFactory.getLogger("operationInfo");

    /**
     * 列出(项目，各种成果)审核的条目，如果有分数则显示分数，如果没有分数则分数为null
     *
     * @param assessVal 审核的东西
     *                  项目:projects
     *                  论文成果:papers
     *                  科研成果:scientifics
     *                  专利:patents
     *                  著作:works
     * @return data中放入查出的审核记录
     */
    @PreAuthorize("hasAnyAuthority('/assessment')")
    @GetMapping("/assess/{assessVal}")
    public Message findBySort(@PathVariable("assessVal") String assessVal) {
        String regex = "projects|papers|scientifics|patents|works";
        if (!assessVal.matches(regex)) {
            return Message.fail();
        }
//        去掉后面的s
        assessVal = assessVal.substring(0, assessVal.length() - 1);

        List<Object> objectList = evaluationResultService.queryBySort(assessVal);
        if (objectList == null) {
            return Message.fail();
        }
        return Message.success(objectList);
    }

    /**
     *
     * @param assessVal
     * @param userId
     * @return
     */
    @GetMapping("/assess/{assessVal}/user/{userId}")
    public Message findByUserId(@PathVariable("assessVal") String assessVal, @PathVariable("userId") String userId) {
        String regex = "projects|papers|scientifics|patents|works";
        if (!assessVal.matches(regex)) {
            return Message.fail();
        }
        //        去掉后面的s
        assessVal = assessVal.substring(0, assessVal.length() - 1);
        List<Object> objectList = evaluationResultService.queryByUserId(assessVal, userId);
        return Message.success(objectList);
    }

    /**
     * 审核（打分）
     *
     * @param result 审核结果实体类
     * @return 审核成功返回状态码0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/assessment')")
    @PostMapping("/assess")
    public Message insert(@RequestBody EvaluationResult result) {
        boolean insert = evaluationResultService.insert(result);
        if (insert) {
            operLogger.info("审核成功");
            return Message.success();
        } else {
            operLogger.info("审核失败");
            return Message.fail();
        }
    }

    /**
     * 修改审核结果
     *
     * @param result 审核结果实体类
     * @return 修改成功返回状态码为0，失败返回其他状态码
     */
    @PreAuthorize("hasAnyAuthority('/assessment')")
    @PutMapping("/assess")
    public Message update(@RequestBody EvaluationResult result) {
        boolean update = evaluationResultService.update(result);
        if (update) {
            operLogger.info("审核结果修改成功");
            return Message.success();
        }
        operLogger.warn("审核结果修改失败");
        return Message.fail();
    }

}