package cn.edu.sicnu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (PatentAchievement)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:28
 */
public class PatentAchievement implements Serializable {
    private static final long serialVersionUID = -53004703122614833L;

    private String id;

    private String name;

    private String patentType;

    private String patentRange;

    private String collegeId;

    private String collegeName;

    private Integer state;

    private String applicationId;

    private String applicationDate;

    private String publicId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String publicDate;

    private String impowerId;

    private String impowerDate;

    private String userId;

    private String userName;

    private String information;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public PatentAchievement() {
    }

    public PatentAchievement(String id, String name, String patentType, String patentRange, String collegeId, Integer state, String applicationId, String applicationDate, String publicId, String publicDate, String impowerId, String impowerDate, String userId, String information) {
        this.id = id;
        this.name = name;
        this.patentType = patentType;
        this.patentRange = patentRange;
        this.collegeId = collegeId;
        this.state = state;
        this.applicationId = applicationId;
        this.applicationDate = applicationDate;
        this.publicId = publicId;
        this.publicDate = publicDate;
        this.impowerId = impowerId;
        this.impowerDate = impowerDate;
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

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentRange() {
        return patentRange;
    }

    public void setPatentRange(String patentRange) {
        this.patentRange = patentRange;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getImpowerId() {
        return impowerId;
    }

    public void setImpowerId(String impowerId) {
        this.impowerId = impowerId;
    }

    public String getImpowerDate() {
        return impowerDate;
    }

    public void setImpowerDate(String impowerDate) {
        this.impowerDate = impowerDate;
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
        return "PatentAchievement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", patentType='" + patentType + '\'' +
                ", patentRange='" + patentRange + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", state=" + state +
                ", applicationId='" + applicationId + '\'' +
                ", applicationDate=" + applicationDate +
                ", publicId='" + publicId + '\'' +
                ", publicDate=" + publicDate +
                ", impowerId='" + impowerId + '\'' +
                ", impowerDate=" + impowerDate +
                ", userId='" + userId + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}