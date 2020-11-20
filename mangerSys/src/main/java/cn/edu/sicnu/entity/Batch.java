package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Batch)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:22
 */
public class Batch implements Serializable {
    private static final long serialVersionUID = 398542907102297172L;

    private String id;

    private String name;

    private Date beginDate;

    private Date endData;

    private Integer state;

    private String collegeId;

    private String path;

    private String note;

    public Batch() {
    }

    public Batch(String id, String name, Date beginDate, Date endData, Integer state, String collegeId, String path, String note) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.endData = endData;
        this.state = state;
        this.collegeId = collegeId;
        this.path = path;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", endData=" + endData +
                ", state=" + state +
                ", collegeId='" + collegeId + '\'' +
                ", path='" + path + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}