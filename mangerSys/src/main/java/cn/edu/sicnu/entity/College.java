package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (College)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:30
 */
public class College implements Serializable {
    private static final long serialVersionUID = -57557317036261792L;

    private String id;

    private String location;

    private String name;

    private Integer snumber;

    private String information;

    private Integer state;

    public College() {
    }

    public College(String id, String location, String name, Integer snumber, String information, Integer state) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.snumber = snumber;
        this.information = information;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "College{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", snumber=" + snumber +
                ", information='" + information + '\'' +
                ", state=" + state +
                '}';
    }
}