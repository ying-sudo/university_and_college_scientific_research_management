package cn.edu.sicnu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-11-20 22:47:42
 */
public class User implements Serializable {
    private static final long serialVersionUID = -94969933867965484L;

    private String id;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String idNumber;

    private String collegeId;

    private Date register;

    private String note;

    private String sex;

    private Date birthDate;

    private String post;

    public User() {
    }

    public User(String id, String password, String name, String phone, String email, String idNumber, String collegeId, Date register, String note, String sex, Date birthDate, String post) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.idNumber = idNumber;
        this.collegeId = collegeId;
        this.register = register;
        this.note = note;
        this.sex = sex;
        this.birthDate = birthDate;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", register=" + register +
                ", note='" + note + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", post='" + post + '\'' +
                '}';
    }
}