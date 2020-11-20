package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Team)实体类
 *
 * @author makejava
 * @since 2020-11-19 23:25:38
 */
public class Team implements Serializable {
    private static final long serialVersionUID = 172806909084170054L;

    private String id;

    private String name;

    private String userId;

    private String researchDiection;

    private String discipline;

    private String firstDiscipline;

    private Date foundingTime;

    private String phone;

    private String information;

    public Team() {
    }

    public Team(String id, String name, String userId, String researchDiection, String discipline, String firstDiscipline, Date foundingTime, String phone, String information) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.researchDiection = researchDiection;
        this.discipline = discipline;
        this.firstDiscipline = firstDiscipline;
        this.foundingTime = foundingTime;
        this.phone = phone;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResearchDiection() {
        return researchDiection;
    }

    public void setResearchDiection(String researchDiection) {
        this.researchDiection = researchDiection;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getFirstDiscipline() {
        return firstDiscipline;
    }

    public void setFirstDiscipline(String firstDiscipline) {
        this.firstDiscipline = firstDiscipline;
    }

    public Date getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", researchDiection='" + researchDiection + '\'' +
                ", discipline='" + discipline + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", foundingTime=" + foundingTime +
                ", phone='" + phone + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}