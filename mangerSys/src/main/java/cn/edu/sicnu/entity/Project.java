package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:29
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 868222056936148062L;

    private String id;

    private String name;

    private String userId;

    private String collegeId;

    private String discipline;

    private String characters;

    private String firstDiscipline;

    private String level;

    private String sort;

    private Date beginDate;

    private Date endDate;

    private Double requestFund;

    private Double arrivalFund;

    private Integer state;

    private String information;

    private String approvalNumber;

    public Project() {
    }

    public Project(String id, String name, String userId, String collegeId, String discipline, String characters, String firstDiscipline, String level, String sort, Date beginDate, Date endDate, Double requestFund, Double arrivalFund, Integer state, String information, String approvalNumber) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.collegeId = collegeId;
        this.discipline = discipline;
        this.characters = characters;
        this.firstDiscipline = firstDiscipline;
        this.level = level;
        this.sort = sort;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.requestFund = requestFund;
        this.arrivalFund = arrivalFund;
        this.state = state;
        this.information = information;
        this.approvalNumber = approvalNumber;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
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

    public String getFirstDiscipline() {
        return firstDiscipline;
    }

    public void setFirstDiscipline(String firstDiscipline) {
        this.firstDiscipline = firstDiscipline;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getRequestFund() {
        return requestFund;
    }

    public void setRequestFund(Double requestFund) {
        this.requestFund = requestFund;
    }

    public Double getArrivalFund() {
        return arrivalFund;
    }

    public void setArrivalFund(Double arrivalFund) {
        this.arrivalFund = arrivalFund;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", discipline='" + discipline + '\'' +
                ", characters='" + characters + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", level='" + level + '\'' +
                ", sort='" + sort + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", requestFund=" + requestFund +
                ", arrivalFund=" + arrivalFund +
                ", state=" + state +
                ", information='" + information + '\'' +
                ", approvalNumber='" + approvalNumber + '\'' +
                '}';
    }

}