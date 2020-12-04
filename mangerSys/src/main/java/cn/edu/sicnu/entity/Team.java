package cn.edu.sicnu.entity;

import java.io.Serializable;

/**
 * (Team)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
public class Team implements Serializable {
    private static final long serialVersionUID = -12034809227612385L;

    private String id;

    private String name;

    private String userId;

    //对应表中无该字段，只是为了方便发送给前端而添加
    private String userName;

    private String researchDiection;

    private String discipline;

    private String firstDiscipline;

    private String foundingTime;

    private String phone;

    private String information;

    public Team() {
    }

    public Team(String id, String name, String userId,
                String userName, String researchDiection, String discipline,
                String firstDiscipline, String foundingTime,
                String phone, String information) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.userName = userName;
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

    public String getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(String foundingTime) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", researchDiection='" + researchDiection + '\'' +
                ", discipline='" + discipline + '\'' +
                ", firstDiscipline='" + firstDiscipline + '\'' +
                ", foundingTime='" + foundingTime + '\'' +
                ", phone='" + phone + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}