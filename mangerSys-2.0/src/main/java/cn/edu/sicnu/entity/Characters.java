package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Characters)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:23
 */
public class Characters implements Serializable {
    private static final long serialVersionUID = -27052893738586051L;

    private String id;

    private String name;

    private String note;

    public Characters() {
    }

    public Characters(String id, String name, String note) {
        this.id = id;
        this.name = name;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}