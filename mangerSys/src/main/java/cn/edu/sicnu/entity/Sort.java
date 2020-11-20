package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Sort)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:37
 */
public class Sort implements Serializable {
    private static final long serialVersionUID = -61608419906649689L;

    private String id;

    private String name;

    private String value;

    private String note;

    public Sort() {
    }

    public Sort(String id, String name, String value, String note) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.note = note;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}