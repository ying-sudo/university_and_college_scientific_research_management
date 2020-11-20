package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (ScientificAchievement)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:36
 */
public class ScientificAchievement implements Serializable {
    private static final long serialVersionUID = -32295376486098416L;

    private String id;

    private String name;

    private String collegeId;

    private Date beginDate;

    private String scientificId;

    private String userId;

    private Object isTranslate;

    private String translateLanguage;

    private String firstDiscipline;

    private String discipline;

    private String characters;

    private String workSource;

    private String information;

    public ScientificAchievement() {
    }

    public ScientificAchievement(String id, String name, String collegeId, Date beginDate, String scientificId, String userId, Object isTranslate, String translateLanguage, String firstDiscipline, String discipline, String characters, String workSource, String information) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.beginDate = beginDate;
        this.scientificId = scientificId;
        this.userId = userId;
        this.isTranslate = isTranslate;
        this.translateLanguage = translateLanguage;
        this.firstDiscipline = firstDiscipline;
        this.discipline = discipline;
        this.characters = characters;
        this.workSource = workSource;
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

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getScientificId() {
        return scientificId;
    }

    public void setScientificId(String scientificId) {
        this.scientificId = scientificId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getIsTranslate() {
        return isTranslate;
    }

    public void setIsTranslate(Object isTranslate) {
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
                ", scientificId='" + scientificId + '\'' +
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