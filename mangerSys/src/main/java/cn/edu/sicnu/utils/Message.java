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

    //返回状态码，成功为0，失败为-1,数据格式错误为-2,系统异常为-3
    private int resultCode = -1;

    //返回消息
    private String resultMsg = "待处理";

    //返回的数据
    private Object data = null;

    /**
     * 数据格式错误时，返回的信息,状态码为-2
     *
     * @return
     */
    public static Message missParam() {
        return new Message(-2, "数据格式错误");
    }

    /**
     * 系统异常时返回的消息,状态码为-3
     *
     * @return
     */
    public static Message error() {
        return new Message(-3, "系统内部异常");
    }

    /**
     * 请求成功时返回的消息,状态码为0
     *
     * @param data
     * @return
     */
    public static Message success(Object data) {
        return new Message(0, "请求成功", data);
    }

    /**
     * 请求失败时返回的消息,状态码为-1
     *
     * @return
     */
    public static Message fail() {
        return new Message(-1, "请求失败", null);
    }

    /**
     * 请求失败时返回的消息，可以携带数据返回,状态码为-1
     *
     * @param data
     * @return
     */
    public static Message fail(Object data) {
        return new Message(-1, "请求失败", data);
    }


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
