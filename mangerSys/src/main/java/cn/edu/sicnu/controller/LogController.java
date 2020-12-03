package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.OperLog;
import cn.edu.sicnu.service.OperLogService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.controller
 * @date 2020/11/30 18:24
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LogController {

    @Autowired
    private OperLogService operLogService;

    @Autowired
    private Message message;

    @PostMapping("/operlog/{id}")
    public Message findAll(@PathVariable String id) {
        List<OperLog> operLogs = operLogService.findAll();
        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(operLogs);
        if (id.equals("1234")) {

        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (OperLog operLog : operLogs) {
//            operLog.setCreateTime();
//        }
//        dateFormat.format()
//        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, OperLog.class);
//        StringBuilder res = new StringBuilder();
//        res.append("{\"resultCode\": \"0\", \"resultMsg\": \"请求成功\", \"data\":").append(operLogs).append("}");
        System.out.println(message);

        return message;
    }

    @DeleteMapping("/operlog/{id}")
    public Message deleteById(@PathVariable("id") String operLogId) {
        int i = operLogService.deleteById(operLogId);
        if (i == 1) {
            message.setResultCode(0);
            message.setResultMsg("请求成功");
            message.setData(null);
        } else {
            message.setResultCode(-1);
            message.setResultMsg("请求失败");
            message.setData(null);
        }
        return message;

    }
}
