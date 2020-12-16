package cn.edu.sicnu.utils;

import cn.edu.sicnu.sercurity.utils.TokenManger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 日志切面，输出请求参数、返回结果、异常信息
 * 在controller返回结果后调用
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.utils
 * @date 2020/11/29 15:35
 */
@Aspect
@Component
public class LogUtils {
    //控制台输出logger
    private Logger logger;

    //系统日志logger，系统出现异常时调用
    private final org.slf4j.Logger systemLogger = LoggerFactory.getLogger("systemInfo");

    /**
     * 针对controller中所有public方法进行切面
     */
    @Pointcut("execution(public * cn.edu.sicnu.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 获取请求参数并打印
     *
     * @param joinPoint 连接点
     */
    @Before(value = "pointCut()")
    public void consoleLogParams(JoinPoint joinPoint) {
        this.logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.warn(String.valueOf(args));
    }

    /**
     * 获取返回结果并打印
     *
     * @param message 返回结果
     */
    @AfterReturning(value = "pointCut()", returning = "message")
    public void consoleLogReturnVal(Object message) {
        logger.warn(String.valueOf(message));
    }

    /**
     * 系统异常时打印，并向数据库中系统日志写入一条记录
     *
     * @param joinPoint 连接点
     * @param ex        异常对象
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void consoleLogException(JoinPoint joinPoint, Exception ex) {
        logger.error(ex.toString());
        MDC.clear();
        MDC.put("className", joinPoint.getTarget().getClass().getName());
        MDC.put("methodName", joinPoint.getSignature().getName());
        systemLogger.error(ex.toString());
        MDC.clear();
    }

    /**
     * 增加操作切点
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postPointCut() {
    }

    /**
     * 修改操作切点
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putPointCut() {
    }

    /**
     * 删除操作切点
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deletePointCut() {
    }

    /**
     * 在请求头中取得token，解析得到用户id，放入MDC中
     */
    @Before(value = "postPointCut() || putPointCut() || deletePointCut()")
    public void getUserId() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("authorization");
        if (token != null) {
            String userId = new TokenManger().getUserInfoFromToken(token);
            System.out.println(userId);
            MDC.clear();
            MDC.put("userId", userId);
        }

    }
}
