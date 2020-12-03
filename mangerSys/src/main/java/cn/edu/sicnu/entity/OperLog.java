package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.entity
 * @date 2020/11/30 17:53
 */
public class OperLog implements Serializable {
    private Integer operLogId;
    private String className;
    private String methodName;
    private String createTime;
    private String logLevel;
    private String userId;
    private String message;

    public OperLog() {
    }

    public OperLog(Integer operLogId, String className, String methodName,
                   String createTime, String logLevel, String userId, String message) {
        this.operLogId = operLogId;
        this.className = className;
        this.methodName = methodName;
        this.createTime = createTime;
        this.logLevel = logLevel;
        this.userId = userId;
        this.message = message;
    }

    public Integer getOperLogId() {
        return operLogId;
    }

    public void setOperLogId(Integer operLogId) {
        this.operLogId = operLogId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
