package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Magazine)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:32
 */
public class Magazine implements Serializable {
    private static final long serialVersionUID = 956598807173408071L;

    private String id;

    private String name;

    private Object isShow;

    public Magazine() {
    }

    public Magazine(String id, String name, Object isShow) {
        this.id = id;
        this.name = name;
        this.isShow = isShow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getIsShow() {
        return isShow;
    }

    public void setIsShow(Object isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isShow=" + isShow +
                '}';
    }
}