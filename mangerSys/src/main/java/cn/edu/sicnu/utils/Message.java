package cn.edu.sicnu.utils;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 返回前端格式消息类
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.utils
 * @date 2020/11/30 20:13
 */
@Component
public class Message implements Serializable {

    //返回状态码，成功为0，失败为-1
    private int resultCode = -1;

    //返回消息
    private String resultMsg = "待处理";

    //返回的数据
    private Object data = new Object();

    public Message() {
    }

    public Message(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Message(int resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
