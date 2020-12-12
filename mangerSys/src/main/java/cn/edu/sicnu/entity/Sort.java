package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Sort)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:32
 */
public class Sort implements Serializable {
    private static final long serialVersionUID = 829734356605213819L;

    private Integer id;

    private String name;

    private String value;

    private String note;

    public Sort() {
    }

    public Sort(Integer id, String name, String value, String note) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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