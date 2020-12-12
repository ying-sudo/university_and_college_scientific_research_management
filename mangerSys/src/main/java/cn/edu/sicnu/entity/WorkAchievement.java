package cn.edu.sicnu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (WorkAchievement)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:43
 */
public class WorkAchievement implements Serializable {
    private static final long serialVersionUID = 271155200618951498L;

    private String id;

    private String name;

    private String publisher;

    private String publishLevel;

    private String workType;

    private String publishLocation;

    private String isbnId;

    private String isTranslate;

    private String translateLanguage;

    private String discipline;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginDate;

    private String characters;

    private String firstDiscipline;

    private String collegeId;

    private String collegeName;

    private String workSource;

    private String userId;

    private String userName;

    private String information;

    public WorkAchievement() {
    }

    public WorkAchievement(String id, String name, String publisher, String publishLevel, String workType,
                           String publishLocation, String isbnId, String isTranslate, String translateLanguage,
                           String discipline, String beginDate, String characters, String firstDiscipline,
                           String collegeId, String workSource, String userId, String information) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.publishLevel = publishLevel;
        this.workType = workType;
        this.publishLocation = publishLocation;
        this.isbnId = isbnId;
        this.isTranslate = isTranslate;
        this.translateLanguage = translateLanguage;
        this.discipline = discipline;
        this.beginDate = beginDate;
        this.characters = characters;
        this.firstDiscipline = firstDiscipline;
        this.collegeId = collegeId;
        this.workSource = workSource;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishLevel() {
        return publishLevel;
    }

    public void setPublishLevel(String publishLevel) {
        this.publishLevel = publishLevel;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getPublishLocation() {
        return publishLocation;
    }

    public void setPublishLocation(String publishLocation) {
        this.publishLocation = publishLocation;
    }

    public String getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(String isbnId) {
        this.isbnId = isbnId;
    }

    public String getIsTranslate() {
        return isTranslate;
    }

    public void setIsTranslate(String isTranslate) {
        this.isTranslate = isTranslate;
    }

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    public void setTranslateLanguage(String translateLanguage) {
        this.translateLanguage = translateLanguage;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getBeginDate() {
        return beginDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
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

    public String getWorkSource() {
        return workSource;
    }

    public void setWorkSource(String workSource) {
        this.workSource = workSource;
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

    @Override
    public String toString() {
        return "WorkAchievement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishLevel='" + publishLevel + '\'' +
                ", workType='" + workType + '\'' +
                ", publishLocation='" + publishLocation + '\'' +
                ", isbnId='" + isbnId + '\'' +
                ", isTranslate='" + isTranslate + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", discipline='" + discipline + '\'' +
                ", beginDate=" + beginDate +
                ", characters='" + characters + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", workSource='" + workSource + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}