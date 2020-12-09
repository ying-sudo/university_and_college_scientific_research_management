package cn.edu.sicnu.controller;

import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理异常,当系统出现异常时也能返回前端正确格式Message
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.handler
 * @date 2020/12/6 9:57
 */
@RestControllerAdvice
public class SysExceptionHandler {

    @Autowired
    Message message;

    /**
     * 空指针异常时
     *
     * @param e
     * @return message中状态码为-2
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Message nullPointerExceptionHandler(NullPointerException e) {
        return Message.missParam();
    }

    /**
     * 处理其他异常时
     *
     * @param e
     * @return message中状态码为-3
     */
    @ExceptionHandler(value = Exception.class)
    public Message otherExceptionHandler(Exception e) {
        return Message.error();
    }

}
