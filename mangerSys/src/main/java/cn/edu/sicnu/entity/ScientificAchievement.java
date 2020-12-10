package cn.edu.sicnu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (ScientificAchievement)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:31
 */
public class ScientificAchievement implements Serializable {
    private static final long serialVersionUID = -14080332813216877L;

    private String id;

    private String name;

    private String collegeId;

//    表中无此字段，只是为了向前端返回方便
    private String collegeName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String beginDate;

    private String userId;

    //    表中无此字段，只是为了向前端返回方便
    private String userName;

    private String isTranslate;

    private String translateLanguage;

    private String firstDiscipline;

    private String discipline;

    private String characters;

    private String workSource;

    private String information;

    public ScientificAchievement() {
    }

    public ScientificAchievement(String id, String name, String collegeId,
                                 String beginDate, String userId, String isTranslate,
                                 String translateLanguage, String firstDiscipline, String discipline, String characters, String workSource, String information) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.beginDate = beginDate;
        this.userId = userId;
        this.isTranslate = isTranslate;
        this.translateLanguage = translateLanguage;
        this.firstDiscipline = firstDiscipline;
        this.discipline = discipline;
        this.characters = characters;
        this.workSource = workSource;
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

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getFirstDiscipline() {
        return firstDiscipline;
    }

    public void setFirstDiscipline(String firstDiscipline) {
        this.firstDiscipline = firstDiscipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getWorkSource() {
        return workSource;
    }

    public void setWorkSource(String workSource) {
        this.workSource = workSource;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "ScientificAchievement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", beginDate=" + beginDate +
                ", userId='" + userId + '\'' +
                ", isTranslate=" + isTranslate +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", discipline='" + discipline + '\'' +
                ", characters='" + characters + '\'' +
                ", workSource='" + workSource + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}