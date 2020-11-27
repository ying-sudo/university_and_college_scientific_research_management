package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (PaperAchievement)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:28
 */
public class PaperAchievement implements Serializable {
    private static final long serialVersionUID = -50121982901339184L;

    private String id;

    private String name;

    private Date beginDate;

    private String paperType;

    private String recordId;

    private String descipline;

    private String firstDiscipline;

    private String collegeId;

    private String paperSource;

    private String userId;

    private String information;

    public PaperAchievement() {
    }

    public PaperAchievement(String id, String name, Date beginDate, String paperType, String recordId, String descipline, String firstDiscipline, String collegeId, String paperSource, String userId, String information) {
        this.id = id;
        this.name = name;
        this.beginDate = beginDate;
        this.paperType = paperType;
        this.recordId = recordId;
        this.descipline = descipline;
        this.firstDiscipline = firstDiscipline;
        this.collegeId = collegeId;
        this.paperSource = paperSource;
        this.userId = userId;
        this.information = information;
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

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDescipline() {
        return descipline;
    }

    public void setDescipline(String descipline) {
        this.descipline = descipline;
    }

    public String getFirstDiscipline() {
        return firstDiscipline;
    }

    public void setFirstDiscipline(String firstDiscipline) {
        this.firstDiscipline = firstDiscipline;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getPaperSource() {
        return paperSource;
    }

    public void setPaperSource(String paperSource) {
        this.paperSource = paperSource;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "PaperAchievement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", beginDate=" + beginDate +
                ", paperType='" + paperType + '\'' +
                ", recordId='" + recordId + '\'' +
                ", descipline='" + descipline + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", paperSource='" + paperSource + '\'' +
                ", userId='" + userId + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}